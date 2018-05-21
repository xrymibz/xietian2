package me.gacl.dao;

import java.util.List;
import me.gacl.domain.ProvinceCode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 15:41
 */
public interface ProvinceCodeMapper {

  /**
   * 省份代码查询
   * @param provinceCode
   * @return
   */
  ProvinceCode verifyProvince( ProvinceCode provinceCode);


  /**
   * 全部省份代码查询
   * @return
   */
  List<ProvinceCode> verifyAllProvinces();

}
