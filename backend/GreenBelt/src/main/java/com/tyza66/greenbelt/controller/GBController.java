package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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
@RestController
@RequestMapping("/gb")
public class GBController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Jedis jedis;

    @GetMapping("/flush/{address}")
    public JSON flush(@PathVariable String address) {
        String jsonS = restTemplate.getForObject("http://localhost:96/flush/"+address,String.class);
        JSONObject entries = JSONUtil.parseObj(jsonS);
        return entries;
    }

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

    @GetMapping("/getShidu/{address}")
    public JSON getShidu(@PathVariable String address){
        String s = jedis.get("Shi1du_" + address);
        JSONObject shidu = JSONUtil.createObj().set("Shidu", s);
        return shidu;
    }

    @GetMapping("/getLiangdu/{address}")
    public JSON getiangdu(@PathVariable String address){
        String s = jedis.get("Liangdu_" + address);
        JSONObject liangdu = JSONUtil.createObj().set("Liangdu", s);
        return liangdu;
    }
}

