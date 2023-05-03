package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: tyza66
 * Date: 2023/05/03 20:05
 * Github: https://github.com/tyza66
 **/
@RestController
@RequestMapping("/gb")
public class GBController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/flush")
    public JSON flush(){
        String jsonS = restTemplate.getForObject("http://localhost:96/flush/192.168.100.106:80",String.class);
        JSONObject entries = JSONUtil.parseObj(jsonS);
        return entries;
    }
}
