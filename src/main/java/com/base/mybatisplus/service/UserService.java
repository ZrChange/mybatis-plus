package com.base.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.base.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author zhongrui
 * @date 2022/9/4 11:05
 **/
public interface UserService extends IService<User>
{
    public Map<String, Object> selectToMapById(Long id);

    public Page<User> selectByAgePage(Page<User> page, Integer age);
}
