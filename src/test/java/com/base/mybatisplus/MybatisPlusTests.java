package com.base.mybatisplus;

import com.base.mybatisplus.mapper.UserMapper;
import com.base.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongrui
 * @date 2022/9/4 10:25
 **/
@SpringBootTest
public class MybatisPlusTests
{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test()
    {
        User user = new User();
        user.setName("Change");
        user.setAge(20);
        user.setEmail("123456@qq.com");
        userMapper.insert(user);
        System.out.println("result:" + user.getId());
    }

    @Test
    public void test2()
    {
        int result = userMapper.deleteById(1L);
        System.out.println(result);

        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        result = userMapper.deleteBatchIds(longs);
        System.out.println(result);

        Map<String, Object> maps = new HashMap<>();
        maps.put("name", "Change");
        maps.put("age", 20);
        result = userMapper.deleteByMap(maps);
        System.out.println(result);
    }

    @Test
    public void test3()
    {
        User user = new User();
        user.setId(4L);
        user.setName("Base");
        user.setAge(50);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }


    @Test
    public void test4()
    {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        User user = userMapper.selectById(4L);
        System.out.println(user);

        Map<String, Object> maps = new HashMap<>();
        maps.put("name", "base");
        List<User> queryUsers = userMapper.selectByMap(maps);
        queryUsers.forEach(System.out::println);

    }
}
