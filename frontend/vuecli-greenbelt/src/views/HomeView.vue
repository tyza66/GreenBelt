<template>
  <div class="main2">

  </div>
</template>

<style></style>

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
            message: '欢迎回来,'+response.username +'!',
            type: 'success',
          })
        }else{
          ElMessage({
            message: '登录状态失效!',
            type: 'success',
          })
          window.location.href = "../"
        }
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
            message: '登录状态无效!',
            type: 'success',
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