package com.example.peopledemo.controller;

import com.example.peopledemo.entiy.PostEntity;
import com.example.peopledemo.entiy.RoleEntity;
import com.example.peopledemo.service.PostService;
import com.example.peopledemo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 职位/岗位/工种接口控制器
 * @author Fickler
 * @date 2024/6/7 15:48
 */

@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    /**
     * 新增职位/岗位/工种
     * @param postName 职位/岗位/工种名称
     * @return 成功-true 失败-false
     */
    @PostMapping("/insert")
    public Result insertPost(@RequestParam String postName) {
        return postService.insertPost(postName) ? Result.success() : Result.error("新增职位/岗位/工种失败");
    }

    /**
     * 删除职位/岗位/工种
     * @param id 职位/岗位/工种id
     * @return 成功-true 失败-false
     */
    @PostMapping("/delete")
    public Result deletePost(@RequestParam String id) {
        return postService.deletePost(id) ? Result.success() : Result.error("删除职位/岗位/工种失败");
    }

    /**
     * 职位/岗位/工种列表
     * @return Result
     */
    @GetMapping("/list")
    public Result<List<PostEntity>> listPost() {
        return Result.success(postService.listPosts());
    }

}
