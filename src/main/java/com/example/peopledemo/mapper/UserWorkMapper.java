package com.example.peopledemo.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.peopledemo.entiy.UserWorkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.peopledemo.entiy.dto.LeaveInfoDto;
import org.apache.ibatis.annotations.Select;

/**
* @author dell
* @description 针对表【user_work】的数据库操作Mapper
* @createDate 2024-06-07 09:41:12
* @Entity generator.domain.UserWork
*/
public interface UserWorkMapper extends BaseMapper<UserWorkEntity> {

    /**
     * 根据状态查询用户工作信息
     *
     * @param status 状态
     * @return 用户工作信息列表
     */
    @Select("SELECT uw.userId, uw.roleId, uw.departmentId, uw.postId, uw.`status`, u.`name`, u.phone\n" +
            "FROM user_work uw left join `user` u on uw.userId = u.id\n" +
            "where uw.`status` = #{status}")
    Page<LeaveInfoDto> getUserWorkByStatus(Page<LeaveInfoDto> page, String status);

}




