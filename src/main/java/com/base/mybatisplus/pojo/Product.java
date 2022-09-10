package com.base.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author zhongrui
 * @date 2022/9/4 16:44
 **/
@TableName("t_product")
@Data
public class Product
{
    @TableId
    private Integer id;
    private String name;
    private Integer price;

    @Version
    private Integer version;
}
