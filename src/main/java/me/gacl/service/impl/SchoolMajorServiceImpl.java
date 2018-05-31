package me.gacl.service.impl;

import java.util.List;
import me.gacl.dao.SchoolMajorMapper;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolMajor;
import me.gacl.service.SchoolMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-31
 * Time: 10:39
 */
@Service("schoolMajorService")
public class SchoolMajorServiceImpl implements SchoolMajorService {

  @Autowired
  SchoolMajorMapper schoolMajorMapper;

  public SchoolMajor verifyScore(SchoolMajor schoolMajor) {
    SchoolMajor major = schoolMajorMapper.verifyMajor(schoolMajor);

    return major;
  }

  public boolean insertSchoolMajor(SchoolMajor schoolMajor) {

    //幂等校验
    if (verifyScore(schoolMajor) != null) {
      System.out.printf("该数据已经存在，跳过存储  " + schoolMajor.toString());
      return true;
    }else{
      int  res = schoolMajorMapper.insertSchoolMajor(schoolMajor);
      System.out
          .println("插入成功,学校代码 ： " + schoolMajor.getSchoolName() +"专业 : " + schoolMajor.getMajor());
      System.out.printf(schoolMajor.getSchoolName() + ", "
          + schoolMajor.getYear() + ", "
          + schoolMajor.getProvince());
      return res > 0;
    }

  }

  public List<SchoolMajor> selectSchoolsByAvegareScore(String schoolName, String province,
      String year, int maxScore, int minScore) {
    SchoolAdmissionScore schoolAdmissionScore = new SchoolAdmissionScore();
    schoolAdmissionScore.setProvince(province);
    schoolAdmissionScore.setYear(year);
    return schoolMajorMapper
        .selectMajorsByAverageScore(schoolName, province, year, maxScore, minScore);
  }

  public List<SchoolMajor> selectSchoolsByMinScore(String schoolName, String province, String year,
      int maxScore, int minScore) {
    SchoolAdmissionScore schoolAdmissionScore = new SchoolAdmissionScore();
    schoolAdmissionScore.setProvince(province);
    schoolAdmissionScore.setYear(year);
    return schoolMajorMapper.selectMajorsByMinScore(schoolName, province, year, maxScore, minScore);
  }
}
