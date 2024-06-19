package com.example.peopledemo.entiy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户dto
 *
 * @author Fickler
 * @date 2024/5/11 17:39
 */

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -2150078878608877635L;

    /**
     * 用户id
     */
    @JsonProperty("id")
    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 用户工作信息列表
     */
    private List<UserWorkDto> userWorkDtoList;
}
