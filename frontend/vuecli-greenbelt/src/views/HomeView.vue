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
          <el-tab-pane label="首页">User</el-tab-pane>
          <el-tab-pane label="设备信息">Config</el-tab-pane>
          <el-tab-pane label="设备管理">Role</el-tab-pane>
          <el-tab-pane label="关于">Task</el-tab-pane>
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
.bar{
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
</style>

<script>
import { request } from '@/utils/request';
import { ElMessage } from 'element-plus'

export default {
  name: 'HomeView',
  data() {
    return {

    }
  },
  created() {
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