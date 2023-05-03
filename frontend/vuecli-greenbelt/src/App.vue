<template>
  <el-config-provider :locale="locale">

  </el-config-provider>
</template>

<style>
</style>

<script>
import { ElConfigProvider } from 'element-plus'
import zhCn from 'element-plus/lib/locale/lang/zh-cn'
export default {
  name: "VueLayout",
  components: {
    [ElConfigProvider.name]: ElConfigProvider
  },
  data(){
    return {
      locale: zhCn
    }
  }
}
</script>