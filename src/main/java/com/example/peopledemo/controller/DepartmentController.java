package com.example.peopledemo.controller;

import com.example.peopledemo.entiy.DepartmentEntity;
import com.example.peopledemo.service.DepartmentService;
import com.example.peopledemo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 所在部门/工作位置控制器
 *
 * @author Fickler
 * @date 2024/6/7 15:47
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 新增部门/工作位置
     *
     * @param departmentName 部门/工作位置名称
     * @return 成功-true 失败-false
     */
    @PostMapping("/insert")
    public Result insertDepartment(@RequestParam String departmentName) {
        return departmentService.insertDepartment(departmentName) ? Result.success() : Result.error("新增部门/工作位置失败");
    }

    /**
     * 删除部门/工作位置
     *
     * @param id 部门/工作位置id
     * @return 成功-true 失败-false
     */
    @PostMapping("/delete")
    public Result deleteDepartment(@RequestParam String id) {
        return departmentService.deleteDepartment(id) ? Result.success() : Result.error("删除部门/工作位置失败");
    }

    /**
     * 部门/工作位置列表
     *
     * @return Result
     */
    @GetMapping("/list")
    public Result<List<DepartmentEntity>> listDepartment() {
        return Result.success(departmentService.listDepartments());
    }

}
