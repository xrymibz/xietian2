package com;

import java.util.List;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.ScoreRanking;
import me.gacl.service.ProvinceCodeMappingService;
import me.gacl.service.SchoolCodeMappingService;
import me.gacl.service.ScoreRankingService;
import me.gacl.service.ScoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-21
 * Time: 9:04
 */
public class SchoolSeek {

  public static void main(String[]args){

    ApplicationContext ac = new ClassPathXmlApplicationContext(
        new String[] { "spring.xml", "spring-mybatis.xml" });
    ProvinceCodeMappingService provinceCodeMappingService = (ProvinceCodeMappingService) ac
        .getBean("provinceCodeMappingService");
    SchoolCodeMappingService schoolCodeMappingService = (SchoolCodeMappingService) ac
        .getBean("schoolCodeMappingService");
    ScoreService scoreService = (ScoreService) ac.getBean("scoreService");
    ScoreRankingService scoreRankingService = (ScoreRankingService) ac
        .getBean("scoreRankingService");


    //输入省份
    String province = "四川";
    //输入分数
    int score = 516;
    //输入年份
    String year = "2018";
    //输入允许的分数误差范围
    int gap = 15;

    //开始预测数据
    System.out.println("------------------------------");
    //根据分数获取排名
    ScoreRanking scoreRanking = new ScoreRanking();
    scoreRanking.setScore(score);
    scoreRanking.setYear(year);
    scoreRanking.setProvince(province);
    //排名
//    ScoreRanking res = scoreRankingService.selectRankingbyScore(scoreRanking);
    int ranking = 7800;
    //根据排名获取分数
    scoreRanking.setRanking(ranking);
    System.out.println("--------------考生信息----------------");
    System.out.println("年度 : " + year);
    System.out.println("省份 : " + province);
    System.out.println("分数 : " + score);
    System.out.println("该分数的排名是 : " + ranking);

    //获取前三年的数据
    int years = Integer.parseInt(year);
    for(int i=years-1;i>=years-3;i--){
      System.out.println("----------------------------第 " + i +"年的数据--------------------------");

      scoreRanking.setYear(i+"");
      //分数
      ScoreRanking res2 = scoreRankingService.selectScorebyRanking(scoreRanking);
      if(res2 == null){
        continue;
      }
      int score2 = res2.getScore();
      System.out.println("相当于"+i+"年的分数 ： " +score2 );

      int maxScore = score2 + gap;
      int minScore = score2 - gap;

      List<SchoolAdmissionScore> schoolAdmissionScores = scoreService.selectSchoolsByAvegareScore(province,i+"",maxScore,minScore);
      System.out.println("-----------稳健的学校选择--------------");
      for(SchoolAdmissionScore item : schoolAdmissionScores){
        System.out.println(item.getSchoolName() + " 均分 ：" + item.getAverageScore() +"   最高分 :" + item.getMaxScore() + "最低分 :" + item.getMinScore());
      }

      List<SchoolAdmissionScore> schoolAdmissionScore2 = scoreService.selectSchoolsByMinScore(province,i+"",maxScore,minScore);
      System.out.println("-----------具有风险的学校选择--------------");
      for(SchoolAdmissionScore item : schoolAdmissionScore2){
        System.out.println(item.getSchoolName() + " 均分 ：" + item.getAverageScore() +"   最高分 :" + item.getMaxScore() + "最低分 :" + item.getMinScore());
      }

    }
  }

} 
