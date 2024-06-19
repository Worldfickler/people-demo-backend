package com.example.peopledemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.peopledemo.entiy.RoleEntity;
import com.example.peopledemo.mapper.RoleMapper;
import com.example.peopledemo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 角色服务实现
* @author dell
* @description 针对表【role】的数据库操作Service实现
* @createDate 2024-05-11 16:47:31
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity>
    implements RoleService {

    /**
     * 新增角色接口实现
     * @param roleName 角色名称
     * @return 成功-true 失败-false
     */
    @Override
    public boolean insertRole(String roleName) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleName);
        return this.save(roleEntity);
    }

    /**
     * 删除角色接口实现
     * @param roleId 角色id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean deleteRole(String roleId) {
        return this.removeById(roleId);
    }

    /**
     * 角色列表
     * @return List<RoleEntity>
     */
    @Override
    public List<RoleEntity> listRoles() {
        return this.list();
    }
}




