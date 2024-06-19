package com.example.peopledemo.service;

import com.example.peopledemo.entiy.RoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色服务
* @author dell
* @description 针对表【role】的数据库操作Service
* @createDate 2024-05-11 16:47:31
*/
public interface RoleService extends IService<RoleEntity> {

    /**
     * 新增角色接口
     * @param roleName 角色名称
     * @return 成功-true 失败-false
     */
    boolean insertRole(String roleName);

    /**
     * 删除角色接口
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    boolean deleteRole(String roleId);

    /**
     * 角色列表
     * @return List<RoleEntity>
     */
    List<RoleEntity> listRoles();

}
