package com.zhou.forestProject.bean;

/**
 * 用户实体表
 */
public class SysUser {
  /**用户编号*/
  private long userId;
  /**角色编号*/
  private long roleId;
  /**用户名*/
  private String userName;
  /**用户密码*/
  private String userPwd;
  /**真实姓名*/
  private String userTrueName;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public String getUserTrueName() {
    return userTrueName;
  }

  public void setUserTrueName(String userTrueName) {
    this.userTrueName = userTrueName;
  }

}
