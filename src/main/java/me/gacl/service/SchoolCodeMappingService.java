package me.gacl.service;

import me.gacl.dao.SchoolAdmissionScoreMapper;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学校映射关系处理器
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 14:14
 */
public interface SchoolCodeMappingService {

  /**
   *
   * 查询学校映射
   * @param schoolCode
   * @return
   */
  SchoolCode verifySchoolCode(SchoolCode schoolCode);

  /**
   * 插入学校映射
   * @param schoolCode
   * @return
   */
  boolean insertSchoolCode(SchoolCode schoolCode);
}
