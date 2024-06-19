package com.example.peopledemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.peopledemo.entiy.UserEntity;
import com.example.peopledemo.entiy.UserWorkEntity;
import com.example.peopledemo.entiy.dto.LeaveInfoDto;
import com.example.peopledemo.entiy.dto.UserWorkDto;
import com.example.peopledemo.service.UserService;
import com.example.peopledemo.service.UserWorkService;
import com.example.peopledemo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户工作接口
 *
 * @author Fickler
 * @date 2024/5/20 10:31
 */

@RestController
@RequestMapping("/user_work")
public class UserWorkController {

    @Resource
    private UserWorkService userWorkService;

    @Resource
    private UserService userService;

    /**
     * 新增用户-工作
     *
     * @param userId          用户id
     * @param userWorkDtoList 用户工作dto列表
     * @return 成功-true 失败-false
     */
    @PostMapping("/insert")
    public boolean insertUserWork(String userId, @RequestBody List<UserWorkDto> userWorkDtoList) {
        return userWorkService.insertUserWork(userId, userWorkDtoList);
    }

    /**
     * 查询全部用户-工作
     *
     * @return 用户-工作列表
     */
    @GetMapping("/selectAll")
    public List<UserWorkEntity> selectAllUserWork() {
        return userWorkService.selectAllUserWork();
    }

    /**
     * 查询用户工作信息
     *
     * @param userId 用户id
     * @return 用户工作信息
     */
    @GetMapping("/select_works")
    public List<UserWorkEntity> selectAllUserWork(String userId) {
        return userWorkService.selectUserWorkByUserId(userId);
    }

    /**
     * 删除用户工作信息
     *
     * @param userWorkId
     * @return 成功-true 失败-false
     */
    @PostMapping("/delete_works")
    public Result<Boolean> deleteUserWork(@RequestParam String userWorkId) {
        boolean result = userWorkService.deleteUserWork(userWorkId);
        return Result.success(result);
    }

    /**
     * 根据状态查询用户工作信息
     *
     * @param status 状态
     * @return 用户工作信息列表
     */
    @GetMapping("/selectbystatus")
    public Result<Page<LeaveInfoDto>> selectUserWorkByStatus(@RequestParam long pageSize, @RequestParam long currentPage, @RequestParam String status) {
        Page<LeaveInfoDto> leaveInfoDtoPage = userWorkService.selectUserWorkByStatus(pageSize, currentPage, status);
        return Result.success(leaveInfoDtoPage);
    }

}
