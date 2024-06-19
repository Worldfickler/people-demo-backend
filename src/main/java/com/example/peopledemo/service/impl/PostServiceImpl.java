package com.example.peopledemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.peopledemo.entiy.PostEntity;
import com.example.peopledemo.entiy.RoleEntity;
import com.example.peopledemo.mapper.PostMapper;
import com.example.peopledemo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 职位/岗位/工种服务实现
 *
 * @author dell
 * @description 针对表【post】的数据库操作Service实现
 * @createDate 2024-06-07 15:33:23
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, PostEntity>
        implements PostService {

    /**
     * 新增职位/岗位/工种
     * @param postName 职位/岗位/工种名称
     * @return 成功-true 失败-false
     */
    @Override
    public boolean insertPost(String postName) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostName(postName);
        return this.save(postEntity);
    }

    /**
     * 删除职位/岗位/工种
     * @param postId 职位/岗位/工种id
     * @return 成功-true 失败-false
     */
    @Override
    public boolean deletePost(String postId) {
        return this.removeById(postId);
    }

    /**
     * 职位/岗位/工种列表
     * @return List<PostEntity>
     */
    @Override
    public List<PostEntity> listPosts() {
        return this.list();
    }
}




