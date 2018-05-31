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

    return schoolMajor;
  }

  public boolean insertSchoolMajor(SchoolMajor schoolMajor) {
    int res = schoolMajorMapper.insertSchoolMajor(schoolMajor);

    return res > 0;

  }

  public List<SchoolMajor> selectSchoolsByAvegareScore(String schoolName, String province,
      String year, int maxScore, int minScore) {
    SchoolAdmissionScore  schoolAdmissionScore = new SchoolAdmissionScore();
    schoolAdmissionScore.setProvince(province);
    schoolAdmissionScore.setYear(year);
    return schoolMajorMapper.selectMajorsByAverageScore(schoolName,province,year,maxScore,minScore);
  }

  public List<SchoolMajor> selectSchoolsByMinScore(String schoolName, String province, String year,
      int maxScore, int minScore) {
    SchoolAdmissionScore  schoolAdmissionScore = new SchoolAdmissionScore();
    schoolAdmissionScore.setProvince(province);
    schoolAdmissionScore.setYear(year);
    return schoolMajorMapper.selectMajorsByMinScore(schoolName,province,year,maxScore,minScore);
  }
}
