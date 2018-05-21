package com.acquireData;

import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolCode;
import me.gacl.service.SchoolCodeMappingService;
import me.gacl.service.ScoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 14:20
 */
public class AquireSchoolCode {
  public  static void main(String []args){
    ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" });
    SchoolCodeMappingService schoolCodeMappingService = (SchoolCodeMappingService) ac.getBean("schoolCodeMappingService");
    for(int i=3470;i<6000;i++){

      String  url = "http://gkcx.eol.cn/schoolhtm/schoolTemple/school"+i+".htm";
      String res = HttpClient4.doGet(url);
      int a = res.indexOf("content");
      int b = res.indexOf(",",a+9);

      if(b<0){
        System.out.printf("b = " + b);
        continue;
      }
      String schoolName = res.substring(a+9,b);
      if(schoolName.length()>0 && schoolName.length() <30){
        System.out.println(schoolName +"  :   " + i);
        SchoolCode schoolCode = new SchoolCode();
        schoolCode.setSchoolCode(i+"");
        schoolCode.setSchoolName(schoolName);
        schoolCodeMappingService.insertSchoolCode(schoolCode);
      }else{
        System.out.println("没有数据 ： " + i);
      }
    }




  }

} 
