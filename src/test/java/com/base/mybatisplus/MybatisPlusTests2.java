package com.base.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.mybatisplus.mapper.UserMapper;
import com.base.mybatisplus.pojo.User;
import com.base.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhongrui
 * @date 2022/9/4 11:10
 **/
@SpringBootTest
public class MybatisPlusTests2
{
    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        Map<String, Object> stringObjectMap = userService.selectToMapById(4L);
        System.out.println(stringObjectMap);
    }

    @Test
    public void test2()
    {
        int count = userService.count();
        System.out.println(count);
    }

    @Test
    public void test3()
    {
        List<User> users = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setName("Change" + i);
            user.setAge(20+i);
            user.setEmail("123456" + i + "qq.com");
            users.add(user);
        }
        userService.saveBatch(users);
    }

    @Test
    public void test4()
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "Change%")
                .and(i -> i.gt("age", 15));

        List<User> objects = userService.list(wrapper);
        System.out.println(objects);
    }
}
