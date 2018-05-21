package me.gacl.service.impl;

import java.util.List;
import me.gacl.dao.ProvinceCodeMapper;
import me.gacl.domain.ProvinceCode;
import me.gacl.service.ProvinceCodeMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 15:48
 */
@Service("provinceCodeMappingService")
public class ProvinceCodeMappingServiceImpl implements ProvinceCodeMappingService {

  @Autowired
  ProvinceCodeMapper provinceCodeMapper;

  public ProvinceCode verifyProvinceCode(ProvinceCode provinceCode) {
      return provinceCodeMapper.verifyProvince(provinceCode);
  }

  public List<ProvinceCode> verifyAllProvinceCodes() {
    return provinceCodeMapper.verifyAllProvinces();
  }
}
