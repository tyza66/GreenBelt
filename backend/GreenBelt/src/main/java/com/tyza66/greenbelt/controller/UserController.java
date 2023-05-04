package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.greenbelt.entity.User;
import com.tyza66.greenbelt.mapper.UserMapper;
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
import java.util.List;
import java.util.Random;

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
    private String number;
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
            toJson.set("statu", "-1");
        }
        return toJson;
    }

    @ApiOperation(value = "生产图片验证码")
    @GetMapping("/qcr")
    public void getQCR(HttpServletResponse response) throws IOException {
        //创建空白图片
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        //设置画笔颜色
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        //绘制矩形背景
        g.fillRect(0, 0, 100, 30);
        //绘制八条干扰线
        for (int i = 1; i <= 8; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }
        //画字母
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        number = getNumbers(5);
        g.setFont(new Font(null, Font.BOLD + Font.ITALIC, 24));
        g.drawString(number, 5, 25);
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpeg", out);
        out.close();
    }

    //提供随机种子
    public String getNumbers(int size) {
        String str = "df5d6daas2ekfofsaffp66sgfsgfsd8a6fhoi635g4s56g4sgfgd65ggsg5464f4ewgs22d65g";
        String number = "";
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            number = number + str.charAt(r.nextInt(str.length()));
        }
        return number;
    }

    @ApiOperation(value = "注册新用户")
    @PostMapping("/sign")
    public JSON sign(@RequestBody User user) {
        List<User> userByAccount = userMapper.getUserByAccount(user.getAccount());
        JSONObject json = JSONUtil.createObj();
        if (userByAccount.size() >= 1) {
            json.set("statu", "have");
        } else {
            if (user.getNickname().equalsIgnoreCase(number)) {
                if (userMapper.newUserCount(user) >= 1) {
                    json.set("statu", "ok");
                } else {
                    json.set("statu", "sjk");
                }
            } else {
                json.set("statu", "yzm");
            }
        }
        return json;
    }
}
