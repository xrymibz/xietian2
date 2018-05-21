package me.gacl.service.impl;

import me.gacl.dao.SchoolAdmissionScoreMapper;
import me.gacl.dao.SchoolCodeMapper;
import me.gacl.domain.SchoolAdmissionScore;
import me.gacl.domain.SchoolCode;
import me.gacl.service.SchoolCodeMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 14:17
 */
@Service("schoolCodeMappingService")
public class SchoolCodeMappingServiceImpl implements SchoolCodeMappingService {

  @Autowired
  SchoolCodeMapper schoolCodeMapper;

  public SchoolCode verifySchoolCode(SchoolCode schoolCode) {
    SchoolCode code = schoolCodeMapper.verifySchoolCode(schoolCode);

   return code;
  }

  public boolean insertSchoolCode(SchoolCode schoolCode) {

    int res = schoolCodeMapper.insertSchoolCode(schoolCode);

    return res > 0;
  }
}
