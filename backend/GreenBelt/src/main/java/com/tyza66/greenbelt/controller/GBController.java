package com.tyza66.greenbelt.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.greenbelt.entity.GBArea;
import com.tyza66.greenbelt.entity.GBBars;
import com.tyza66.greenbelt.mapper.GBAreaMapper;
import com.tyza66.greenbelt.mapper.GBBarMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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
    RedisTemplate redisTemplate;

    @Resource
    GBBarMapper gbBarsMapper;

    @Resource
    GBAreaMapper gbareaMapper;

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
        ValueOperations ops = redisTemplate.opsForValue();
        String s = (String)ops.get("Wendu_" + address);
        //System.out.println(s);
        JSONObject wendu = JSONUtil.createObj();
        //System.out.println(s);
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
        ValueOperations ops = redisTemplate.opsForValue();
        String s = (String) ops.get("Shidu_" + address);
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
        ValueOperations ops = redisTemplate.opsForValue();
        String s = (String)ops.get("Liangdu_" + address);
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

    @ApiOperation(value = "获取物联网设备集群")
    @GetMapping("/getgbs")
    public JSON getGBBars(){
        List<GBBars> allBars = gbBarsMapper.getAllBars();
        return JSONUtil.parseArray(allBars);
    }

    @ApiOperation(value = "获取物联网设备集群设定自动区间")
    @GetMapping("/getgbareas")
    public JSON getGBAreas(){
        List<GBArea> gbAreas = gbareaMapper.getGBAreas();
        return JSONUtil.parseArray(gbAreas);
    }

    @ApiOperation(value = "按地址获取物联网设备集群设定自动区间")
    @GetMapping("/getgbareasad/{address}")
    public JSON getGBAreasByAdd(@PathVariable String address){
        List<GBArea> gbAreas = gbareaMapper.getGBAByAdd(address);
        return JSONUtil.parseArray(gbAreas);
    }

    @ApiOperation(value = "添加物联网设备")
    @PostMapping("/addgbs")
    public JSON addGBBars(@RequestBody GBBars gb){
        int now = gbBarsMapper.addGbBars(gb.getAddress(),gb.getName());
        JSONObject obj = JSONUtil.createObj();
        if(now>=1){
            obj.set("statu","ok");
        }else{
            obj.set("statu","no");
        }
        return obj;
    }

    @ApiOperation(value = "添加出水区间")
    @PostMapping("/addgbareas")
    public JSON addGBAreas(@RequestBody GBArea gb){
        int now = gbareaMapper.addArea(gb.getAddress(),gb.getMin(),gb.getMax());
        JSONObject obj = JSONUtil.createObj();
        if(now>=1){
            obj.set("statu","ok");
        }else{
            obj.set("statu","no");
        }
        return obj;
    }

    @ApiOperation(value = "删除物联网设备")
    @PostMapping("/delgbs")
    public JSON delGBBars(@RequestBody GBBars gb){
        int now = gbBarsMapper.deleteGbBars(gb.getId());
        JSONObject obj = JSONUtil.createObj();
        if(now>=1){
            obj.set("statu","ok");
        }else{
            obj.set("statu","no");
        }
        return obj;
    }
}

