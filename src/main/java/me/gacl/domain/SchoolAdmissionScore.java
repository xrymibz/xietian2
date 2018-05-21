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

  private String id;
  /** 学校名称 */
  private String schoolName;
  /** 学校代码 */
  private String schoolCode;
  /** 年份 */
  private String year;
  /** 省份 */
  private String province;
  /** 最高录取分数 */
  private int maxScore;
  /** 平均录取分数 */
  private int averageScore;
  /** 最低录取分数 */
  private int minScore;
  /** 创建时间 */
  private Date gmtCreated;
  /** 修改时间 */
  private Date gmtModified;
  /** 批次 */
  private String batch;

  public SchoolAdmissionScore() {
  }

  public SchoolAdmissionScore(String schoolName, String schoolCode, String year,
      String province, int maxScore, int averageScore, int minScore) {
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

  public int getMaxScore() {
    return maxScore;
  }

  public void setMaxScore(int maxScore) {
    this.maxScore = maxScore;
  }

  public int getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(int averageScore) {
    this.averageScore = averageScore;
  }

  public int getMinScore() {
    return minScore;
  }

  public void setMinScore(int minScore) {
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBatch() {
    return batch;
  }

  public void setBatch(String batch) {
    this.batch = batch;
  }
}
