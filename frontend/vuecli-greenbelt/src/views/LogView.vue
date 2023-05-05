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
                </svg></a>
        </div>
        <div class="left">
            <marquee loop=1 behavior=slide scrollamount="18">
                <font id="word1">绿色城建</font>
            </marquee>
            <marquee loop=1 behavior=slide direction="right" scrollamount="18">
                <font id="word2">低碳生活</font>
            </marquee>
            <marquee loop=1 behavior=slide scrollamount="18">
                <font id="word3">数字灌溉</font>
            </marquee>
            <marquee loop=1 behavior=slide direction="right" scrollamount="18">
                <font id="word4">全民共享</font>
            </marquee>
        </div>
        <div class="right">
            <div class="form">
                <p class="form-title">用户登录</p>
                <div class="input-container">
                    <input placeholder="在此输入账号" type="text" v-model="username">
                    <span>
                        <svg t="1683165208167" class="icon" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="1487" width="200" height="200">
                            <path
                                d="M909 921.7c-0.8-17.1-2.5-34.1-5.4-51.2-5.8-34.5-16.2-67.4-31.2-99-26.2-55.3-62.8-101.9-110.7-139.8-37.5-29.9-79.1-52.4-124.8-67.4-2.9-0.8-5.8-2.1-8.7-2.9 0.8-0.4 1.3-0.8 1.7-0.8 20.4-10 39.5-22.5 56.6-37.5 25-21.6 45.4-47.4 60.7-77 21.6-41.6 31.2-85.7 29.1-132.7-0.8-14.1-2.5-28.3-5.4-42-10.4-47.9-32.9-89.5-66.6-125.2-14.6-15.4-31.2-29.1-49.1-40.4-38.7-24.5-80.7-38.3-126.1-41.2-12.5-0.8-25.4-0.8-37.9 0.4-14.1 1.3-28.3 3.3-42 6.7-45.8 11.2-86.1 32.9-120.7 65.3-22.5 21.2-40.8 45.3-54.5 72.8-20.4 40.8-29.5 83.6-27.5 129 0.4 12.5 2.1 25 4.6 37 9.6 48.3 30.8 90.3 64.1 126.5 22 24.1 48.3 43.7 77.4 58.2 0.4 0.4 1.3 0.4 1.7 1.3-9.2 2.9-18.7 5.8-27.4 9.6-9.2 3.8-18.3 7.5-27 11.7-50.4 24.1-93.7 57-130.3 99-19.6 22.5-36.2 47-50.3 73.2-17.5 32.5-29.5 67-37 103.2-3.3 15.8-5.8 32-6.7 47.9-0.4 6.3-0.8 12.5-1.3 18.3 0 5.8-0.8 11.2 0.4 17.1 2.1 10.8 12.5 18.3 23.7 17.5 10.8-0.8 19.6-10 20-20.8 0.4-7.1 0.4-14.6 0.8-21.6 0.4-10.8 1.7-21.2 3.3-32 3.3-21.2 8.3-42.5 15.8-62.8 16.6-47 42-88.2 76.6-124 22.9-23.7 48.3-44.1 77-60.7 24.5-14.6 50.4-25.8 77.4-33.7 19.1-5.8 38.7-10 58.7-12.5 12.9-1.7 25.8-2.5 38.7-2.5 0.8 0 1.7-0.4 2.5 0h7.5c0.4 0 1.3 0 1.7 0.4 4.6 0 9.2 0 13.7 0.4 15 0.8 30.4 2.5 45.4 5.4 31.2 5.8 61.2 15.4 89.5 29.1 46.6 22.5 86.5 53.7 119.8 93.6 28.7 35 49.9 73.7 63.7 116.9 7.1 22.5 11.7 45.4 14.2 69.1 1.3 11.7 1.7 23.3 1.7 35 0.4 12.1 10 21.6 22.5 21.6 12.1 0 21.6-10 21.6-21.6-1.5-6.9-1.5-11.9-1.5-16.9zM550.8 540.1c-12.5 2.1-25 3.3-37.5 3.8h-10.4c-8.7 0.4-16.2-1.3-24.5-2.5-23.3-3.3-45.4-10.4-66.6-21.2-9.2-4.6-17.9-9.6-26.2-15.4-19.1-13.3-36.2-29.1-50.3-47.9-15.4-20-26.6-42-34.1-66.2-5.8-18.3-8.8-36.6-10-55.8-0.4-12.5 0-25.4 1.7-37.9 3.8-26.6 11.7-51.6 25-74.9 12.9-23.3 29.5-44.1 50.3-61.2 17.9-15.4 37.9-27.5 59.9-36.2 23.3-9.6 47.4-14.6 72.4-15.8 9.6-0.4 19.1-0.4 28.7 0.4 10.4 0.8 20.8 2.5 30.8 4.6 22.5 5 43.7 13.3 63.7 25 17.9 10.4 33.7 22.9 48.3 38.3 8.3 9.2 16.2 18.3 23.3 28.7 12.1 17.9 21.6 37.5 27.9 58.2 5.4 17.9 8.3 35.8 9.2 54.5 0.4 8.7 0 17.9-0.8 26.6-0.8 11.2-2.9 22.5-5.4 33.3-5 19.6-12.1 38.3-22.5 55.8-12.9 22-28.7 41.6-48.3 57.8-14.6 12.5-30.8 22.9-48.3 31.2-18.5 7.3-37.2 13.5-56.3 16.8z"
                                p-id="1488"></path>
                        </svg>
                    </span>
                </div>
                <div class="input-container">
                    <input placeholder="在此输入密码" type="password" v-model="password">
                    <span>
                        <svg t="1683165242473" class="icon" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="2470" width="200" height="200">
                            <path
                                d="M807.936 336.384h-12.288c-5.12-66.56-33.792-128.512-81.92-176.64C659.968 106.496 589.312 76.8 514.56 76.8c-147.968 0-269.312 114.688-280.576 259.072h-12.288c-78.848 0-143.36 64.512-143.36 143.36v327.168c0 78.848 64.512 143.36 143.36 143.36h586.24c78.848 0 143.36-64.512 143.36-143.36V479.744c0-79.36-64.512-143.36-143.36-143.36zM514.56 158.72c53.248 0 102.912 20.992 140.8 58.88 32.768 32.768 52.736 74.24 57.344 118.784H315.904C327.168 236.544 412.16 158.72 514.56 158.72z m354.816 647.68c0 33.792-27.648 61.44-61.44 61.44H221.696c-33.792 0-61.44-27.648-61.44-61.44V479.744c0-33.792 27.648-61.44 61.44-61.44h586.752c33.792 0 61.44 27.648 61.44 61.44v326.656z"
                                fill="#333333" p-id="2471"></path>
                            <path
                                d="M514.56 507.904c-22.528 0-40.96 18.432-40.96 40.96v158.72c0 22.528 18.432 40.96 40.96 40.96s40.96-18.432 40.96-40.96v-158.72c0-22.528-18.432-40.96-40.96-40.96z"
                                fill="#333333" p-id="2472"></path>
                        </svg>
                    </span>
                </div>
                <button class="submit" @click="login()">
                    登录
                </button>

                <p class="signup-link">
                    没有账号?
                    <a href="./sign" target="_self">注册</a>
                </p>
            </div>

        </div>
    </div>
</template>

<style>
.main {
    background-image: url(../assets/images/glass.jpg);
    background-repeat: no-repeat;
    background-size: 100% 100%;
    height: 100vh;
}

.head {
    width: 100%;
    height: 55px;
    background: rgba(255, 255, 255, 0.3);
    box-shadow: 1px 1px 3px #000000;

}

/*
@font-face {
    font-family: 汉仪金陵美宋;
    src: url(../assets/fonts/汉仪金陵美宋.ttf);
}
*/
.title {
    font-size: 30px;
    line-height: 55px;
    text-align: center;
    font-family: '宋体';
    width: 500px;
    margin: 0 auto;
    letter-spacing: 0.5rem;
}

#github {
    display: inline-block;
    position: absolute;
    right: 30px;
    top: 11.5px;
}

.form {
    background-color: #fff;
    display: block;
    padding: 1rem;
    max-width: 350px;
    border-radius: 0.5rem;
    box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
}

.form-title {
    font-size: 1.25rem;
    line-height: 1.75rem;
    font-weight: 600;
    text-align: center;
    color: #000;
}

.input-container {
    position: relative;
}

.input-container input,
.form button {
    outline: none;
    border: 1px solid #e5e7eb;
    margin: 8px 0;
}

.input-container input {
    background-color: #fff;
    padding: 1rem;
    padding-right: 3rem;
    font-size: 0.875rem;
    line-height: 1.25rem;
    width: 300px;
    border-radius: 0.5rem;
    box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
}

.input-container span {
    display: grid;
    position: absolute;
    top: 0;
    bottom: 0;
    right: 0;
    padding-left: 1rem;
    padding-right: 1rem;
    place-content: center;
}

.input-container span svg {
    color: #9CA3AF;
    width: 1rem;
    height: 1rem;
}

.submit {
    display: block;
    padding-top: 0.75rem;
    padding-bottom: 0.75rem;
    padding-left: 1.25rem;
    padding-right: 1.25rem;
    background-color: #4F46E5;
    color: #ffffff;
    font-size: 0.875rem;
    line-height: 1.25rem;
    font-weight: 500;
    width: 100%;
    border-radius: 0.5rem;
    text-transform: uppercase;
    cursor: pointer;
}

.signup-link {
    color: #6B7280;
    font-size: 0.875rem;
    line-height: 1.25rem;
    text-align: center;
}

.signup-link a {
    text-decoration: underline;
}

.right {
    position: absolute;
    right: 10%;
    top: 30%;
}

.left {
    position: absolute;
    width: 450px;
    left: 15%;
    top: 25%;
}

#word1 {
    font-size: 55px;
    color: #58545471;
    text-shadow: 5px 5px rgba(0, 0, 0, 0.05);
}

#word2 {
    font-size: 50px;
    color: #3c3a3ac8;
    text-shadow: 5px 5px rgba(0, 0, 0, 0.05);
}

#word3 {
    font-size: 60px;
    color: #4f4d4d9e;
    text-shadow: 5px 5px rgba(0, 0, 0, 0.05);
}

#word4 {
    font-size: 85px;
    color: #cacacabb;
    text-shadow: 5px 5px rgba(0, 0, 0, 0.05);
}
</style>

<script>
import { request } from '@/utils/request';
import { ElMessage } from 'element-plus'

export default {
    name: 'LogView',
    data() {
        return {
            username: "",
            password: ""
        }
    },
    created() {
        request.get('http://192.168.100.103:8888/user/logined')
            .then(function (response) {
                if (response.status == "ok") {
                    ElMessage({
                        message: '已登录,正在跳转!',
                        type: 'success',
                    })
                    window.location.href = "./home"
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    },
    methods: {
        login() {
            request.post('http://192.168.100.103:8888/userl/login', {
                account: this.username,
                password: this.password
            })
                .then(function (response) {
                    console.log(response)
                    if (response.statu == "true") {
                        ElMessage({
                            message: '登陆成功!',
                            type: 'success',
                        })
                        window.location.href = "./home"
                    } else {
                        ElMessage({
                            message: '登录失败,用户名或密码错误!',
                            type: 'warning',
                        })
                    }
                })
                .catch(function (error) {
                    console.log(error);
                    ElMessage({
                        message: '登录错误.',
                        type: 'warning',
                    })
                });

        }
    }
}
</script>