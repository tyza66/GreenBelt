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
                          <el-dropdown-item>测试一号</el-dropdown-item>
                        </el-dropdown-menu>
                      </template>
                    </el-dropdown>
                  </div>
                </el-card>
              </div>
              <div id="main1" ref="chart1">
              </div>
              <div id="main2" ref="chart2">
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="设备信息">
            <div class="sbxx">

            </div>
          </el-tab-pane>
          <el-tab-pane label="设备管理">
            <div class="sbgl">

            </div>
          </el-tab-pane>
          <el-tab-pane label="关于">
            <div class="gy">

            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
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
  width: 80%;
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
  width: 500px;
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
  ;
}

#main2 {
  width: 500px;
  height: 280px;
  background-color: rgba(255, 255, 255, 0.852);
  float: left;
  margin-left: 50px;
  border-radius: 5px;
  margin-top: 15px;
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
      weather: {},
      myChart1: {},
      myChart2: {},
      nowGbAddress: "192.168.100.106:80",
      nowGbName: "测试一号",
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
    }
  }
}
</script>