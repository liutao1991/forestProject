package com.zhou.forestProject.dao;

import com.zhou.forestProject.bean.SysEvent;

public interface IEventDao {
    /**
     * 添加事件
     * @param sysEvent 事件对象
     * @return 受影响的行数
     */
    public int addEvent(SysEvent sysEvent);
}
