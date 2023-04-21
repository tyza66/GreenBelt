# Green Belt
### 基于大数据和物联网的可视化城市绿化带自动灌溉系统
> ##### *A Visualized Urban Greenbelt Automatic Irrigation System Based on Big Data and Internet of Things*

1. #### 后端部分

   - 开发环境：Idea2020，Maven3.6，Java1.8，Golang1.20
   - Java应用技术：Spring Boot2.7.11，
   - Go使用技术：Gin，一种采用Java多线程底层队列思想制作的物联网硬件状态检查轮询机制
   - 说明：采用[分布式架构](#其他说明)，分布式集群中可包括多后端服务器(可使用不同编程语言实现业务逻辑)和多物联网硬件设备，后续可以拓展注册中心和微服务等形式。演示项目中业务主控服务器由Spring Cloud Web(java框架)框架支持，轮询各硬件设备状态由Gin(Go框架)服务

2. #### 前端部分

   - 环境：Node，Vue2.0，HBuilderX，VS code
   - 应用技术：Vue2.0，ElementuiPlus

3. #### 硬件部分

   - 环境：ESP8266开发板，ArduinoIDE，嘉立创EDA专业版
   - 应用技术：C语言，模块图纸及相关文档，常用硬件开发库

4. #### 数据库部分

   - 环境：MySql，Redis
   - 说明：MySql作为用户信息等长期数据库，Redis作为缓存数据库

5. #### 其他说明

   - 由于这是一个参加开发比赛用的比赛项目，没必要过于完整，我们只要演示部分功能即可，所以很多方面只是基础的实现，但是最终成品的完整度相对也是很高的
   - ​

By：tyza66(洮羱芝闇/孙达明)，morsite(Li Bling/李亮)