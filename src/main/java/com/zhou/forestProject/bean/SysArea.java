package com.zhou.forestProject.bean;


public class SysArea {
  /**区域id*/
  private long areaId;
  /**区域名称*/
  private String areaName;
  /**区域林种*/
  private String areaTreeType;
  /**区域优势树种*/
  private String areaGoodTree;
  /**区域地类*/
  private SysType sysType;



  public long getAreaId() {
    return areaId;
  }

  public void setAreaId(long areaId) {
    this.areaId = areaId;
  }


  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }


  public String getAreaTreeType() {
    return areaTreeType;
  }

  public void setAreaTreeType(String areaTreeType) {
    this.areaTreeType = areaTreeType;
  }


  public String getAreaGoodTree() {
    return areaGoodTree;
  }

  public void setAreaGoodTree(String areaGoodTree) {
    this.areaGoodTree = areaGoodTree;
  }


  public SysType getSysType() {
    return sysType;
  }

  public void setSysType(SysType sysType) {
    this.sysType = sysType;
  }
}
