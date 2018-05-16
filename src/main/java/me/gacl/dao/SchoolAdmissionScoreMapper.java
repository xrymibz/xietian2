package me.gacl.dao;

import me.gacl.domain.SchoolAdmissionScore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 8:55
 */
public interface SchoolAdmissionScoreMapper {


  /**
   * 查询用户注册帐号是否重复
   * @param schoolAdmissionScore
   * @return
   */
  SchoolAdmissionScore verifyScore(SchoolAdmissionScore schoolAdmissionScore);


  /**
   * 添加用户的账户密码
   * @param schoolAdmissionScore
   * @return
   */
  int  insertSchoolAdmissionScore(SchoolAdmissionScore schoolAdmissionScore);
} 
