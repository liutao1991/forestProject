package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.dto.AreaDto;

import java.util.List;
import java.util.Map;

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
    /**
     * 根据条件查找区域
     * @param map
     * @return
     */
    public List<AreaDto> findAreaBySome(Map<String,Object> map);
    /**
     * 根据条件查询行数
     * @param map
     * @return
     */
    public int countRow(Map<String,Object> map);
    /**
     * 查找没有小班管理的区域
     * @return 区域集合
     */
    public List<SysArea> findWithoutClass();
}
