package com.example.peopledemo.controller;

import com.example.peopledemo.entiy.UserEntity;
import com.example.peopledemo.service.LeaveInfoService;
import com.example.peopledemo.service.UserService;
import com.example.peopledemo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 请假接口
 *
 * @author Fickler
 * @date 2024/5/20 10:44
 */

@Slf4j
@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Resource
    private LeaveInfoService leaveService;

    @Resource
    private UserService userService;

    /**
     * 用户请假
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    @PostMapping("/askforleave")
    public Result<Boolean> askForLeave(@RequestParam String userId, @RequestParam String roleId) {
        boolean result = leaveService.askForLeave(userId, roleId);
        return Result.success(result);
    }

    /**
     * 处理请假请求
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    @PostMapping("/dealleave")
    public Result<Boolean> dealLeave(@RequestParam String userId, @RequestParam String roleId, @RequestParam String status) {
        boolean result = leaveService.dealLeave(userId, roleId, status);
        return Result.success(result);
    }

    /**
     * 用户取消请假
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @param status 状态
     * @return 成功-true 失败-false
     */
    @PostMapping("/cancelleave")
    public Result<Boolean> cancelLeave(@RequestParam String userId, @RequestParam String roleId, @RequestParam String status) {
        boolean result = leaveService.cancelLeave(userId, roleId, status);
        return Result.success(result);
    }

    /**
     * 查询不同请求状态的用户
     *
     * @return 用户列表
     */
    @GetMapping("/leaveusers")
    public List<UserEntity> listLeaveUsers(Integer status) {
        List<UserEntity> userList = new ArrayList<>();
        if (status == null) {
//            userList = userService.selectAllUser();
        } else {
            userList = userService.selectUsersByStatus(status);
        }
        return userList;
    }
}
