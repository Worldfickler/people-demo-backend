package com.example.peopledemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应工具类
 *
 * @author Fickler
 * @date 2024/6/6 17:56
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    // 业务状态码  0-成功  1-失败
    private Integer code;
    // 提示信息
    private String message;
    // 响应数据
    private T data;

    /**
     * 快速返回操作成功响应结果(带响应数据)
     *
     * @param data 响应数据
     * @param <E>
     * @return Result
     */
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    /**
     * 快速返回操作成功响应结果
     *
     * @return Result
     */
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    /**
     * 快速返回操作失败响应结果
     *
     * @param message 提示信息
     * @return Result
     */
    public static Result error(String message) {
        return new Result(1, message, null);
    }

}
