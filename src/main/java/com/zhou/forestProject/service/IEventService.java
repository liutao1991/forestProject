package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysEvent;

/**
 * 事件业务层接口
 */
public interface IEventService {
    /**
     * 添加事件
     * @param sysEvent 事件对象
     * @return 添加成功返回true,不成功返回false
     */
    public boolean addEvent(SysEvent sysEvent);
}
