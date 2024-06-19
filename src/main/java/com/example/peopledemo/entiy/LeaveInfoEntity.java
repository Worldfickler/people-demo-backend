package com.example.peopledemo.entiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import lombok.Data;

/**
 * 请假信息表
 *
 * @TableName leave
 */
@TableName(value = "leaveinfo")
@Data
public class LeaveInfoEntity {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 人员id
     */
    private String peopleId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 请假状态（0-请假、1-销假）
     */
    private Integer leaveStatus;

    /**
     * 时间
     */
    private Date time;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除（0-未删除，1-已删除）
     */
    @TableLogic
    private Integer isDelete;
}