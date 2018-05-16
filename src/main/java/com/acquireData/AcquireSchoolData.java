package com.acquireData;

import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.service.ScoreService;
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

//  private Document document;

  public static void main(String args[]){

    ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" });
    ScoreService scoreService = (ScoreService) ac.getBean("scoreService");
    SchoolAdmissionScore schoolAdmissionScore = new SchoolAdmissionScore();
    schoolAdmissionScore.setSchoolCode("99");
    schoolAdmissionScore.setProvince("四川");
    schoolAdmissionScore.setYear("2008");
    scoreService.insertSchoolAdmissionScore(schoolAdmissionScore);



//    System.out.println("");
//    String url = "http://gkcx.eol.cn/schoolhtm/scores/provinceScores57_10003_10035_10036.xml";
//    String res = HttpClient4.doGet(url);
////    System.out.println(res);
//
//    String xmlStr = res;
//    try {
//      Document document = document;
//      System.out.println(document.toString());
//      Element res2 = document.getRootElement().element("score");
//
//      String ss = res2.toString();
//      System.out.println(res2);
//    } catch (DocumentException e) {
//
//    }
  }
} 
