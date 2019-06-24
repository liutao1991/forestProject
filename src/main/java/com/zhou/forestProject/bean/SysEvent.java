package com.zhou.forestProject.bean;


import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysType;

public class SysEvent {
  /**事件id*/
  private long eventId;
  /**区域对象*/
  private SysArea sysArea;
  /**事件名称*/
  private String eventName;
  /**灾区图片*/
  private String eventImgPath;
  /**事件发生时间*/
  private String eventDate;
  /**灾情阶段，类型对象*/
  private SysType sysTypeEnevtStage;
  /**灾害类型，类型对象*/
  private SysType sysTypeEventType;
  /**灾情描述*/
  private String eventInfo;
  /**发现途径，类型对象*/
  private SysType sysTypeEventFindWay;
  /**初步损失*/
  private String eventLoss;
  /**影响面积*/
  private String eventArea;
  /**防治方案*/
  private String eventMethod;


  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }


  public SysArea getSysArea() {
    return sysArea;
  }

  public void setSysArea(SysArea sysArea) {
    this.sysArea = sysArea;
  }

  public SysType getSysTypeEnevtStage() {
    return sysTypeEnevtStage;
  }

  public void setSysTypeEnevtStage(SysType sysTypeEnevtStage) {
    this.sysTypeEnevtStage = sysTypeEnevtStage;
  }

  public SysType getSysTypeEventType() {
    return sysTypeEventType;
  }

  public void setSysTypeEventType(SysType sysTypeEventType) {
    this.sysTypeEventType = sysTypeEventType;
  }

  public SysType getSysTypeEventFindWay() {
    return sysTypeEventFindWay;
  }

  public void setSysTypeEventFindWay(SysType sysTypeEventFindWay) {
    this.sysTypeEventFindWay = sysTypeEventFindWay;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }


  public String getEventImgPath() {
    return eventImgPath;
  }

  public void setEventImgPath(String eventImgPath) {
    this.eventImgPath = eventImgPath;
  }


  public String getEventDate() {
    return eventDate;
  }

  public void setEventDate(String eventDate) {
    this.eventDate = eventDate;
  }



  public String getEventInfo() {
    return eventInfo;
  }

  public void setEventInfo(String eventInfo) {
    this.eventInfo = eventInfo;
  }


  public String getEventLoss() {
    return eventLoss;
  }

  public void setEventLoss(String eventLoss) {
    this.eventLoss = eventLoss;
  }


  public String getEventArea() {
    return eventArea;
  }

  public void setEventArea(String eventArea) {
    this.eventArea = eventArea;
  }


  public String getEventMethod() {
    return eventMethod;
  }

  public void setEventMethod(String eventMethod) {
    this.eventMethod = eventMethod;
  }

}
