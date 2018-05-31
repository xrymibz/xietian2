package me.gacl.service;

import java.util.List;
import me.gacl.domain.SchoolMajor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-31
 * Time: 10:26
 */
public interface SchoolMajorService {

  /**
   *
   * 查询学校专业录取分数
   * @param schoolMajor
   * @return
   */
  SchoolMajor verifyScore(SchoolMajor schoolMajor);

  /**
   * 插入录取专业分数
   * @param schoolMajor
   * @return
   */
  boolean insertSchoolMajor(SchoolMajor schoolMajor);

  /**
   * 根据平均分数取学校专业
   * @param schoolName
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolMajor> selectSchoolsByAvegareScore(String schoolName,String province ,String year, int maxScore, int minScore);

  /**
   * 根据最低分数取学校专业
   * @param schoolName
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolMajor> selectSchoolsByMinScore(String schoolName,String province ,String year, int maxScore, int minScore);
} 
