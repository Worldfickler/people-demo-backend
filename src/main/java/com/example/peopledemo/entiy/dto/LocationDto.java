package com.example.peopledemo.entiy.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 位置请求
 * @author Fickler
 * @date 2024/5/20 9:57
 */

@Data
public class LocationDto implements Serializable {
    private static final long serialVersionUID = -6105586763334804841L;

    /**
     * 工作位置
     */
    private String workLocation;
}
