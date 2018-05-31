package me.gacl.dao;

import java.util.List;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolMajor;
import org.apache.ibatis.annotations.Param;

/**
 *  学校专业操作dao映射
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-31
 * Time: 10:23
 */
public interface SchoolMajorMapper {

  /**
   * 查询学校专业录取分数
   * @param schoolMajor
   * @return
   */
  SchoolMajor verifyMajor(SchoolMajor schoolMajor);

  /**
   * 根据平均分选学校专业，稳健选择
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolMajor> selectMajorsByAverageScore(@Param("SchoolName") String schoolName,@Param("province") String  province,@Param("year") String year,@Param("maxScore") int maxScore,@Param("minScore")int minScore);

  /**
   * 根据最低分选学校专业，风险选择
   * @param province
   * @param year
   * @param maxScore
   * @param minScore
   * @return
   */
  List<SchoolMajor> selectMajorsByMinScore(@Param("SchoolName") String schoolName,@Param("province") String  province,@Param("year") String year,@Param("maxScore") int maxScore,@Param("minScore")int minScore);


  /**
   * 添加学校专业信息
   * @param schoolMajor
   * @return
   */
  int  insertSchoolMajor(SchoolMajor schoolMajor);
} 
