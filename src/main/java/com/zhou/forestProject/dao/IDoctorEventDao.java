package com.zhou.forestProject.dao;

/**
 * 专家事件持久层接口
 */
public interface IDoctorEventDao {
    /**
     * 添加专家事件
     * @param eventId 事件id
     * @return 受影响的行数
     */
    public int addDoctorEvent(long eventId);
}
