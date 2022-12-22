package com.bruce.springboot.lab55.mapstructdemo;

import com.bruce.springboot.lab55.mapstructdemo.bo.UserBO;
import com.bruce.springboot.lab55.mapstructdemo.convert.UserConvert;
import com.bruce.springboot.lab55.mapstructdemo.dataobj.UserDO;

import java.util.concurrent.CompletableFuture;

public class UserBOTest {
    public static void main(String[] args) {
        //创建 UserDO 对象
        UserDO userDO = new UserDO().setId(1).setUsername("Bruce").setPassword("123");

        // 进行转换
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO.getId());
        System.out.println(userBO.getUsername());
        System.out.println(userBO.getPassword());

    }
}
