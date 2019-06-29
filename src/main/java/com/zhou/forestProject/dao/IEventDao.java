package com.zhou.forestProject.dao;

import com.zhou.forestProject.bean.SysEvent;
import com.zhou.forestProject.dto.EventDto;

import java.util.List;
import java.util.Map;

public interface IEventDao {
    /**
     * 添加事件
     * @param sysEvent 事件对象
     * @return 受影响的行数
     */
    public int addEvent(SysEvent sysEvent);

    /**
     * 根据条件查询事件集合
     * @param map 查询条件
     * @return 事件集合
     */
    public List<EventDto> findEventBySome(Map map);

    /**
     * 根据条件查询数据行数
     * @param map
     * @return 查询到的数据行数
     */
    public int countRow(Map map);

    /**
     * 根据事件id查找事件
     * @param eventId 事件id
     * @return 事件对象
     */
    public EventDto findById(int eventId);

    /**
     * 修改事件信息
     * @param eventStage 灾情阶段
     * @param eventMethod 防治方案
     * @param eventId 事件id
     * @return
     */
    public int updateEvent(long eventStage,String eventMethod,long eventId);
    /**
     * 修改事件信息
     * @param eventStage 灾情阶段
     * @param eventId 事件id
     * @return
     */
    public int updateEventStage(long eventStage,long eventId);

    /**
     * 根据事件id查看事件状态
     * @param eventId 事件id
     * @return 事件状态id
     */
    public long findEventStageByEventId(long eventId);
}
