package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"github.com/gomodule/redigo/redis"
	"io/ioutil"
	"net/http"
)

/**
 * Author: tyza66
 * Date: 2023/04/28 9:06
 * Github: https://github.com/tyza66
 **/
func main() {
	//创建一个gin服务
	ginServer := gin.Default()
	//初始化Redigo连接
	redigo, err := redis.Dial("tcp", "localhost:6379")
	if err != nil {
		fmt.Println(err)
		return
	}
	//验证账号
	if _, err := redigo.Do("AUTH", "000415"); err != nil {
		redigo.Close()
	}

	//刷新缓存的任务接口
	ginServer.GET("/flush", func(context *gin.Context) {
		//刷新缓存中的温度
		wd := getMsg("http://192.168.100.106/wd")
		//fmt.Println(mess)
		redigo.Do("Set","Wendu", wd)
		//刷新缓存中的湿度
		sd := getMsg("http://192.168.100.106/sd")
		redigo.Do("Set","Shidu", sd)
		//刷新缓存中的是否有光照
		ld := getMsg("http://192.168.100.106/ld")
		redigo.Do("Set","Liangdu", ld)
		context.JSON(http.StatusOK, gin.H{"statu": "OK","Wendu":wd,"Shidu":sd,"Liangdu":ld}) //返回json数据
	})

	//启动gin服务在8070端口
	ginServer.Run("localhost:8070")
}
//请求物联网设备信息的公共方法
func getMsg(url string) string{
	resp, err := http.Get(url)
	if err != nil {
		fmt.Println("get url error:", err)
		return "no"
	}
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Println("read body error:", err)
		return "no"
	}
	mess := string(body)
	return mess
}