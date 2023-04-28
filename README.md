# Green Belt
### 基于大数据和物联网的可视化城市绿化带自动灌溉系统
> ##### *A Visualized Urban Greenbelt Automatic Irrigation System Based on Big Data and Internet of Things*
>

1. #### 后端部分

   开发环境：Idea2020，Maven3.6，Java1.8，Nacos1.4.1，Golang1.20，Git

   Java应用技术：Spring Boot2.7.11，Spring Cloud Alibaba，Nacos，Mybatis，Lombok，Thymeleaf，nife4j-openapi2(swigger2)

   Go使用技术：Gin，xorm，Redigo，一种采用Java多线程底层队列思想和Go程信道特性制作的物联网硬件状态检查轮询机制

   说明：采用[混合型分布式架构](#其他说明)，分布式集群中可包括多后端服务器(可使用不同编程语言实现业务逻辑)和多物联网硬件设备，后续可以拓展注册中心集群和各种微服务达到亿级访问量承载，以实现全国范围绿化带管理。演示项目中业务主控服务器由Spring Boot Web(java框架)框架支持，轮询各硬件设备状态由Gin(Go框架)服务支持

2. #### 前端部分

   环境：Node，Vue2.0，HBuilderX，VS code

   应用技术：Vue2.0，ElementuiPlus

   网页部分：ElementuiPlus框架自带的响应式布局，会有Github Page和Gitee Page等演示界面

   App部分：使用Uniapp可打包Android应用，iOS应用(需要加入App开发者联盟)等，我们演示项目只打包Android应用作为演示

   小程序部分：由于我们使用Uniapp一站式开发，小程序随时可以打包，是否上线小程序还待考虑

   说明：我们采用前后端分离的思想，并尽力消除跨域时出现的问题。本项目响应式网页和App使用两次不同的模式进行开发(Vue，Uniapp)，其中一次致力于网页端可视化的体验，另一侧致力于App和小程序的体验

3. #### 硬件部分

   环境：ESP8266开发板，ArduinoIDE，嘉立创EDA专业版

   应用技术：C语言，模块图纸及相关文档，常用硬件开发库

   使用库：ESP8266WiFi，ESP8266WiFiMulti，ESP8266WebServer，OneWire，DallasTemperature，stdio

   项目中对应文件夹：成果\集群物联网设备固件及图片\sketch_apr27a，esp8266\烧录程序

4. #### 数据库部分

   环境：MySql，Redis，Navicate，RedisInsight-v2

   说明：MySql作为长期静态数据数据库，Redis作为缓存数据库用于更新物联网设备集群中各个设备状态

5. #### 其他说明

   完整性：由于本项目为比赛项目，缺少设备和时间，我们对单个物联网集群设备只进行了基础实现

   混合型分布式架构：我们使用手写的方式实现分布式请求和Spring Cloud Alibaba系列注册中心Nacos提供微服务可拓展性相结合，大幅度无上限提高运行稳定性和效率。我们的演示项目是单台设备运行，单台服务器部署，可能无法体现优势。

   不足：硬件层面，缺乏硬件设备(继电器，水泵，蜂鸣器等)我们均使用红色发光二极管代替

   主题：开发主题为“行业数字化”，本项目为城市绿化数字化管理项目

   开源：为了提供学习价值，本项目会在比赛投稿截止后开源

6. #### 本地复现

By：tyza66(洮羱芝闇/孙达明)，morsite(Li Bling/李亮)
