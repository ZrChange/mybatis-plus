package com.base.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.mybatisplus.mapper.UserMapper;
import com.base.mybatisplus.pojo.User;
import com.base.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhongrui
 * @date 2022/9/4 11:05
 **/
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> selectToMapById(Long id)
    {
        return userMapper.selectToMapById(id);
    }

    @Override
    public Page<User> selectByAgePage(Page<User> page, Integer age)
    {
        return userMapper.selectByAgePage(page, age);
    }

}
