package me.gacl.dao;

import java.util.List;
import me.gacl.domain.SchoolAdmissionScore;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 13:59
 */
public interface SchoolAdmissionScoreMapper {

  /**
   * 查询学校录取分数
   * @param schoolAdmissionScore
   * @return
   */
  SchoolAdmissionScore verifyScore(SchoolAdmissionScore schoolAdmissionScore);

  /**
   * 根据平均分选学校，稳健选择
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolAdmissionScore> selectSchoolsByAverageScore(@Param("province") String  province,@Param("year") String year,@Param("maxScore") int maxScore,@Param("minScore")int minScore);

  /**
   * 根据最低分选学校，风险选择
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolAdmissionScore> selectSchoolsByMinScore(@Param("province") String  province,@Param("year") String year,@Param("maxScore") int maxScore,@Param("minScore")int minScore);


  /**
   * 添加学校录取分数
   * @param schoolAdmissionScore
   * @return
   */
  int  insertSchoolAdmissionScore(SchoolAdmissionScore schoolAdmissionScore);
}
