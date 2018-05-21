package me.gacl.service;

import java.util.List;
import me.gacl.domain.ProvinceCode;
import me.gacl.domain.SchoolCode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 15:46
 */
public interface ProvinceCodeMappingService {

  /**
   *
   * 查询省份映射
   * @param provinceCode
   * @return
   */
  ProvinceCode verifyProvinceCode(ProvinceCode provinceCode);

  /**
   * 查询全部映射省份映射
   * @return
   */
  List<ProvinceCode> verifyAllProvinceCodes();
} 
