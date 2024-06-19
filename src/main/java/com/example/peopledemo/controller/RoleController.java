package com.example.peopledemo.controller;

import com.example.peopledemo.entiy.RoleEntity;
import com.example.peopledemo.service.RoleService;
import com.example.peopledemo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色接口
 * @author Fickler
 * @date 2024/5/20 9:45
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 新增角色
     * @param roleName 角色名称
     * @return 成功-true 失败-false
     */
    @PostMapping("/insert")
    public Result insertRole(@RequestParam String roleName) {
        return roleService.insertRole(roleName) ? Result.success() : Result.error("新增角色失败");
    }

    /**
     * 删除角色
     * @param id 角色id
     * @return 成功-true 失败-false
     */
    @PostMapping("delete")
    public Result deleteRole(@RequestParam String id) {
        return roleService.deleteRole(id) ? Result.success() : Result.error("删除角色失败");
    }

    /**
     * 角色列表
     * @return Result
     */
    @GetMapping("list")
    public Result<List<RoleEntity>> listRole() {
        return Result.success(roleService.listRoles());
    }

}
