package com.bruce.springboot.lab55.mapstructdemo.convert;

import com.bruce.springboot.lab55.mapstructdemo.bo.UserBO;
import com.bruce.springboot.lab55.mapstructdemo.dataobj.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    UserBO convert(UserDO userDO);
}
