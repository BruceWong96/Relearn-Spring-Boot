package com.bruce.springboot.lab23.springmvc.core.exception;

import com.bruce.springboot.lab23.springmvc.constants.ServiceExceptionEnum;

/**
 * @author Bruce Wong
 * @date 2022年12月22日 22:41
 */
public class ServiceException extends RuntimeException{
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        super(serviceExceptionEnum.getMessage());
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
