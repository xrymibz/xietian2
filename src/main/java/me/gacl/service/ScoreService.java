package me.gacl.service;

import java.util.List;
import me.gacl.domain.SchoolAdmissionScore;

/**
 * 学校录取分数处理器
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 9:00
 */
public interface ScoreService {


  /**
   *
   * 查询学校录取分数
   * @param schoolAdmissionScore
   * @return
   */
  SchoolAdmissionScore verifyScore(SchoolAdmissionScore schoolAdmissionScore);

  /**
   * 插入录取分数
   * @param schoolAdmissionScore
   * @return
   */
  boolean insertSchoolAdmissionScore(SchoolAdmissionScore schoolAdmissionScore);

  /**
   * 根据平均分数取学校
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolAdmissionScore> selectSchoolsByAvegareScore(String province ,String year, int maxScore, int minScore);

  /**
   * 根据最低分数取学校
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolAdmissionScore> selectSchoolsByMinScore(String province ,String year, int maxScore, int minScore);
} 
