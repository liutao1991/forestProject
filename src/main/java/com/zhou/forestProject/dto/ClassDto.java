package com.zhou.forestProject.dto;

public class ClassDto {
    /**小班id*/
    private long classId;
    /**区域id*/
    private long areaId;
    /**小班名字*/
    private String className;
    /**小班负责人*/
    private String classLeader;
    /**负责人电话*/
    private String classLeaderTel;
    /**小班人员数量*/
    private long classNum;
    /**小班创建时间*/
    private String classStartDate;
    /**负责区域名称*/
    private String areaName;
    /**负责区域林种*/
    private String areaTreeType;
    /**负责区域优势树种*/
    private String areaGoodTree;
    /**负责区域地类*/
    private String  areaType;

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
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

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }
}
