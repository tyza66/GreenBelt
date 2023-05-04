package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tyza66.greenbelt.entity.User;
import com.tyza66.greenbelt.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/05/04 12:42
 * Github: https://github.com/tyza66
 **/
@Api(tags = "用户登录模块")
@SessionAttributes("currentUser")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public JSON signUp(@RequestBody User user, Model model, HttpSession session) {
        List<User> userByAccount = userMapper.getUserByAccount(user.getAccount());
        JSONObject set = JSONUtil.createObj().set("statu", "false");
        if (userByAccount.size() != 0) {
            User user1 = userByAccount.get(0);
            if (user1.getPassword().equals(user.getPassword())) {
                set.set("statu", "true");
                model.addAttribute("currentUser", user1);
            }
        }
        return set;
    }

    @ApiOperation(value = "验证登录状态")
    @GetMapping("/logined")
    public JSON logined(Model model) {
        User currentUser = (User) model.getAttribute("currentUser");
        JSONObject toJson = JSONUtil.createObj();
        if (currentUser != null) {
            toJson = JSONUtil.parseObj(currentUser);
        } else {
            toJson.set("status", "-1");
        }
        return toJson;
    }
}
