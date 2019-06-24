package com.zhou.forestProject.bean;


public class SysClass {
  /**小班编号*/
  private long classId;
  /**区域对象*/
  private SysArea area;
  /**小班名称*/
  private String className;
  /**小班负责人*/
  private String classLeader;
  /**小班负责人电话*/
  private String classLeaderTel;
  /**小班人数*/
  private long classNum;
  /**小班创建时间*/
  private String classStartDate;


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }


  public SysArea getArea() {
    return area;
  }

  public void setArea(SysArea area) {
    this.area = area;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public String getClassLeader() {
    return classLeader;
  }

  public void setClassLeader(String classLeader) {
    this.classLeader = classLeader;
  }


  public String getClassLeaderTel() {
    return classLeaderTel;
  }

  public void setClassLeaderTel(String classLeaderTel) {
    this.classLeaderTel = classLeaderTel;
  }


  public long getClassNum() {
    return classNum;
  }

  public void setClassNum(long classNum) {
    this.classNum = classNum;
  }


  public String getClassStartDate() {
    return classStartDate;
  }

  public void setClassStartDate(String classStartDate) {
    this.classStartDate = classStartDate;
  }

}
