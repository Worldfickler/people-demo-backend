package com.example.peopledemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.peopledemo.entiy.LeaveInfoEntity;
import com.example.peopledemo.entiy.UserWorkEntity;
import com.example.peopledemo.mapper.LeaveInfoMapper;
import com.example.peopledemo.service.LeaveInfoService;
import com.example.peopledemo.service.UserWorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 请假服务实现
* @author dell
* @description 针对表【leave】的数据库操作Service实现
* @createDate 2024-05-11 16:47:31
*/
@Slf4j
@Service
public class LeaveInfoServiceImpl extends ServiceImpl<LeaveInfoMapper, LeaveInfoEntity>
    implements LeaveInfoService {

    @Resource
    private UserWorkService userWorkService;

    /**
     * 请假接口实现
     * @param userId 用户id
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean askForLeave(String userId, String roleId) {
        // 1. 建设单位人员请假，不需要申请，不会生成请假记录。
        if ("1".equals(roleId)) {
            log.info("建设单位人员请假，不需要申请，不会生成请假记录");
            UpdateWrapper<UserWorkEntity> userWorkEntityUpdateWrapper = new UpdateWrapper<>();
            userWorkEntityUpdateWrapper.eq("userId", userId).eq("roleId", roleId).set("status", 2);
            return userWorkService.update(userWorkEntityUpdateWrapper);
        }
        // 2. 管理人员请假，需要有申请，申请通过后，才变更为请假状态，同时生成请假销假记录。
        if ("2".equals(roleId)) {
            log.info("管理人员请假，需要有申请，申请通过后，才变更为请假状态，同时生成请假销假记录");
            UpdateWrapper<UserWorkEntity> userWorkEntityUpdateWrapper = new UpdateWrapper<>();
            userWorkEntityUpdateWrapper.eq("userId", userId).eq("roleId", roleId).set("status", 1);
            return userWorkService.update(userWorkEntityUpdateWrapper);
        }
        // 3. 作业人员请假，不需要有申请，直接变为请假状态，生成请假记录。当主动销假后生成销假记录。
        if ("3".equals(roleId)) {
            log.info("作业人员请假，不需要有申请，直接变为请假状态，生成请假记录。当主动销假后生成销假记录");
            UpdateWrapper<UserWorkEntity> userWorkEntityUpdateWrapper = new UpdateWrapper<>();
            userWorkEntityUpdateWrapper.eq("userId", userId).eq("roleId", roleId).set("status", 2);
            boolean update = userWorkService.update(userWorkEntityUpdateWrapper);
            if (update) {
                return this.insertLeave(userId, roleId, 0);
            }
        }
        return false;
    }

    /**
     * 审批请假接口实现
     * @param userId 用户id
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean dealLeave(String userId, String roleId, String status) {
        if ("2".equals(roleId)) {
            log.info("管理人员审批请假");
            UpdateWrapper<UserWorkEntity> userWorkEntityUpdateWrapper = new UpdateWrapper<>();
            userWorkEntityUpdateWrapper.eq("userId", userId).eq("roleId", roleId).set("status", status);
            boolean update = userWorkService.update(userWorkEntityUpdateWrapper);
            if (update) {
                if ("2".equals(status)) {
                    return this.insertLeave(userId, roleId, 0);
                } else {
                    return true;
                }
            }
        } else {
            log.info("其他人员审批请假");
            return false;
        }
        log.info("管理人员审批请假失败");
        return false;
    }

    /**
     * 取消请假接口实现
     * @param userId 用户id
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean cancelLeave(String userId, String roleId, String status) {
        UpdateWrapper<UserWorkEntity> userWorkEntityUpdateWrapper = new UpdateWrapper<>();
        userWorkEntityUpdateWrapper.eq("userId", userId).eq("roleId", roleId).set("status", 0);
        boolean update = userWorkService.update(userWorkEntityUpdateWrapper);
        if ("2".equals(status)) {
            return update && this.insertLeave(userId, roleId, Integer.valueOf(status));
        }
        return update;
    }

    /**
     * 生成请假销假记录接口实现
     * @param userId 用户id
     * @param status 状态：0-请假 1-销假
     * @return 成功-true 失败-false
     */
    @Override
    public boolean insertLeave(String userId, String roleId, Integer status) {
        LeaveInfoEntity leaveEntity = new LeaveInfoEntity();
        leaveEntity.setPeopleId(userId);
        leaveEntity.setRoleId(roleId);
        leaveEntity.setLeaveStatus(status);
        leaveEntity.setTime(new Date());
        return this.save(leaveEntity);
    }
}