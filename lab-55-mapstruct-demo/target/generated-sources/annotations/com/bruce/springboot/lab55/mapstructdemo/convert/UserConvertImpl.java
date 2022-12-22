package com.bruce.springboot.lab55.mapstructdemo.convert;

import com.bruce.springboot.lab55.mapstructdemo.bo.UserBO;
import com.bruce.springboot.lab55.mapstructdemo.dataobj.UserDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-20T14:45:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserBO convert(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserBO userBO = new UserBO();

        userBO.setId( userDO.getId() );
        userBO.setUsername( userDO.getUsername() );
        userBO.setPassword( userDO.getPassword() );

        return userBO;
    }
}
