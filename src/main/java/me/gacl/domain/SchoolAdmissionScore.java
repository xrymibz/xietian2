package me.gacl.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-16
 * Time: 7:28
 */
public class SchoolAdmissionScore {
  /** 学校名称 */
  private String schoolName;
  /** 学校代码 */
  private String schoolCode;
  /** 年份 */
  private String year;
  /** 省份 */
  private String province;
  /** 最高录取分数 */
  private String maxScore;
  /** 平均录取分数 */
  private String averageScore;
  /** 最低录取分数 */
  private String minScore;
  /** 创建时间 */
  private Date gmtCreated;
  /** 修改时间 */
  private Date gmtModified;

  public SchoolAdmissionScore() {
  }

  public SchoolAdmissionScore(String schoolName, String schoolCode, String year,
      String province, String maxScore, String averageScore, String minScore) {
    this.schoolName = schoolName;
    this.schoolCode = schoolCode;
    this.year = year;
    this.province = province;
    this.maxScore = maxScore;
    this.averageScore = averageScore;
    this.minScore = minScore;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public String getSchoolCode() {
    return schoolCode;
  }

  public void setSchoolCode(String schoolCode) {
    this.schoolCode = schoolCode;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getMaxScore() {
    return maxScore;
  }

  public void setMaxScore(String maxScore) {
    this.maxScore = maxScore;
  }

  public String getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(String averageScore) {
    this.averageScore = averageScore;
  }

  public String getMinScore() {
    return minScore;
  }

  public void setMinScore(String minScore) {
    this.minScore = minScore;
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
