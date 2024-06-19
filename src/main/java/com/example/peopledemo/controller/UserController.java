package com.example.peopledemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.peopledemo.entiy.UserEntity;
import com.example.peopledemo.entiy.UserWorkEntity;
import com.example.peopledemo.entiy.dto.UserDto;
import com.example.peopledemo.entiy.dto.UserWorkDto;
import com.example.peopledemo.service.UserService;
import com.example.peopledemo.service.UserWorkService;
import com.example.peopledemo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户接口
 *
 * @author Fickler
 * @date 2024/5/11 17:11
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserWorkService userWorkService;

    /**
     * 新增用户
     *
     * @param userDto 用户dto
     * @return 成功-true 失败-false
     */
    @PostMapping("/insert")
    public Result insertUser(@RequestBody UserDto userDto) {
        List<UserWorkDto> userWorkDtoList = userDto.getUserWorkDtoList();
        boolean result = userService.insertUser(userDto) && userWorkService.insertUserWork(userDto.getUserId(), userWorkDtoList);
        return result ? Result.success() : Result.error("新增用户失败");
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 成功-true 失败-false
     */
    @PostMapping("/delete")
    public Result deleteUser(@RequestParam String userId) {
        return userService.deleteUser(userId) ? Result.success() : Result.error("删除用户失败");
    }

    /**
     * 更新用户
     *
     * @param userDto 用户dto
     * @return 成功-true 失败-false
     */
    @PostMapping("/update")
    public Result<Boolean> updateUser(@RequestBody UserDto userDto) {
        boolean updateUser = userService.updateUser(userDto);
        List<UserWorkDto> userWorkDtoList = userDto.getUserWorkDtoList();
        for (UserWorkDto userWorkDto : userWorkDtoList) {
            String id = userWorkDto.getId();
            if (id == null) {
                boolean insertUserWork = userWorkService.insertUserWork(userDto.getUserId(), userWorkDtoList);
                if (insertUserWork == false) {
                    return Result.error("新增用户工作信息失败");
                }
            } else {
                boolean updateUserWork = userWorkService.updateUserWork(userWorkDto);
                if (updateUserWork == false) {
                    return Result.error("更新用户工作信息失败");
                }
            }
        }
        return Result.success(updateUser);
    }

    /**
     * 查询用户全部信息
     *
     * @param userId 用户id
     * @return 用户entity
     */
    @GetMapping("/select")
    public Result<UserDto> selectUser(@RequestParam String userId) {
        UserEntity userEntity = userService.selectUser(userId);
        List<UserWorkEntity> userWorkEntities = userWorkService.selectUserWorkByUserId(userId);
        ArrayList<UserWorkDto> userWorkDtos = new ArrayList<>();
        for (UserWorkEntity userWorkEntity : userWorkEntities) {
            UserWorkDto userWorkDto = new UserWorkDto();
            userWorkDto.setId(userWorkEntity.getId());
            userWorkDto.setRoleId(userWorkEntity.getRoleId());
            userWorkDto.setDepartmentId(userWorkEntity.getDepartmentId());
            userWorkDto.setPostId(userWorkEntity.getPostId());
            userWorkDto.setStatus(userWorkEntity.getStatus());
            userWorkDtos.add(userWorkDto);
        }
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setIdCard(userEntity.getIdCard());
        userDto.setPhone(userEntity.getPhone());
        userDto.setUserWorkDtoList(userWorkDtos);
        return Result.success(userDto);
    }

    /**
     * 查询全部用户（分页查询）
     *
     * @return 用户列表
     */
    @GetMapping("/selectAll")
    public Result<Page<UserEntity>> selectAllUser(@RequestParam int pageSize, @RequestParam int currentPage) {
        return Result.success(userService.selectAllUser(pageSize, currentPage));
    }

    /**
     * 根据关键字搜索用户
     *
     * @param keyword 关键字
     * @return 用户列表
     */
    @GetMapping("/search")
    public Result<Page<UserEntity>> searchUser(@RequestParam String keyword, @RequestParam int pageSize, @RequestParam int currentPage) {
        return Result.success(userService.searchUser(keyword, pageSize, currentPage));
    }

}
