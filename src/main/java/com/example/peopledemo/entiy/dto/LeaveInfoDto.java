package com.example.peopledemo.entiy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假请求
 * @author Fickler
 * @date 2024/5/20 17:26
 */

@Data
public class LeaveInfoDto implements Serializable {
    private static final long serialVersionUID = 8844807783252871321L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户id
     */
    private String phone;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 部门id
     */
    private String departmentId;

    /**
     * 岗位id
     */
    private String postId;

    /**
     * 请假状态（0-请假、1-销假）
     */
    private Integer status;

//    /**
//     * 时间
//     */
//    private Date time;
}
