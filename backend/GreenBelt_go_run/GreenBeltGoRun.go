package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	_ "github.com/go-sql-driver/mysql"
	"github.com/gomodule/redigo/redis"
	"io/ioutil"
	"net/http"
	"xorm.io/xorm"
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
	//定义数据库连接信息
	var (
		userName  string = "root"
		password  string = "123456"
		ipAddress string = "127.0.0.1"
		port      int    = 3306
		dbName    string = "GreenBelt"
		charset   string = "utf8mb4"
	)
	//定义用于同步关系型数据库中对象的结构体
	type GBBars struct {
		Id int64
		Address string
		Name string
		Group int
	}
	//定义设备列表 最多20个设备
	//drivers := GBQueue{buff: make([]string, 20), maxsize: 20, front: -1, rear: -1}
	dataSourceName := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=%s", userName, password, ipAddress, port, dbName, charset)
	engine, err := xorm.NewEngine("mysql", dataSourceName)
	if err != nil {
		fmt.Println("数据库连接失败")
	}
	//同步数据库中的表
	err = engine.Sync(new(GBBars))
	if err != nil {
		fmt.Println("同步表结构失败")
	}
	rows, err := engine.Rows(&GBBars{Group:1})
	userBean := new(GBBars)
	for rows.Next() {
		rows.Scan(userBean)
		fmt.Println(userBean)
	}

	//刷新缓存的任务接口 路径参数为带端口号的设备访问地址
	ginServer.GET("/flush/:way", func(context *gin.Context) {
		way := context.Param("way")
		fmt.Println(way)
		//刷新缓存中的温度
		wd := getMsg("http://" + way + "/wd")
		if wd != "" {
			redigo.Do("Set", "Wendu_"+way, wd)
		}
		//刷新缓存中的湿度
		sd := getMsg("http://" + way + "/sd")
		if sd != "" {
			redigo.Do("Set", "Shidu_"+way, sd)
		}
		//刷新缓存中的是否有光照
		ld := getMsg("http://" + way + "/ld")
		if ld != "" {
			redigo.Do("Set", "Liangdu_"+way, ld)
		}
		context.JSON(http.StatusOK, gin.H{"statu": "OK", "Wendu": wd, "Shidu": sd, "Liangdu": ld}) //返回json数据
	})

	//启动gin服务在8070端口
	ginServer.Run("localhost:8070")
}

// 请求物联网设备信息的公共方法
func getMsg(url string) string {
	resp, err := http.Get(url)
	if err != nil {
		fmt.Println("get url error:", err)
		return ""
	}
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Println("read body error:", err)
		return ""
	}
	mess := string(body)
	return mess
}

// 定义物联网设备队列
type GBQueue struct {
	buff    []string //队列的的数据存储在数组上
	maxsize int      //队列最大容量
	front   int      //队列头索引，不包括自己（队列头索引值-1）
	rear    int      //队列尾索引
}

// 入设备队列
func (q *GBQueue) Push(n string) error {
	if q.rear == q.maxsize-1 {
		if q.front == -1 { //头尾都到头了
			return fmt.Errorf("队列已满，PUSH失败")
		} else {
			q.front = -1
			q.rear = len(q.buff) - 1
		}
	}
	q.rear++
	q.buff = append(q.buff, n)
	return nil
}

// 出设备队列
func (q *GBQueue) Pop() (n string, err error) {
	if len(q.buff) == 0 {
		return "", fmt.Errorf("空队列,POP失败")
	}
	n = q.buff[0]
	q.buff = q.buff[1:]
	q.front++
	return n, nil
}
