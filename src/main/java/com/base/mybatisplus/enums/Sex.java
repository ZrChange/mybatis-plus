package com.base.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhongrui
 * @date 2022/9/4 16:57
 **/
@Getter
public enum Sex
{
    FEMALE(1, "男"),
    MALE(2, "女");

    @EnumValue
    private Integer value;
    private String name;

    Sex() {
    }

    Sex(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
