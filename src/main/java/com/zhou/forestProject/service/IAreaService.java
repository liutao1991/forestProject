package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysArea;

/**
 * 区域业务层接口
 */
public interface IAreaService {
    /**
     * 添加区域
     * @param sysArea 区域对象
     * @return 添加成功返回true,不成功返回false
     */
    public boolean addArea(SysArea sysArea);
}
