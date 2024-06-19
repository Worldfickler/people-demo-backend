package com.example.peopledemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.peopledemo.entiy.UserEntity;
import com.example.peopledemo.entiy.dto.UserDto;
import com.example.peopledemo.mapper.UserMapper;
import com.example.peopledemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author dell
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-05-11 16:47:31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity>
        implements UserService {

    /**
     * 插入用户接口实现
     *
     * @param userDto 用户dto
     * @return 成功-true 失败-false
     */
    @Override
    public boolean insertUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setIdCard(userDto.getIdCard());
        userEntity.setPhone(userDto.getPhone());
        boolean save = this.save(userEntity);
        userDto.setUserId(userEntity.getId());
        return save;
    }

    /**
     * 删除用户接口实现
     *
     * @param userId 用户id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean deleteUser(String userId) {
        return this.removeById(userId);
    }

    /**
     * 根据用户id查询用户接口实现
     *
     * @param userId 用户id
     * @return 用户entity
     */
    @Override
    public UserEntity selectUser(String userId) {
        return this.getById(userId);
    }

    /**
     * 查询全部用户接口实现
     *
     * @return 用户列表
     */
    @Override
    public Page<UserEntity> selectAllUser(long pageSize, long currentPage) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        return this.page(new Page<>(currentPage, pageSize), userEntityQueryWrapper);
    }

    /**
     * 更新用户信息接口实现
     *
     * @param userDto 用户dto
     * @return 成功-true 失败-false
     */
    @Override
    public boolean updateUser(UserDto userDto) {
        UserEntity updateUserEntity = new UserEntity();
        updateUserEntity.setId(userDto.getUserId());
        updateUserEntity.setName(userDto.getName());
        updateUserEntity.setPhone(userDto.getPhone());
        updateUserEntity.setIdCard(userDto.getIdCard());
        return this.updateById(updateUserEntity);
    }

    /**
     * 更新用户请假状态接口实现
     *
     * @param userId 用户id
     * @param status 请假状态
     * @return 成功-true 失败-false
     */
    @Override
    public boolean updateUserLeaveStatus(String userId, Integer status) {
        UpdateWrapper<UserEntity> userEntityUpdateWrapper = new UpdateWrapper<>();
        userEntityUpdateWrapper.set("status", status).eq("userId", userId);
        return this.update(userEntityUpdateWrapper);
    }

    /**
     * 根据用户请求状态查询用户
     *
     * @param status 用户请假状态
     * @return 用户列表
     */
    @Override
    public List<UserEntity> selectUsersByStatus(Integer status) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("status", status);
        return this.list(userEntityQueryWrapper);
    }

    /**
     * 根据关键字搜索用户
     *
     * @param keyword     关键字
     * @param pageSize    每页大小
     * @param currentPage 当前页
     * @return 用户列表
     */
    @Override
    public Page<UserEntity> searchUser(String keyword, int pageSize, int currentPage) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.like("id", keyword)
                .or().like("name", keyword)
                .or().like("phone", keyword)
                .or().like("idCard", keyword);
        Page<UserEntity> page = this.page(new Page<>(currentPage, pageSize), userEntityQueryWrapper);
        return page;
    }
}




