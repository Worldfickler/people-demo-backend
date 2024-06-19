package com.example.peopledemo.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Fickler
 * @date 2024/6/11 8:43
 */
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = 2263092606639165382L;
    /**
     * 页面大小
     */
    protected int pageSize;

    /**
     * 当前是第几页
     */
    protected int pageNum;

}
