package com.acquireData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.gacl.domain.ProvinceCode;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolCode;
import me.gacl.service.ProvinceCodeMappingService;
import me.gacl.service.SchoolCodeMappingService;
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
 * Date: 2018-05-16
 * Time: 7:56
 */
public class AcquireSchoolData {

    private Document                  document;

    /** 省份代码映射 */
    public static Map<String, String> provinceCodeMap = new HashMap<String, String>(32);

    public static void main(String args[]) {

        ApplicationContext ac = new ClassPathXmlApplicationContext(
            new String[] { "spring.xml", "spring-mybatis.xml" });
        ProvinceCodeMappingService provinceCodeMappingService = (ProvinceCodeMappingService) ac
            .getBean("provinceCodeMappingService");
        SchoolCodeMappingService schoolCodeMappingService = (SchoolCodeMappingService) ac
            .getBean("schoolCodeMappingService");
        ScoreService scoreService = (ScoreService) ac.getBean("scoreService");

        System.out.println("-----加载各省份代码缓存-----");
        //加载省份缓存映射
        List<ProvinceCode> list = provinceCodeMappingService.verifyAllProvinceCodes();
        for (ProvinceCode provinceCode : list) {
            provinceCodeMap.put(provinceCode.getProvinceCode(), provinceCode.getProvinceName());
        }

        //  获取学校代码
      System.out.println("-----获取学校代码-----");
      for (int i = 200; i < 1000; i++) {
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
            for (int j= 10000;j<10032;j++) {

                if(j==10020){
                  //台湾省不参加高考
                  continue;
                }
                //省份代码
                String provinceCode = j+"";
                //省份名称
                String provinceName = provinceCodeMap.get(provinceCode);

              System.out.println("访问开始 ：" + provinceCode + "  " + provinceName+"  "+schoolCode +"  "+schoolName);
                String url = "http://gkcx.eol.cn/schoolhtm/scores/provinceScores" + schoolCode + "_"
                             + provinceCode + "_10035_10037.xml";
              System.out.println("访问完成 ：" + provinceCode + "  " + provinceName);
                String xmlStr = HttpClient4.doGet(url);
                if(xmlStr.indexOf("高考")>0||xmlStr.indexOf("错误")>0){
                  //网页错了，过滤
                  System.out.println("---网页错了，过滤---,schoolCode = "+schoolCode +"  provinceCode :" + provinceCode);
                  continue;
                }
//              System.out.println(xmlStr);
                try {
                    Document document = DocumentHelper.parseText(xmlStr);

                    //                    System.out.println(document.toString());
                    for (Object object : document.getRootElement().elements()) {
                        Element element = (Element) object;

                        if( element.element("year") ==null){
                          System.out.println(xmlStr);
                        }
                        String year = element.element("year").getStringValue();
                        int maxScore = string2int(element.element("maxScore").getStringValue());
                        int avgScore = string2int(element.element("avgScore").getStringValue());
                        int minScore = string2int(element.element("minScore").getStringValue());


                        SchoolAdmissionScore schoolAdmissionScore = new SchoolAdmissionScore();
                        schoolAdmissionScore.setSchoolCode(schoolCode);
                        schoolAdmissionScore.setSchoolName(schoolName);
                        schoolAdmissionScore.setProvince(provinceName);
                        schoolAdmissionScore.setYear(year);
                        schoolAdmissionScore.setMaxScore(maxScore);
                        schoolAdmissionScore.setAverageScore(avgScore);
                        schoolAdmissionScore.setMinScore(minScore);
                        schoolAdmissionScore.setBatch("二本");


                      boolean res = scoreService.insertSchoolAdmissionScore(schoolAdmissionScore);
                        if (res) {
                            System.out
                                .println("插入成功,学校代码 ： " + schoolAdmissionScore.getSchoolCode());
                            System.out.printf(schoolAdmissionScore.getSchoolName() + ", "
                                              + schoolAdmissionScore.getYear() + ", "
                                              + schoolAdmissionScore.getProvince());
                        } else {
                            System.out
                                .println("插入失败,学校代码 ： " + schoolAdmissionScore.getSchoolCode());
                            System.out.printf(schoolAdmissionScore.getSchoolName() + ", "
                                              + schoolAdmissionScore.getYear() + ", "
                                              + schoolAdmissionScore.getProvince());
                            return;
                        }
                        System.out.println("-------------------");

                    }
                } catch (DocumentException e) {

                }
            }
        }
    }
    public static int string2int(String n){
      if("--".equals(n)){
        return 0;
      }else{
        try {
          return Integer.parseInt(n);
        }catch (Exception e){
          return 0;
        }
      }
    }
}
