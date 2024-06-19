package com.example.peopledemo;

import com.example.peopledemo.entiy.UserEntity;
import com.example.peopledemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PeopleDemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<UserEntity> userEntities = userMapper.selectList(null);
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity);
        }
    }

}
