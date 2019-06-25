package com.zhou.forestProject.dao;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.dto.AreaDto;

import java.util.List;
import java.util.Map;

/**
 * 区域持久层接口
 */
public interface IAreaDao {
    /**
     * 添加区域
     * @param sysArea 区域对象
     * @return 返回受影响的行数
     */
    public int addArea(SysArea sysArea);

    /**
     * 根据条件查找区域
     * @param map
     * @return
     */
    public List<AreaDto> findAreaBySome(Map<String,Object> map);
}
