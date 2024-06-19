package com.example.peopledemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.peopledemo.entiy.UserWorkEntity;
import com.example.peopledemo.entiy.dto.LeaveInfoDto;
import com.example.peopledemo.entiy.dto.UserWorkDto;
import com.example.peopledemo.service.UserWorkService;
import com.example.peopledemo.mapper.UserWorkMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户工作服务实现
 *
 * @author dell
 * @description 针对表【user_work】的数据库操作Service实现
 * @createDate 2024-05-13 11:42:14
 */
@Service
public class UserWorkServiceImpl extends ServiceImpl<UserWorkMapper, UserWorkEntity>
        implements UserWorkService {

    @Resource
    private UserWorkMapper userWorkMapper;

    /**
     * 新增用户工作信息接口实现
     *
     * @param userId          用户id
     * @param userWorkDtoList 用户工作dto列表
     * @return 成功-true 失败-false
     */
    @Override
    public boolean insertUserWork(String userId, List<UserWorkDto> userWorkDtoList) {
        ArrayList<UserWorkEntity> userWorkEntities = new ArrayList<>();
        for (UserWorkDto userWorkDto : userWorkDtoList) {
            UserWorkEntity userWorkEntity = new UserWorkEntity();
            userWorkEntity.setUserId(userId);
            userWorkEntity.setRoleId(userWorkDto.getRoleId());
            userWorkEntity.setDepartmentId(userWorkDto.getDepartmentId());
            userWorkEntity.setPostId(userWorkDto.getPostId());
            userWorkEntities.add(userWorkEntity);
        }
        return this.saveBatch(userWorkEntities);
    }

    /**
     * 查询全部用户-工作接口实现
     *
     * @return 用户-工作列表
     */
    @Override
    public List<UserWorkEntity> selectAllUserWork() {
        return this.list();
    }

    /**
     * 根据用户id查询用户工作信息
     *
     * @param userId 用户id
     * @return 用户工作信息列表
     */
    @Override
    public List<UserWorkEntity> selectUserWorkByUserId(String userId) {
        QueryWrapper<UserWorkEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        List<UserWorkEntity> list = this.list(queryWrapper);
        return list;
    }

    /**
     * 更新用户工作信息接口实现
     *
     * @param userWorkDto 用户工作dto
     * @return 成功-true 失败-false
     */
    @Override
    public boolean updateUserWork(UserWorkDto userWorkDto) {
        UserWorkEntity userWorkEntity = new UserWorkEntity();
        userWorkEntity.setId(userWorkDto.getId());
        userWorkEntity.setRoleId(userWorkDto.getRoleId());
        userWorkEntity.setDepartmentId(userWorkDto.getDepartmentId());
        userWorkEntity.setPostId(userWorkDto.getPostId());
        userWorkEntity.setStatus(userWorkDto.getStatus());
        return this.updateById(userWorkEntity);
    }

    /**
     * 删除用户工作信息接口实现
     *
     * @param userWorkId 用户工作id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean deleteUserWork(String userWorkId) {
        return this.removeById(userWorkId);
    }

    /**
     * 根据状态查询用户工作信息接口实现
     *
     * @param pageSize    每页大小
     * @param currentPage 当前页
     * @param status      状态
     * @return 用户工作信息列表
     */
    @Override
    public Page<LeaveInfoDto> selectUserWorkByStatus(long pageSize, long currentPage, String status) {
//        QueryWrapper<UserWorkEntity> userWorkEntityQueryWrapper = new QueryWrapper<>();
//        if (status == null) {
//            userWorkEntityQueryWrapper.ne("status", 0);
//        } else {
//            userWorkEntityQueryWrapper.eq("status", status);
//        }
//        return this.page(new Page<>(currentPage, pageSize), userWorkEntityQueryWrapper);
        return userWorkMapper.getUserWorkByStatus(new Page<>(currentPage, pageSize), status);
    }

}




