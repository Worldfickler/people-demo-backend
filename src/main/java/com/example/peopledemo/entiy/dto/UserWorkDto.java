package com.example.peopledemo.entiy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户工作信息请求
 *
 * @author Fickler
 * @date 2024/5/20 10:07
 */
@Data
public class UserWorkDto implements Serializable {
    private static final long serialVersionUID = -7346053466335641205L;

    /**
     * id
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 所在部门id/工作位置id
     */
    private String departmentId;

    /**
     * 职位id/岗位id/工种id
     */
    private String postId;

    /**
     * 请假状态（0-未请假，1-待审批，2-请假中）
     */
    private Integer status;

}