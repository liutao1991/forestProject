package com.zhou.forestProject.dao;


import com.zhou.forestProject.bean.SysClass;

/**
 * 小班持久层接口
 */
public interface IClassDao {
    /**
     * 添加小班
     * @param sysClass 小班对象
     * @return 受影响的行数
     */
    public int addClass(SysClass sysClass);

}
