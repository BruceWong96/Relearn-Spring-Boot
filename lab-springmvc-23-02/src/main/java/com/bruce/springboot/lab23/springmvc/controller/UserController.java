package com.bruce.springboot.lab23.springmvc.controller;

import com.bruce.springboot.lab23.springmvc.constants.ServiceExceptionEnum;
import com.bruce.springboot.lab23.springmvc.core.exception.ServiceException;
import com.bruce.springboot.lab23.springmvc.core.vo.CommonResult;
import com.bruce.springboot.lab23.springmvc.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获得指定用户编号的用户
     *
     * 提供不使用 CommonResult 包装
     *
     * @param id
     * @return 用户
     */
    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    /**
     * 获得指定用户编号的用户
     *
     * 提供使用 CommonResult 包装
     *
     * @Param id 用户编号
     * @return 用户
     */
    @GetMapping("/get2")
    public CommonResult<UserVO> get2(@RequestParam("id") Integer id) {
        //查询用户
        UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
        //返回结果
        return CommonResult.success(user);
    }

    @GetMapping("/exception-01")
    public UserVO exception01() {
        throw new NullPointerException("没有鱼丸！！！");
    }

    @GetMapping("/exception-02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("/do_something")
    public void doSomething() {
        logger.info("[doSomething]");
    }

    @GetMapping("/current_user")
    public UserVO currentUser() {
        logger.info("[currentUser]");
        return new UserVO().setId(10).setUsername(UUID.randomUUID().toString());
    }
}
