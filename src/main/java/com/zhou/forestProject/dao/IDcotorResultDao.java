package com.zhou.forestProject.dao;

import com.zhou.forestProject.dto.DoctorResultDto;

import java.util.List;

/**
 * 专家会商结果持久层接口
 */
public interface IDcotorResultDao {
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
