package com.base.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.base.mybatisplus.enums.Sex;
import lombok.Data;

/**
 * @author zhongrui
 * @date 2022/9/4 10:24
 **/
@Data
@TableName("user")
public class User
{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField("is_del")
    @TableLogic
    private Integer isDel;

    private Sex sex;
}
