package com.base.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.mybatisplus.pojo.User;
import com.base.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhongrui
 * @date 2022/9/4 16:03
 **/
@SpringBootTest
public class MybatisPlusPage
{
    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        Page<User> page = new Page<User>(2, 3);
        Page<User> data = userService.page(page);
        System.out.println(data.getRecords());
        System.out.println(data.getPages());
        System.out.println(data.getSize());
        System.out.println(data.getTotal());
        System.out.println(data.getCurrent());
        System.out.println(data.hasNext());
        System.out.println(data.hasPrevious());
    }

    @Test
    public void test2()
    {
        Page<User> page = new Page<User>(2, 3);
        Page<User> data = userService.selectByAgePage(page, 20);
        System.out.println(data.getRecords());
        System.out.println(data.getPages());
        System.out.println(data.getSize());
        System.out.println(data.getTotal());
        System.out.println(data.getCurrent());
        System.out.println(data.hasNext());
        System.out.println(data.hasPrevious());
    }
}
