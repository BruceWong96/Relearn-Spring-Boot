package com.bruce.springboot.lab23.springmvc.core.web;

import com.bruce.springboot.lab23.springmvc.constants.ServiceExceptionEnum;
import com.bruce.springboot.lab23.springmvc.core.exception.ServiceException;
import com.bruce.springboot.lab23.springmvc.core.vo.CommonResult;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Bruce Wong
 * @date 2022年12月23日 10:53
 */
@ControllerAdvice(basePackages = "com.bruce.springboot.lab23.springmvc.controller")
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理 ServiceException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest req, ServiceException ex) {
        logger.debug("[serviceExceptionHandler]", ex);
        // 包装结果
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理 MissingServletRequestParameterException 异常
     * SpringMVC 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServeltRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException ex) {
        logger.debug("[missingServeltRequestParameterExceptionHandler]", ex);
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其他异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("[exceptionHandler]", e);
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }
}
