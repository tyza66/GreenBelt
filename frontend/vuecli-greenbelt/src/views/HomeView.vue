<template>
  <div class="main">
    <div class="head">
      <h1 class="title">城市绿化带管理系统</h1>
      <a href="https://github.com/tyza66/GreenBelt" target="_blank"><svg id="github" height="32" aria-hidden="true"
          viewBox="0 0 16 16" version="1.1" width="32" data-view-component="true"
          class="octicon octicon-mark-github v-align-middle">
          <path
            d="M8 0c4.42 0 8 3.58 8 8a8.013 8.013 0 0 1-5.45 7.59c-.4.08-.55-.17-.55-.38 0-.27.01-1.13.01-2.2 0-.75-.25-1.23-.54-1.48 1.78-.2 3.65-.88 3.65-3.95 0-.88-.31-1.59-.82-2.15.08-.2.36-1.02-.08-2.12 0 0-.67-.22-2.2.82-.64-.18-1.32-.27-2-.27-.68 0-1.36.09-2 .27-1.53-1.03-2.2-.82-2.2-.82-.44 1.1-.16 1.92-.08 2.12-.51.56-.82 1.28-.82 2.15 0 3.06 1.86 3.75 3.64 3.95-.23.2-.44.55-.51 1.07-.46.21-1.61.55-2.33-.66-.15-.24-.6-.83-1.23-.82-.67.01-.27.38.01.53.34.19.73.9.82 1.13.16.45.68 1.31 2.69.94 0 .67.01 1.3.01 1.49 0 .21-.15.45-.55.38A7.995 7.995 0 0 1 0 8c0-4.42 3.58-8 8-8Z">
          </path>
        </svg>
      </a>
    </div>
    <div class="down">
      <div class="bar">
        <el-tabs style="height: 200px" class="demo-tabs">
          <el-tab-pane label="首页">
            <div class="sy">
              <div class="weather-continer">
                <el-card class="box-card hh">
                  <template #header>
                    <div class="card-header">
                      <span>'北京'今日天气</span>
                    </div>
                  </template>
                  <div>日期：{{ weather.fxDate }}</div>
                  <div>日出时间：{{ weather.sunrise }}</div>
                  <div>日落时间：{{ weather.sunset }}</div>
                  <div>最高温度：{{ weather.tempMax + "℃" }}</div>
                  <div>最低温度：{{ weather.tempMin + "℃" }}</div>
                  <div>白天天气：{{ weather.textDay }}</div>
                  <div>夜间天气：{{ weather.textNight }}</div>
                  <div>白天风：{{ weather.windDirDay + "，" + weather.windScaleDay + "级" }}</div>
                  <div>夜间风：{{ weather.windDirNight + "，" + weather.windScaleNight + "级" }}</div>
                  <div>气压：{{ weather.pressure }}</div>
                </el-card>
              </div>
              <div class="driver-continer">
                <el-card class="box-card hh">
                  <template #header>
                    <div class="card-header">
                      <span>当前设备</span>
                    </div>
                  </template>
                  <div class="driver">
                    <img src="../assets/images/esp8266.webp" />
                    <h4>{{ nowGbName + ":" + nowGbAddress }}</h4>
                    <el-dropdown class="ed">
                      <span class="el-dropdown-link">
                        选择设备
                        <el-icon class="el-icon--right">
                          <arrow-down />
                        </el-icon>
                      </span>
                      <template #dropdown>
                        <el-dropdown-menu>
                          <el-dropdown-item v-for="(one, i) in drivers" :key="i" @click="chooseDrive(i)">{{ one.name
                          }}</el-dropdown-item>
                        </el-dropdown-menu>
                      </template>
                    </el-dropdown>
                  </div>
                </el-card>
              </div>
              <div id="main1" ref="chart1">
              </div>
              <div class="other-container">
                <el-card class="box-card hh2">
                  <template #header>
                    <div class="card-header">
                      <span>其他信息</span>
                    </div>
                  </template>
                  <div>自动浇水低阈值：{{ nowMin }}</div>
                  <div>停止浇水高阈值：{{ nowMax }}</div>
                  <div>Green Belt</div>
                  <div>版本：1.0</div>
                </el-card>
              </div>
              <div class="light-container">
                <el-card class="box-card hh2">
                  <template #header>
                    <div class="card-header">
                      <span>亮度信息</span>
                    </div>
                  </template>
                  <div>亮度传感器1：{{ light }}</div>
                </el-card>
              </div>
              <div id="main2" ref="chart2">
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="设备信息">
            <div class="sbxx">
              <div class="info-bar">
                <span class="s1">设备id</span>
                <span class="s2">设备名称</span>
                <apan class="s3">设备地址</apan>
                <span class="s4">设备型号</span>
                <span class="s6">设备组</span>
                <span class="s7">出水低阈值</span>
                <span class="s8">停水高阈值</span>
              </div>
              <div class="info-bar" v-for="(one, i) in drivers" :key="i">
                <span class="s1">{{ one.id }}</span>
                <span class="s2">{{ one.name }}</span>
                <apan class="s3">{{ one.address }}</apan>
                <span class="s4">ESP8266</span>
                <span class="s6">{{ one.group }}</span>
                <span class="s7">{{ one.min }}</span>
                <span class="s8">{{ one.max }}</span>
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="设备管理">
            <div class="sbgl">
              <div class="control-bar">
                <span class="s1">设备id</span>
                <span class="s2">设备名称</span>
                <span class="s3">设备地址</span>
                <span class="s4">开关水阈值</span>
                <span class="s5">操作</span>
                <span class="s6"><el-button type="success" @click="addOne()">添加设备</el-button></span>
              </div>
              <div class="control-bar" v-for="(one, i) in drivers" :key="i">
                <span class="s1">{{ one.id }}</span>
                <span class="s2">{{ one.name }}</span>
                <span class="s3">{{ one.address }}</span>
                <span class="s4">{{ one.min + " " + one.max }}</span>
                <span class="s7"><el-button type="primary">修改阈值</el-button><el-button
                    type="danger">删除设备</el-button></span>
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="关于">
            <div class="gy">

            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
    <el-dialog v-model="ADDdialogVisible" title="添加设备" width="30%" :before-close="handleClose">
      <span>设备名称：<el-input v-model="input_name" placeholder="请输入" /></span>
      <span>设备地址：<el-input v-model="input_address" placeholder="请输入" /></span>
      <span>湿度出水低阈值：<el-input v-model="input_min" placeholder="请输入" /></span>
      <span>停止出水高阈值：<el-input v-model="input_max" placeholder="请输入" /></span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="ADDdialogVisible = false">取消</el-button>
          <el-button type="primary" @click="updateOD()">
            提交
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<style>
.left1 {
  float: left;
  width: 120px;
  height: 230px;
}

.bar {
  width: 100%;
  margin: 0 auto;
}

.el-tabs__nav-wrap::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 2px;
  background-color: var(--el-border-color-light);
  z-index: var(--el-index-normal);
  display: none;
}

.el-tabs__nav-scroll {
  background-color: rgba(239, 239, 239, 0.236);
}

.el-tabs__item {
  padding: 10px 40px !important;
  height: var(--el-tabs-header-height);
  box-sizing: border-box;
  display: flex;
  align-items: center;
  justify-content: center;
  list-style: none;
  font-size: var(--el-font-size-base);
  font-weight: 500;
  color: var(--el-text-color-primary);
  position: relative;
}

.sy {
  width: 90%;
  margin: 0 auto;
}

.sbxx {
  width: 95%;
  margin: 0 auto;
}

.sbgl {
  width: 95%;
  margin: 0 auto;
}

.gy {
  width: 95%;
  margin: 0 auto;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 280px;
}

.box-card {
  background-color: rgba(255, 255, 255, 0.20) !important;
}

.box-card div {
  line-height: 20px;
}

.weather-continer {
  width: 280px;
  float: left;
}

#main1 {
  width: 610px;
  height: 300px;
  background-color: rgba(255, 255, 255, 0.852);
  float: left;
  margin-left: 50px;
  border-radius: 5px;
}

.driver-continer {
  width: 280px;
  float: left;
  margin-left: 50px;
}

.driver {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.driver img {
  width: 150px;
  height: 150px;
  display: inline-block;
  margin: 0 auto;
  align-self: center;
}

.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}

.ed {
  align-self: center;
}

.el-icon {
  top: 2px;
  height: 1rem;
}

.el-dropdown-link {
  height: 1.5rem;
}

.driver h4 {
  line-height: 30px;
  text-align: center;
}

.hh {
  height: 300px;
}

.hh2 {
  height: 280px;
}

#main2 {
  width: 610px;
  height: 280px;
  background-color: rgba(255, 255, 255, 0.852);
  float: left;
  border-radius: 5px;
  margin-top: 15px;
  margin-left: 50px;
}

.other-container {
  width: 280px;
  height: 280px;
  float: left;
  margin-top: 15px;
}

.light-container {
  width: 280px;
  height: 280px;
  float: left;
  margin-left: 50px;
  margin-top: 15px;
}

.info-bar {
  width: 85%;
  height: 50px;
  background: rgba(255, 255, 255, 0.652);
  border-radius: 5px;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  margin-top: 5px;
}

.info-bar .s1 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s2 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s3 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s4 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s5 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s6 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s7 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.info-bar .s8 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar {
  width: 85%;
  height: 50px;
  background: rgba(255, 255, 255, 0.652);
  border-radius: 5px;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  margin-top: 5px;
}

.control-bar .s1 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar .s2 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar .s3 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar .s4 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar .s5 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar .s6 {
  flex: 1;
  line-height: 50px;
  text-align: center;
}

.control-bar .s7 {
  flex: 2;
  line-height: 50px;
  text-align: center;
}
</style>

<script>
import { request } from '@/utils/request';
import { ElMessage } from 'element-plus'
import * as echarts from 'echarts/core';
import {
  TitleComponent,
  ToolboxComponent,
  TooltipComponent,
  GridComponent,
  LegendComponent
} from 'echarts/components';
import { LineChart } from 'echarts/charts';
import { UniversalTransition } from 'echarts/features';
import { CanvasRenderer } from 'echarts/renderers';
import { ArrowDown } from '@element-plus/icons-vue'
import { ElMessageBox } from 'element-plus'
echarts.use([
  TitleComponent,
  ToolboxComponent,
  UniversalTransition,
  TooltipComponent,
  GridComponent,
  LegendComponent,
  LineChart,
  CanvasRenderer
]);
export default {
  name: 'HomeView',
  components: {
    ArrowDown
  },
  data() {
    return {
      input_name: "",
      input_address: "",
      input_min: "",
      input_max: "",
      weather: {},
      myChart1: {},
      myChart2: {},
      light: "无光照",
      nowGbAddress: "192.168.100.106:80",
      nowGbName: "测试一号",
      nowMin: "10",
      nowMax: "20",
      drivers: [],
      ADDdialogVisible: false,
      option1: {
        title: {
          text: '温度监测'
        },
        color: ['#000000', '#5470C6'],
        tooltip: {
          trigger: 'none',
          axisPointer: {
            type: 'cross'
          }
        },
        legend: {},
        grid: {
          top: 70,
          bottom: 50
        },
        xAxis: [
          {
            type: 'category',
            axisTick: {
              alignWithLabel: true
            },
            axisLine: {
              onZero: false,
              lineStyle: {
                color: '#EE6666'
              }
            },
            axisPointer: {
              label: {
                formatter: function (params) {
                  return (
                    '温度传感器数值  ' +
                    params.value +
                    (params.seriesData.length ? '：' + params.seriesData[0].data : '')
                  );
                }
              }
            },
            // prettier-ignore
            data: ['18秒前', '16秒前', '14秒前', '12秒前', '10秒前', '8秒前', '6秒前', '4秒前', '2秒前', '当前']
          },
          {
            type: 'category',
            axisTick: {
              alignWithLabel: true
            },
            axisLine: {
              onZero: false,
              lineStyle: {
                color: '#5470C6'
              }
            },
            axisPointer: {
              label: {
                formatter: function (params) {
                  return (
                    '室外当前温度  ' +
                    params.value +
                    (params.seriesData.length ? '：' + params.seriesData[0].data : '')
                  );
                }
              }
            },
            // prettier-ignore
            data: ['18秒前', '16秒前', '14秒前', '12秒前', '10秒前', '8秒前', '6秒前', '4秒前', '2秒前', '当前']
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '室外当前温度',
            type: 'line',
            xAxisIndex: 1,
            smooth: true,
            emphasis: {
              focus: 'series'
            },
            data: [
              0, 0, 0, 0, 0, 0, 0, 0, 0, 0
            ]
          },
          {
            name: '温度传感器数值',
            type: 'line',
            smooth: true,
            emphasis: {
              focus: 'series'
            },
            data: [
              0, 0, 0, 0, 0, 0, 0, 0, 0, 0
            ]
          }
        ]
      },
      option2: {
        title: {
          text: '湿度监测'
        },
        xAxis: {
          type: 'category',
          data: ['12秒前', '10秒前', '8秒前', '6秒前', '4秒前', '2秒前', '当前']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [0, 0, 0, 0, 0, 0, 0],
            type: 'line',
            smooth: true
          }
        ]
      }
    }
  },
  created() {
    var that = this;
    var gbToken = this.getCookie("gbToken")
    request.get('http://192.168.100.103:8888/user/logined', {
      headers: {
        token: gbToken
      }
    })
      .then(function (response) {
        if (response.status == "ok") {
          ElMessage({
            message: '欢迎回来,' + response.username + '!',
            type: 'success',
          })
        } else {
          ElMessage({
            message: '登录状态失效!',
            type: 'warning',
          })
          window.location.href = "../"
        }
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '登录状态无效!',
          type: 'warning',
        })
        window.location.href = "../"
      });
    request.get('https://devapi.qweather.com/v7/weather/3d?location=101010100&key=f712757ea9b64a739935f4c19283ab42')
      .then(function (response) {
        if (response.code == '200') {
          that.weather = response.daily[0]
          var a = (parseInt(that.weather.tempMin) + parseInt(that.weather.tempMax)) / 2
          //console.log(a)
          that.option1.series[0].data = [a, a, a, a, a, a, a, a, a, a]
          //that.option1 && that.myChart1.setOption(that.option1);
          //console.log(that.weather)
        } else {
          ElMessage({
            message: '天气信息获取失败!',
            type: 'warning',
          })
        }
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '天气信息获取失败!',
          type: 'warning',
        })
      });
    request.get('http://192.168.100.103:8888/gb/getWendu/' + this.nowGbAddress)
      .then(function (response) {
        var a = response.Wendu
        that.option1.series[1].data = [a, a, a, a, a, a, a, a, a, a]
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '设备信息获取失败!',
          type: 'warning',
        })
      });
    setTimeout(function () {
      request.get('http://192.168.100.103:8888/gb/getShidu/' + that.nowGbAddress)
        .then(function (response) {
          var b = response.Shidu
          that.option2.series[0].data = [b, b, b, b, b, b, b]
        })
        .catch(function (error) {
          console.log(error);
          ElMessage({
            message: '设备信息获取失败!',
            type: 'warning',
          })
        });
    }, 10)//玄学问题 千万不要动这个定时器 动了就有可能炸 但是不加定时器就会炸
    /*
      ***佛祖保佑 一直好使***
////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//         佛祖保佑       永不触发BUG     永不修改                  //
////////////////////////////////////////////////////////////////////
    */
    request.get('http://192.168.100.103:8888/gb/getgbs')
      .then(function (response) {
        that.drivers = response
        //console.log(response)
        that.nowGbName = that.drivers[0].name
        that.nowGbAddress = that.drivers[0].address
        request.get('http://192.168.100.103:8888/gb/getgbareasad/' + that.nowGbAddress)
          .then(function (response) {
            that.nowMin = response[0].min
            that.nowMax = response[0].max
            that.drivers[0].min = response[0].min
            that.drivers[0].max = response[0].max
          })
          .catch(function (error) {
            console.log(error);
            ElMessage({
              message: '出水阈值获取失败!',
              type: 'warning',
            })
          });
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '设备列表获取失败!',
          type: 'warning',
        })
      });
    request.get('http://192.168.100.103:8888/gb/getLiangdu/' + that.nowGbAddress)
      .then(function (response) {
        if (response.Liangdu == "true") {
          that.light = "有光照"
        } else {
          that.light = "无光照"
        }
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '光照强度获取失败!',
          type: 'warning',
        })
      });
  },
  mounted() {
    var that = this
    setTimeout(() => {
      this.myChart1 = echarts.init(this.$refs.chart1);
      that.option1 && that.myChart1.setOption(that.option1);
      this.myChart2 = echarts.init(this.$refs.chart2);
      that.option2 && that.myChart2.setOption(that.option2);

      setInterval(function () {
        that.option1 && that.myChart1.setOption(that.option1);
        that.option2 && that.myChart2.setOption(that.option2);
      }, 1000)
      setInterval(function () {
        request.get('http://192.168.100.103:8888/gb/getWendu/' + that.nowGbAddress)
          .then(function (response) {
            var a = response.Wendu
            that.option1.series[1].data.shift()
            that.option1.series[1].data.push(a)
          })
          .catch(function (error) {
            console.log(error);
            ElMessage({
              message: '设备信息获取失败!',
              type: 'warning',
            })
          });
        setTimeout(function () {
          request.get('http://192.168.100.103:8888/gb/getShidu/' + that.nowGbAddress)
            .then(function (response) {
              var b = response.Shidu
              that.option2.series[0].data.shift();
              that.option2.series[0].data.push(b);
            })
            .catch(function (error) {
              console.log(error);
              ElMessage({
                message: '设备信息获取失败!',
                type: 'warning',
              })
            });
        }, 10)
        request.get('http://192.168.100.103:8888/gb/getLiangdu/' + that.nowGbAddress)
          .then(function (response) {
            if (response.Liangdu == "true") {
              that.light = "有光照"
            } else {
              that.light = "无光照"
            }
          })
          .catch(function (error) {
            console.log(error);
            ElMessage({
              message: '光照强度获取失败!',
              type: 'warning',
            })
          });
        let promiseList = []
        for (let i = 0; i < that.drivers.length; i++) {
          //promiseList这里要放到push数组里，原因是  如果用变量。一直就是最后一个， 或者不用push的话 ，也可以用闭包的形式来
          promiseList.push(new Promise((resolve) => {
            setTimeout(() => {
              resolve(i)//如果想要返回多个数据resolve([v,i])
            }, Math.random() * 3000);
          }));
        }
        //放到循环外边  因为 rspList是一个数组
        Promise.all(promiseList).then((rspList) => {
          rspList.map((val) => {
            //防止因异步而串台
            var a = val
            request.get('http://192.168.100.103:8888/gb/getgbareasad/' + that.drivers[val].address)
              .then(function (response) {
                //console.log(a)
                that.drivers[a].min = response[0].min,
                that.drivers[a].max = response[0].max
              })
              .catch(function (error) {
                console.log(error);
                ElMessage({
                  message: '出水阈值获取失败!',
                  type: 'warning',
                })
              });
          });
      });
    }, 2000)
    setInterval(function () {
      request.get('https://devapi.qweather.com/v7/weather/3d?location=101010100&key=f712757ea9b64a739935f4c19283ab42')
        .then(function (response) {
          if (response.code == '200') {
            that.weather = response.daily[0]
            var a = (parseInt(that.weather.tempMin) + parseInt(that.weather.tempMax)) / 2
            that.option1.series[0].data.shift()
            //console.log(that.option1.series[0].data)
            that.option1.series[0].data.push(a)
            //console.log(that.option1.series[0].data)
          } else {
            ElMessage({
              message: '天气信息获取失败!',
              type: 'warning',
            })
          }
        })
        .catch(function (error) {
          console.log(error);
          ElMessage({
            message: '天气信息获取失败!',
            type: 'warning',
          })
        });
      that.option1 && that.myChart1.setOption(that.option1);
    }, 600000)
  }, 1)
},
methods: {
  addcookie(name, value, time) {
    var strSec = this.getSec(time);
    var exp = new Date();
    exp.setTime(exp.getTime() + strSec * 1);
    //设置cookie的名称、值、失效时间
    document.cookie = name + "=" + value + ";expires=" + exp.toGMTString();
  },
  getCookie(name) {
    //获取当前所有cookie
    var strCookies = document.cookie;
    //截取变成cookie数组
    var array = strCookies.split(';');
    //循环每个cookie
    for (var i = 0; i < array.length; i++) {
      //将cookie截取成两部分
      var item = array[i].split("=");
      //判断cookie的name 是否相等
      if (item[0] == name) {
        return item[1];
      }
    }
    return null;
  },
  delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    //获取cookie是否存在
    var value = this.getCookie(name);
    if (value != null) {
      document.cookie = name + "=" + value + ";expires=" + exp.toUTCString();
    }
  },
  getSec(str) {
    var str1 = str.substr(0, str.length - 1);  //时间数值 
    var str2 = str.substr(str.length - 1, 1);    //时间单位
    if (str2 == "s") {
      return str1 * 1000;
    }
    else if (str2 == "m") {
      return str1 * 60 * 1000;
    }
    else if (str2 == "h") {
      return str1 * 60 * 60 * 1000;
    }
    else if (str2 == "d") {
      return str1 * 24 * 60 * 60 * 1000;
    }
  }, chooseDrive(id) {
    this.nowGbName = this.drivers[id].name
    this.nowGbAddress = this.drivers[id].address
  },
  handleClose(done) {
    ElMessageBox.confirm('确定要关闭窗口吗?您填写的信息将会丢失!')
      .then(() => {
        done()
      })
      .catch(() => {
        // catch error
      })
  },
  addOne() {
    this.input_name = ""
    this.input_address = ""
    this.input_min = ""
    this.input_max = ""
    this.ADDdialogVisible = true;
  },
  updateOD() {
    var that = this
    request.post('http://192.168.100.103:8888/gb/addgbs', {
      address: that.input_address,
      name: that.input_name
    })
      .then(function (response) {
        //console.log(response);
        if (response.statu == 'ok') {
          request.post('http://192.168.100.103:8888/gb/addgbareas', {
            address: that.input_address,
            min: that.input_min,
            max: that.input_max
          })
            .then(function (response) {
              //console.log(response);
              if (response.statu == 'ok') {
                ElMessage({
                  message: '添加成功!',
                  type: 'success',
                })
                request.get('http://192.168.100.103:8888/gb/getgbs')
                  .then(function (response) {
                    that.drivers = response
                  })
                  .catch(function (error) {
                    console.log(error);
                    ElMessage({
                      message: '设备列表获取失败!',
                      type: 'warning',
                    })
                  });
              } if (response.statu == 'no') {
                ElMessage({
                  message: '您输入的信息有误，添加失败!',
                  type: 'warning',
                })
              }
            })
            .catch(function (error) {
              console.log(error);
              ElMessage({
                message: '添加出水区间失败!',
                type: 'warning',
              })
            });
        } if (response.statu == 'no') {
          ElMessage({
            message: '您输入的信息有误，添加失败!',
            type: 'warning',
          })
        }
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '添加设备失败!',
          type: 'warning',
        })
      });
    this.ADDdialogVisible = false
  }
}
}
</script>