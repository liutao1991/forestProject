package com.zhou.forestProject.service;

import com.zhou.forestProject.dto.InfoDoctorDto;

import java.util.List;

/**
 * 专家会商
 */
public interface IInfoDoctorService {
    /**
     * 根据会商结果id 查找会商专家集合
     * @param resultId 会商结果id
     * @return 会商专家集合
     */
    public List<InfoDoctorDto> findByResultId(long resultId);
}
