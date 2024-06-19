package com.example.peopledemo.service;

import com.example.peopledemo.entiy.DepartmentEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.peopledemo.entiy.RoleEntity;

import java.util.List;

/**
 * 所在部门/工作位置服务
 *
 * @author dell
 * @description 针对表【department】的数据库操作Service
 * @createDate 2024-06-07 15:33:23
 */
public interface DepartmentService extends IService<DepartmentEntity> {

    /**
     * 新增所在部门/工作位置服务接口
     *
     * @param departmentName 所在部门/工作位置名称
     * @return 成功-true 失败-false
     */
    boolean insertDepartment(String departmentName);

    /**
     * 删除所在部门/工作位置接口
     *
     * @param departmentId 所在部门/工作位置id
     * @return 成功-true 失败-false
     */
    boolean deleteDepartment(String departmentId);

    /**
     * 所在部门/工作位置列表
     *
     * @return List<RoleEntity>
     */
    List<DepartmentEntity> listDepartments();

}
