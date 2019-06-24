package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysClass;

public interface IClassService {
    /**
     * 添加小班
     * @param sysClass 小班对象
     * @return 添加成功返回true;否则返回false
     */
    public boolean addClass(SysClass sysClass);
}
