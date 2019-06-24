package com.zhou.forestProject.bean;


public class SysPower {

  private long powerId;
  private long roleId;
  private String powerName;
  private String powerSource;
  private String powerTag;


  public long getPowerId() {
    return powerId;
  }

  public void setPowerId(long powerId) {
    this.powerId = powerId;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }


  public String getPowerSource() {
    return powerSource;
  }

  public void setPowerSource(String powerSource) {
    this.powerSource = powerSource;
  }


  public String getPowerTag() {
    return powerTag;
  }

  public void setPowerTag(String powerTag) {
    this.powerTag = powerTag;
  }

}
