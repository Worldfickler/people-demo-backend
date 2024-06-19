package com.example.peopledemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.peopledemo.entiy.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.peopledemo.entiy.dto.UserDto;

import java.util.List;

/**
 * 用户服务
 *
 * @author dell
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-05-11 16:47:31
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 添加用户接口
     *
     * @param userDto 用户dto
     * @return 成功-true 失败-false
     */
    boolean insertUser(UserDto userDto);

    /**
     * 删除用户接口
     *
     * @param userId 用户id
     * @return 成功-true 失败-false
     */
    boolean deleteUser(String userId);

    /**
     * 根据用户id查询用户接口
     *
     * @param userId 用户id
     * @return 成功-true 失败-false
     */
    UserEntity selectUser(String userId);

    /**
     * 查询全部用户接口
     *
     * @return 用户列表
     */
    Page<UserEntity> selectAllUser(long pageSize, long currentPage);

    /**
     * 更新用户信息接口
     *
     * @param userDto 用户dto
     * @return 成功-true 失败-false
     */
    boolean updateUser(UserDto userDto);

    /**
     * 更新用户请假状态接口
     *
     * @param userId 用户id
     * @param status 请假状态
     * @return 成功-true 失败-false
     */
    boolean updateUserLeaveStatus(String userId, Integer status);

    /**
     * 根据用户请求状态查询用户
     *
     * @param status 用户请假状态
     * @return 用户列表
     */
    List<UserEntity> selectUsersByStatus(Integer status);

    /**
     * 根据关键字搜索用户
     *
     * @param keyword   关键字
     * @param pageSize  每页数量
     * @param currentPage 当前页
     * @return 用户列表
     */
    Page<UserEntity> searchUser(String keyword, int pageSize, int currentPage);


}
