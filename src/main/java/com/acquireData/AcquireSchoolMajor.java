package com.acquireData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.gacl.domain.ProvinceCode;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolCode;
import me.gacl.domain.SchoolMajor;
import me.gacl.service.ProvinceCodeMappingService;
import me.gacl.service.SchoolCodeMappingService;
import me.gacl.service.SchoolMajorService;
import me.gacl.service.ScoreService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-31
 * Time: 10:05
 */
public class AcquireSchoolMajor {

  private Document document;

  /** 省份代码映射 */
  public static Map<String, String> provinceCodeMap = new HashMap<String, String>(32);

  public static void main(String args[]) {

    ApplicationContext ac = new ClassPathXmlApplicationContext(
        new String[]{"spring.xml", "spring-mybatis.xml"});
    ProvinceCodeMappingService provinceCodeMappingService = (ProvinceCodeMappingService) ac
        .getBean("provinceCodeMappingService");
    SchoolCodeMappingService schoolCodeMappingService = (SchoolCodeMappingService) ac
        .getBean("schoolCodeMappingService");
    SchoolMajorService schoolMajorService = (SchoolMajorService) ac.getBean("schoolMajorService");

    System.out.println("-----加载各省份代码缓存-----");
    //加载省份缓存映射
    List<ProvinceCode> list = provinceCodeMappingService.verifyAllProvinceCodes();
    for (ProvinceCode provinceCode : list) {
      provinceCodeMap.put(provinceCode.getProvinceCode(), provinceCode.getProvinceName());
    }

    //  获取学校代码
    System.out.println("-----获取学校代码-----");
    for (int i = 133; i < 200; i++) {
      String schoolCode = i + "";
      SchoolCode school = new SchoolCode();
      school.setSchoolCode(schoolCode);
      SchoolCode schoolCode1 = schoolCodeMappingService.verifySchoolCode(school);
      //过滤掉不存在的学校
      if (schoolCode1 == null) {
        continue;
      }
      String schoolName = schoolCode1.getSchoolName();
      //遍历每个省
      for (int j = 10000; j < 10032; j++) {

        if (j == 10020) {
          //台湾省不参加高考
          continue;
        }
        //区分文理科
        for (int k = 10034; k <= 10035; k++) {

          //省份代码
          String provinceCode = j + "";
          //省份名称
          String provinceName = provinceCodeMap.get(provinceCode);
          //文理科
          String artsAndScience = (k == 10034 ? "文科" : "理科");

          System.out.println(
              "访问开始 ：" + provinceCode + "  " + provinceName + "  " + schoolCode + "  "
                  + schoolName);
          String url =
              "https://gkcx.eol.cn/commonXML/schoolSpecialPoint/schoolSpecialPoint" + i + "_" + j
                  + "_" + k + ".xml";
          String xmlStr = HttpClient4.doGet(url);
          System.out.println("访问完成 ：" + provinceCode + "  " + provinceName);
          if (xmlStr.indexOf("高考") > 0 || xmlStr.indexOf("错误") > 0) {
            //网页错了，过滤
            System.out.println(
                "---网页错了，过滤---,schoolCode = " + schoolCode + "  provinceCode :" + provinceCode);
            continue;
          }
//              System.out.println(xmlStr);
          try {
            Document document = DocumentHelper.parseText(xmlStr);

            //                    System.out.println(document.toString());
            for (Object object : document.getRootElement().elements()) {
              Element element = (Element) object;

              if (element.element("year") == null) {
                System.out.println(xmlStr);
              }
              String year = element.element("year").getStringValue();
              String major = element.element("specialname").getStringValue();
              String batch = element.element("pc").getStringValue();

              int maxScore = string2int(element.element("maxfs").getStringValue());
              int avgScore = string2int(element.element("varfs").getStringValue());
              int minScore = string2int(element.element("minfs").getStringValue());

              SchoolMajor schoolMajor = new SchoolMajor();
              schoolMajor.setSchoolName(schoolName);
              schoolMajor.setProvince(provinceName);
              schoolMajor.setMajor(major);
              schoolMajor.setCategory(artsAndScience);
              schoolMajor.setYear(year);
              schoolMajor.setMaxValue(maxScore);
              schoolMajor.setAverageValue(avgScore);
              schoolMajor.setMinValue(minScore);
              schoolMajor.setBatch(batch);

              boolean res = schoolMajorService.insertSchoolMajor(schoolMajor);
              if (!res) {
                System.out
                    .println("插入失败,学校代码 ： " + schoolMajor.getSchoolName());
                System.out.printf(schoolMajor.getSchoolName() + ", "
                    + schoolMajor.getYear() + ", "
                    + schoolMajor.getProvince());
                return;
              }
              System.out.println("-------------------");

            }
          } catch (DocumentException e) {

          }
        }
      }
    }
  }

  public static int string2int(String n) {
    if ("--".equals(n)) {
      return 0;
    } else {
      try {
        return Integer.parseInt(n);
      } catch (Exception e) {
        return 0;
      }
    }
  }
} 
