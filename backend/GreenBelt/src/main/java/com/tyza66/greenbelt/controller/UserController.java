package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.greenbelt.entity.User;
import com.tyza66.greenbelt.mapper.UserMapper;
import com.tyza66.greenbelt.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Author: tyza66
 * Date: 2023/05/04 12:42
 * Github: https://github.com/tyza66
 **/
@Api(tags = "用户登录状态模块")
@RestController
@RequestMapping("/user")
public class UserController {


    @ApiOperation(value = "验证登录状态")
    @GetMapping("/logined")
    public JSON logined() {
        JSONObject toJson = JSONUtil.createObj();
        toJson.set("status","ok");
        return toJson;
    }


}
