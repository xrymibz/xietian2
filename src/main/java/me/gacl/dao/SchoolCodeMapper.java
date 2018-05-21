package me.gacl.dao;

import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolCode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 8:55
 */
public interface SchoolCodeMapper {


  /**
   * 学校代码查询
   * @param schoolCode
   * @return
   */
  SchoolCode verifySchoolCode(SchoolCode schoolCode);


  /**
   * 添加学校代码
   * @param schoolCode
   * @return
   */
  int  insertSchoolCode(SchoolCode schoolCode);
}
