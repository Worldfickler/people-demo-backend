package com.example.peopledemo.service;

import com.example.peopledemo.entiy.LeaveInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 请假服务
 * @author dell
 * @description 针对表【leave】的数据库操作Service
 * @createDate 2024-05-11 16:47:31
 */
public interface LeaveInfoService extends IService<LeaveInfoEntity> {

    /**
     * 请假接口
     * @param userId 用户id
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    boolean askForLeave(String userId, String roleId);

    /**
     * 审批请假接口
     * @param userId 用户id
     * @param roleId 角色id
     * @param status 状态
     * @return 成功-true 失败-false
     */
    boolean dealLeave(String userId, String roleId, String status);

    /**
     * 取消请假接口
     * @param userId 用户id
     * @param roleId 角色id
     * @param status 状态
     * @return 成功-true 失败-false
     */
    boolean cancelLeave(String userId, String roleId, String status);

    /**
     * 生成请假销假记录接口
     * @param userId 用户id
     * @param status 状态：0-请假 1-销假
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    boolean insertLeave(String userId, String roleId, Integer status);

}
