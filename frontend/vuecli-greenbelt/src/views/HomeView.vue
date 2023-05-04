<template>
  <div class="main">

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
    request.get('http://192.168.100.103:8888/user/logined')
      .then(function (response) {
        console.log(response)
        if(response.statu == "-1"){
          ElMessage({
          message: '登录状态无效!',
          type: 'warning',
        })
        //window.location.href = "../"
        }else if(response.statu == "1"){
          ElMessage({
          message: '用户认证成功!',
          type: 'success',
        })
        }else{
          ElMessage({
          message: '用户权限不足!',
          type: 'warning',
        })
        //window.location.href = "../"
        }
      })
      .catch(function (error) {
        console.log(error);
        ElMessage({
          message: '主页加载错误!',
          type: 'warning',
        })
        //window.location.href = "../"
      });
  },
  methods: {
    login() {

    }
  }
}
</script>