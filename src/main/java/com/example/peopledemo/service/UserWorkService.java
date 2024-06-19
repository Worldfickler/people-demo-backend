package com.example.peopledemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.peopledemo.entiy.UserWorkEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.peopledemo.entiy.dto.LeaveInfoDto;
import com.example.peopledemo.entiy.dto.UserWorkDto;

import java.util.List;

/**
 * 用户工作服务
 *
 * @author dell
 * @description 针对表【user_work】的数据库操作Service
 * @createDate 2024-05-13 11:42:14
 */
public interface UserWorkService extends IService<UserWorkEntity> {

    /**
     * 新增用户工作信息接口
     *
     * @param userId          用户id
     * @param userWorkDtoList 用户工作dto列表
     * @return 成功-true 失败-false
     */
    boolean insertUserWork(String userId, List<UserWorkDto> userWorkDtoList);

    /**
     * 查询全部用户工作接口
     *
     * @return 用户-工作列表
     */
    List<UserWorkEntity> selectAllUserWork();

    /**
     * 根据用户id查询用户工作信息
     *
     * @param userId 用户id
     * @return 用户工作信息列表
     */
    List<UserWorkEntity> selectUserWorkByUserId(String userId);

    /**
     * 更新用户工作信息接口
     *
     * @param userWorkDto 用户工作dto
     * @return 成功-true 失败-false
     */
    boolean updateUserWork(UserWorkDto userWorkDto);

    /**
     * 删除用户工作信息接口
     *
     * @param userWorkId 用户工作id
     * @return 成功-true 失败-false
     */
    boolean deleteUserWork(String userWorkId);

    /**
     * 根据状态查询用户工作信息接口
     *
     * @param pageSize 每页大小
     * @param currentPage 当前页
     * @param status 状态
     * @return 用户工作信息列表
     */
    Page<LeaveInfoDto> selectUserWorkByStatus(long pageSize, long currentPage, String status);
}
