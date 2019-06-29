package com.zhou.forestProject.dao;

import com.zhou.forestProject.dto.InfoDoctorDto;

import java.util.List;

/**
 * 会商专家持久层接口
 */
public interface IInfoDoctorDao {
    /**
     * 根据会商结果id 查找会商专家集合
     * @param resultId 会商结果id
     * @return 会商专家集合
     */
    public List<InfoDoctorDto> findByResultId(long resultId);
}
