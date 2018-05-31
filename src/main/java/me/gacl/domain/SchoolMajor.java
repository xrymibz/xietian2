package me.gacl.domain;

/**
 * 各学校各专业分数信息
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-31
 * Time: 10:18
 */
public class SchoolMajor {

  /** 主键id */
  private int id;
  /** 学校名称 */
  private String schoolName;
  /** 省份 */
  private String province;
  /** 专业 */
  private String major;
  /** 文理科 */
  private String category;
  /** 批次 */
  private String batch;
  /** 最高分 */
  private int maxValue;
  /** 平均分 */
  private int averageValue;
  /** 最低分 */
  private  int minValue;
  /** 年份 */
  private String year;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getBatch() {
    return batch;
  }

  public void setBatch(String batch) {
    this.batch = batch;
  }

  public int getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(int maxValue) {
    this.maxValue = maxValue;
  }

  public int getAverageValue() {
    return averageValue;
  }

  public void setAverageValue(int averageValue) {
    this.averageValue = averageValue;
  }

  public int getMinValue() {
    return minValue;
  }

  public void setMinValue(int minValue) {
    this.minValue = minValue;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
