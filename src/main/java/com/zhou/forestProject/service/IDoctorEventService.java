package com.zhou.forestProject.service;

/**
 * 专家事件业务层接口
 */
public interface IDoctorEventService {
    /**
     * 添加专家事件
     * @param eventId 事件id
     * @return 受影响的行数
     */
    public boolean addDoctorEvent(long eventId);
}
