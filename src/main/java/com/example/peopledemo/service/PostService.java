package com.example.peopledemo.service;

import com.example.peopledemo.entiy.PostEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.peopledemo.entiy.RoleEntity;

import java.util.List;

/**
 * 职位/岗位/工种服务
 *
 * @author dell
 * @description 针对表【post】的数据库操作Service
 * @createDate 2024-06-07 15:33:23
 */
public interface PostService extends IService<PostEntity> {

    /**
     * 新增职位/岗位/工种接口
     *
     * @param postName 职位/岗位/工种名称
     * @return 成功-true 失败-false
     */
    boolean insertPost(String postName);

    /**
     * 删除职位/岗位/工种接口
     *
     * @param postId 角色id
     * @return 成功-true 失败-false
     */
    boolean deletePost(String postId);

    /**
     * 职位/岗位/工种列表
     *
     * @return List<PostEntity>
     */
    List<PostEntity> listPosts();

}
