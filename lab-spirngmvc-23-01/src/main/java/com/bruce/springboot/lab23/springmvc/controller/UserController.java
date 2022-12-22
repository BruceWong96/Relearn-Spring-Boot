package com.bruce.springboot.lab23.springmvc.controller;

import com.bruce.springboot.lab23.springmvc.dto.UserAddDTO;
import com.bruce.springboot.lab23.springmvc.dto.UserUpdateDTO;
import com.bruce.springboot.lab23.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * 查询用户列表
     * @return 用户列表
     */
    @GetMapping("")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("bruce"));
        result.add(new UserVO().setId(2).setUsername("wong"));
        result.add(new UserVO().setId(3).setUsername("haha"));

        return result;
    }

    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        //查询并返回用户
        return new UserVO().setId(id).setUsername("username: " + id);
    }
    /**
     * 添加用户
     *
     * @param userAddDTO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("")
    public Integer add(UserAddDTO userAddDTO) {
        //插入用户记录，返回编号
        Integer returnId = 1;
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param id 用户编号
     * @param userUpdateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO userUpdateDTO){
        // 将 id 设置到 updateDTO 中
        userUpdateDTO.setId(id);
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    /**
     * 删除指定用户编号的用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }
}
