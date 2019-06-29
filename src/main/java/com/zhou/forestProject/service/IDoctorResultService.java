package com.zhou.forestProject.service;

import com.zhou.forestProject.dto.DoctorResultDto;

import java.util.List;

/**
 * 专家会商结果
 */
public interface IDoctorResultService {
    /**
     * 根据会商结果id查找会商结果dto
     * @param resultId 会商结果id
     * @return 会商结果dto
     */
    public DoctorResultDto findByResultId(long resultId);
    /**
     * 根据事件id查找会商结果dto集合
     * @param eventId 事件id
     * @return 会商结果dto集合
     */
    public List<DoctorResultDto> findByEventId(long eventId);
}
