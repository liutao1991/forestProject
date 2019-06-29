package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.dto.ClassDto;

import java.util.List;
import java.util.Map;

public interface IClassService {
    /**
     * 添加小班
     * @param sysClass 小班对象
     * @return 添加成功返回true;否则返回false
     */
    public boolean addClass(SysClass sysClass);
    /**
     * 根据条件查询小班集合
     * @param map 条件集合
     * @return 小班集合
     */
    public List<ClassDto> findClassBySome(Map map);
    /**
     * 根据条件查询结果的行数
     * @param map 查询条件
     * @return
     */
    public int countRow(Map map);
    /**
     * 根据id查找小班信息
     * @param classId 小班id
     * @return 小班对象
     */
    public ClassDto findClassById(int classId);
    /**
     * 根据id修改小班信息
     * @param classLeader 小班负责人
     * @param classLeaderTel 负责人电话
     * @param classId 小班id
     * @return 修改成功返回true，不成功返回false
     */
    public boolean updateClass(String classLeader,String classLeaderTel,int classId);
    /**
     * 根据区域id查找小班信息
     * @param areaId 小班id
     * @return 小班对象
     */
    public SysClass  findClassByAreaId(int areaId);
}
