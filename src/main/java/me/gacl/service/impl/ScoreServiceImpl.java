package me.gacl.service.impl;

import me.gacl.dao.SchoolAdmissionScoreMapper;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 9:02
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {


  @Autowired
  SchoolAdmissionScoreMapper schoolAdmissionScoreMapper;

  public SchoolAdmissionScore verifyScore(SchoolAdmissionScore schoolAdmissionScore) {


    SchoolAdmissionScore score = (SchoolAdmissionScore)schoolAdmissionScoreMapper.verifyScore(schoolAdmissionScore);

    return score;
  }

  public boolean insertSchoolAdmissionScore(SchoolAdmissionScore schoolAdmissionScore) {

    int res = schoolAdmissionScoreMapper.insertSchoolAdmissionScore(schoolAdmissionScore);

    return res > 0;

  }
}
