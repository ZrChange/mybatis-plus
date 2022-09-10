package com.base.mybatisplus;

import com.base.mybatisplus.enums.Sex;
import com.base.mybatisplus.mapper.ProductMapper;
import com.base.mybatisplus.pojo.Product;
import com.base.mybatisplus.pojo.User;
import com.base.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhongrui
 * @date 2022/9/4 16:46
 **/
@SpringBootTest
public class MybatisPlusLockTest
{
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        Product product = productMapper.selectById(1);
        product.setPrice(product.getPrice() + 50);

        Product product2 = productMapper.selectById(1);
        product2.setPrice(product.getPrice() - 30);

        int i = productMapper.updateById(product);
        System.out.println("update row:" + i);

        i = productMapper.updateById(product2);
        System.out.println("update row:" + i);
        if (i == 0)
        {
            Product product3 = productMapper.selectById(1);
            product3.setPrice(product.getPrice() - 30);

            i = productMapper.updateById(product);
            System.out.println("update row:" + i);
        }
    }

    @Test
    public void test2()
    {
        User byId = userService.getById(7);
        byId.setSex(Sex.MALE);
        boolean b = userService.updateById(byId);
        System.out.println("result update row:" + b);
    }
}
