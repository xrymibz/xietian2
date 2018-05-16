package me.gacl.service;

import me.gacl.domain.Account;
import me.gacl.domain.SchoolAdmissionScore;

/**
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
} 
