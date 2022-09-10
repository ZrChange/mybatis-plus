package com.base.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author zhongrui
 * @date 2022/9/4 10:25
 **/
@Repository
public interface UserMapper extends BaseMapper<User>
{
    public Map<String, Object> selectToMapById(@Param("id") Long id);

    public Page<User> selectByAgePage(@Param("page") Page<User> page,@Param("age") Integer age);
}
