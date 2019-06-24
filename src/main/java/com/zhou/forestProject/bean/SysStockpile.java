package com.zhou.forestProject.bean;


public class SysStockpile {

  private long stockpileId;
  private long stockpileClass;
  private long stockpileMan;
  private String stockpileDate;
  private long stockpileNum;


  public long getStockpileId() {
    return stockpileId;
  }

  public void setStockpileId(long stockpileId) {
    this.stockpileId = stockpileId;
  }


  public long getStockpileClass() {
    return stockpileClass;
  }

  public void setStockpileClass(long stockpileClass) {
    this.stockpileClass = stockpileClass;
  }


  public long getStockpileMan() {
    return stockpileMan;
  }

  public void setStockpileMan(long stockpileMan) {
    this.stockpileMan = stockpileMan;
  }


  public String getStockpileDate() {
    return stockpileDate;
  }

  public void setStockpileDate(String stockpileDate) {
    this.stockpileDate = stockpileDate;
  }


  public long getStockpileNum() {
    return stockpileNum;
  }

  public void setStockpileNum(long stockpileNum) {
    this.stockpileNum = stockpileNum;
  }

}
