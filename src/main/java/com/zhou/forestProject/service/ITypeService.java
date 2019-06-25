package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysType;

import java.util.List;

/**
 * 类型业务层借口
 */
public interface ITypeService {
    /**
     * 根据类型名字找类型集合
     * @param typeName 类型名字
     * @return 类型集合
     */
    public List<SysType> findListTypeByTypeName(String typeName);
    /**
     * 根據名字找id
     * @param typeVal 类型值
     * @return id
     */
    public long findIdByVal(String typeVal);

}
