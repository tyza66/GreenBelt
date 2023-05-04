package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

/**
 * Author: tyza66
 * Date: 2023/05/03 20:05
 * Github: https://github.com/tyza66
 **/
@Api(tags = "设备状态模块")
@RestController
@RequestMapping("/gb")
public class GBController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Jedis jedis;

    @ApiOperation(value = "刷新设备")
    @GetMapping("/flush/{address}")
    public JSON flush(@PathVariable String address) {
        String jsonS = restTemplate.getForObject("http://localhost:96/flush/"+address,String.class);
        JSONObject entries = JSONUtil.parseObj(jsonS);
        return entries;
    }

    @ApiOperation(value = "获取指定设备温度")
    @GetMapping("/getWendu/{address}")
    public JSON getWendu(@PathVariable String address){
        String s = jedis.get("Wendu_" + address);
        JSONObject wendu = JSONUtil.createObj();
        if(s == null){ //缓存击穿的情况
            String jsonS = restTemplate.getForObject("http://localhost:96/flush/"+address,String.class);
            JSONObject entries = JSONUtil.parseObj(jsonS);
            Object wendu1 = entries.get("Wendu");
            wendu.set("Wendu", wendu1);
        }else{
            wendu.set("Wendu", s);
        }
        return wendu;
    }

    @ApiOperation(value = "获取指定设备湿度")
    @GetMapping("/getShidu/{address}")
    public JSON getShidu(@PathVariable String address){
        String s = jedis.get("Shidu_" + address);
        JSONObject shidu = JSONUtil.createObj();
        if (s == null){
            String jsonS = restTemplate.getForObject("http://localhost:96/flush/"+address,String.class);
            JSONObject entries = JSONUtil.parseObj(jsonS);
            Object shidu1 = entries.get("Shidu");
            shidu.set("Shidu", shidu1);
        }else{
            shidu.set("Shidu", s);
        }
        return shidu;
    }

    @ApiOperation(value = "获取指定设备亮度")
    @GetMapping("/getLiangdu/{address}")
    public JSON getiangdu(@PathVariable String address){
        String s = jedis.get("Liangdu_" + address);
        JSONObject liangdu = JSONUtil.createObj();
        if (s == null){
            String jsonS = restTemplate.getForObject("http://localhost:96/flush/"+address,String.class);
            JSONObject entries = JSONUtil.parseObj(jsonS);
            Object liangdu1 = entries.get("Liangdu");
            liangdu.set("Liangdu", liangdu1);
        }else {
            liangdu.set("Liangdu", s);
        }
        return liangdu;
    }
}

