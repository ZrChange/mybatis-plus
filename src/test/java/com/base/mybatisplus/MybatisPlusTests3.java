package com.base.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.base.mybatisplus.pojo.User;
import com.base.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author zhongrui
 * @date 2022/9/4 14:04
 **/
@SpringBootTest
public class MybatisPlusTests3
{
    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "qq.com");
        wrapper.between("age", 20, 30)
                .orderByDesc("age")
                .orderByAsc("id");

        List<User> userList = userService.list(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test2()
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1L, 2L, 3L);
        userService.remove(wrapper);
    }

    @Test
    public void test3()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a");
        queryWrapper.and(
                i -> i.gt("age", 20).or().like("email", ".com")
        );

        User user = new User();
        user.setEmail("Change@qq.com");
        userService.update(user, queryWrapper);
    }

    @Test
    public void test4()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("age", "email");
        List<Map<String, Object>> maps = userService.listMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test5()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id>5");

        List<User> list = userService.list(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void test6()
    {
        String name = "a";
        Integer startAge = 20;
        Integer endAge = 20;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isBlank(name), "name", name)
                .gt(startAge!=null, "age", startAge)
                .le(endAge!=null, "age", endAge);

        List<User> list = userService.list(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void test7()
    {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("name", "a")
                .gt("age", 20)
                .set("email", "456@qq.com");

        userService.update(wrapper);
    }

    @Test
    public void test8()
    {
        String name = "a";
        Integer startAge = 20;
        Integer endAge = 20;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isBlank(name), new SFunction<User, Object>() {
            @Override
            public Object apply(User user) {
                return user.getAge();
            }
        }, name)
                .gt(startAge!=null, User::getAge, startAge)
                .le(endAge!=null, User::getAge, endAge);

        List<User> list = userService.list(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test9()
    {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(User::getName, "a")
                .gt(User::getAge, 20)
                .set(User::getEmail, "456@qq.com");

        userService.update(wrapper);
    }
}
