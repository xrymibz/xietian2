package me.gacl.domain;

import java.util.Date;

/**
 *  学校代码
 *
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 13:58
 */
public class SchoolCode {

  /** 学校代码 */
  private String SchoolCode;
  /** 学校名称 */
  private String SchoolName;
  /** 创建时间 */
  private Date gmtCreated;
  /** 修改时间 */
  private Date gmtModified;

  public String getSchoolCode() {
    return SchoolCode;
  }

  public void setSchoolCode(String schoolCode) {
    SchoolCode = schoolCode;
  }

  public String getSchoolName() {
    return SchoolName;
  }

  public void setSchoolName(String schoolName) {
    SchoolName = schoolName;
  }

  public Date getGmtCreated() {
    return gmtCreated;
  }

  public void setGmtCreated(Date gmtCreated) {
    this.gmtCreated = gmtCreated;
  }

  public Date getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }
}
