package com.example.peopledemo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.peopledemo.entiy.DepartmentEntity;
import com.example.peopledemo.mapper.DepartmentMapper;
import com.example.peopledemo.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 所在部门/工作位置服务实现
 *
 * @author dell
 * @description 针对表【department】的数据库操作Service实现
 * @createDate 2024-06-07 15:33:23
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentEntity>
        implements DepartmentService {


    /**
     * 新增所在部门/工作位置
     *
     * @param departmentName 所在部门/工作位置名称
     * @return
     */
    @Override
    public boolean insertDepartment(String departmentName) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentName);
        return this.save(departmentEntity);
    }

    /**
     * 删除所在部门/工作位置
     *
     * @param departmentId 所在部门/工作位置id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean deleteDepartment(String departmentId) {
        return this.removeById(departmentId);
    }

    /**
     * 所在部门/工作位置列表
     *
     * @return List<DepartmentEntity>
     */
    @Override
    public List<DepartmentEntity> listDepartments() {
        return this.list();
    }
}




