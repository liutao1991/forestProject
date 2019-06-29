package com.zhou.forestProject.dto;

import com.zhou.forestProject.bean.SysDoctor;

import java.util.List;

/**
 * 专家会商结果dto
 */
public class DoctorResultDto {
    private long resultId; //结果id
    private long doctorEventId; //专家事件id
    private long eventId; //事件id
    private String doctorEventDate; //专家会审日期
    private String doctorEventResult;//专家会商结果
    private List<InfoDoctorDto> infoDoctorDtoList;//会商专家集合

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public long getDoctorEventId() {
        return doctorEventId;
    }

    public void setDoctorEventId(long doctorEventId) {
        this.doctorEventId = doctorEventId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getDoctorEventDate() {
        return doctorEventDate;
    }

    public void setDoctorEventDate(String doctorEventDate) {
        this.doctorEventDate = doctorEventDate;
    }

    public String getDoctorEventResult() {
        return doctorEventResult;
    }

    public void setDoctorEventResult(String doctorEventResult) {
        this.doctorEventResult = doctorEventResult;
    }

    public List<InfoDoctorDto> getInfoDoctorDtoList() {
        return infoDoctorDtoList;
    }

    public void setInfoDoctorDtoList(List<InfoDoctorDto> infoDoctorDtoList) {
        this.infoDoctorDtoList = infoDoctorDtoList;
    }
}
