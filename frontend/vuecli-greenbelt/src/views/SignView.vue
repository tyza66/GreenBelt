<template>
    <div>
        <div class="head">
            <h1 class="title1">城市绿化带管理系统</h1>
            <a href="https://github.com/tyza66/GreenBelt" target="_blank"><svg id="github" height="32" aria-hidden="true"
                    viewBox="0 0 16 16" version="1.1" width="32" data-view-component="true"
                    class="octicon octicon-mark-github v-align-middle">
                    <path
                        d="M8 0c4.42 0 8 3.58 8 8a8.013 8.013 0 0 1-5.45 7.59c-.4.08-.55-.17-.55-.38 0-.27.01-1.13.01-2.2 0-.75-.25-1.23-.54-1.48 1.78-.2 3.65-.88 3.65-3.95 0-.88-.31-1.59-.82-2.15.08-.2.36-1.02-.08-2.12 0 0-.67-.22-2.2.82-.64-.18-1.32-.27-2-.27-.68 0-1.36.09-2 .27-1.53-1.03-2.2-.82-2.2-.82-.44 1.1-.16 1.92-.08 2.12-.51.56-.82 1.28-.82 2.15 0 3.06 1.86 3.75 3.64 3.95-.23.2-.44.55-.51 1.07-.46.21-1.61.55-2.33-.66-.15-.24-.6-.83-1.23-.82-.67.01-.27.38.01.53.34.19.73.9.82 1.13.16.45.68 1.31 2.69.94 0 .67.01 1.3.01 1.49 0 .21-.15.45-.55.38A7.995 7.995 0 0 1 0 8c0-4.42 3.58-8 8-8Z">
                    </path>
                </svg></a>
        </div>
        <div class="right1">
            <div class="form_container">
                <div class="title_container">
                    <p class="title">用户注册</p>
                    <span class="subtitle">欢迎来到注册界面!</span>
                </div>
                <br>
                <div class="input_container">
                    <label class="input_label" for="email_field">用户名</label>
                    <svg t="1683189349367" class="icon" viewBox="0 0 1024 1024" version="1.1"
                        xmlns="http://www.w3.org/2000/svg" p-id="4317" width="24" height="24">
                        <path
                            d="M832 405.344h-224a32 32 0 0 0 0 64h224a32 32 0 0 0 0-64zM832 565.344h-224a32 32 0 0 0 0 64h224a32 32 0 0 0 0-64zM404.352 635.36v-20.864c30.816-19.968 60.544-55.04 76.768-98.048 11.488-4.992 19.744-19.104 26.4-44.256 5.152-19.488-3.104-32.352-14.272-39.488C487.744 340.832 434.144 288 352 288c-83.296 0-139.456 54.368-143.776 148.672-10.112 8.352-16.608 21.76-11.552 40.864 7.2 27.232 16.096 42.88 28.352 48.864 17.312 38.656 45.664 70.016 74.624 88.384v20.576C219.04 644.032 160 672.256 160 705.728c0 40.384 384 40.384 384 0 0-33.472-59.04-61.696-139.648-70.368z"
                            p-id="4318"></path>
                        <path
                            d="M896 128H128a96 96 0 0 0-96 96v576a96 96 0 0 0 96 96h768a96 96 0 0 0 96-96V224a96 96 0 0 0-96-96z m32 672a32 32 0 0 1-32 32H128a32 32 0 0 1-32-32V224a32 32 0 0 1 32-32h768a32 32 0 0 1 32 32v576z"
                            p-id="4319"></path>
                    </svg>
                    <input placeholder="请在此输入用户名" v-model="username" title="Inpit title" name="input-yhm" type="text"
                        class="input_field" id="email_field">
                </div>
                <div class="input_container">
                    <label class="input_label" for="password_field">账号</label>
                    <svg t="1683189263171" class="icon" viewBox="0 0 1024 1024" version="1.1"
                        xmlns="http://www.w3.org/2000/svg" p-id="3135" width="24" height="24">
                        <path
                            d="M657.408 567.808c89.088-49.152 149.504-144.384 149.504-253.952 0-160.256-130.048-289.792-289.792-289.792S227.328 154.112 227.328 314.368c0 109.056 60.416 204.288 149.504 253.952-187.904 59.392-323.584 235.008-323.584 442.368h57.856c0-224.256 181.76-406.016 406.016-406.016s406.016 181.76 406.016 406.016h57.856c0-207.872-135.68-383.488-323.584-442.88zM285.184 314.368C285.184 185.856 389.12 81.92 517.12 81.92s231.936 103.936 231.936 231.936-103.936 232.448-231.936 232.448-231.936-103.936-231.936-231.936z"
                            p-id="3136"></path>
                    </svg>
                    <input placeholder="请在此输入账号" v-model="account" title="Inpit title" name="input-zh" type="text"
                        class="input_field" id="password_field">
                </div>
                <div class="input_container">
                    <label class="input_label" for="password_field">密码</label>
                    <svg fill="none" viewBox="0 0 24 24" height="24" width="24" xmlns="http://www.w3.org/2000/svg"
                        class="icon">
                        <path stroke-linecap="round" stroke-width="1.5" stroke="#141B34"
                            d="M18 11.0041C17.4166 9.91704 16.273 9.15775 14.9519 9.0993C13.477 9.03404 11.9788 9 10.329 9C8.67911 9 7.18091 9.03404 5.70604 9.0993C3.95328 9.17685 2.51295 10.4881 2.27882 12.1618C2.12602 13.2541 2 14.3734 2 15.5134C2 16.6534 2.12602 17.7727 2.27882 18.865C2.51295 20.5387 3.95328 21.8499 5.70604 21.9275C6.42013 21.9591 7.26041 21.9834 8 22">
                        </path>
                        <path stroke-linejoin="round" stroke-linecap="round" stroke-width="1.5" stroke="#141B34"
                            d="M6 9V6.5C6 4.01472 8.01472 2 10.5 2C12.9853 2 15 4.01472 15 6.5V9"></path>
                        <path fill="#141B34"
                            d="M21.2046 15.1045L20.6242 15.6956V15.6956L21.2046 15.1045ZM21.4196 16.4767C21.7461 16.7972 22.2706 16.7924 22.5911 16.466C22.9116 16.1395 22.9068 15.615 22.5804 15.2945L21.4196 16.4767ZM18.0228 15.1045L17.4424 14.5134V14.5134L18.0228 15.1045ZM18.2379 18.0387C18.5643 18.3593 19.0888 18.3545 19.4094 18.028C19.7299 17.7016 19.7251 17.1771 19.3987 16.8565L18.2379 18.0387ZM14.2603 20.7619C13.7039 21.3082 12.7957 21.3082 12.2394 20.7619L11.0786 21.9441C12.2794 23.1232 14.2202 23.1232 15.4211 21.9441L14.2603 20.7619ZM12.2394 20.7619C11.6914 20.2239 11.6914 19.358 12.2394 18.82L11.0786 17.6378C9.86927 18.8252 9.86927 20.7567 11.0786 21.9441L12.2394 20.7619ZM12.2394 18.82C12.7957 18.2737 13.7039 18.2737 14.2603 18.82L15.4211 17.6378C14.2202 16.4587 12.2794 16.4587 11.0786 17.6378L12.2394 18.82ZM14.2603 18.82C14.8082 19.358 14.8082 20.2239 14.2603 20.7619L15.4211 21.9441C16.6304 20.7567 16.6304 18.8252 15.4211 17.6378L14.2603 18.82ZM20.6242 15.6956L21.4196 16.4767L22.5804 15.2945L21.785 14.5134L20.6242 15.6956ZM15.4211 18.82L17.8078 16.4767L16.647 15.2944L14.2603 17.6377L15.4211 18.82ZM17.8078 16.4767L18.6032 15.6956L17.4424 14.5134L16.647 15.2945L17.8078 16.4767ZM16.647 16.4767L18.2379 18.0387L19.3987 16.8565L17.8078 15.2945L16.647 16.4767ZM21.785 14.5134C21.4266 14.1616 21.0998 13.8383 20.7993 13.6131C20.4791 13.3732 20.096 13.1716 19.6137 13.1716V14.8284C19.6145 14.8284 19.619 14.8273 19.6395 14.8357C19.6663 14.8466 19.7183 14.8735 19.806 14.9391C19.9969 15.0822 20.2326 15.3112 20.6242 15.6956L21.785 14.5134ZM18.6032 15.6956C18.9948 15.3112 19.2305 15.0822 19.4215 14.9391C19.5091 14.8735 19.5611 14.8466 19.5879 14.8357C19.6084 14.8273 19.6129 14.8284 19.6137 14.8284V13.1716C19.1314 13.1716 18.7483 13.3732 18.4281 13.6131C18.1276 13.8383 17.8008 14.1616 17.4424 14.5134L18.6032 15.6956Z">
                        </path>
                    </svg>
                    <input placeholder="请在此输入密码" v-model="password" title="Inpit title" name="input-mm" type="text"
                        class="input_field" id="password_field">
                </div>
                <div class="input_container">
                    <label class="input_label" for="password_field">验证码</label>
                    <svg t="1683189406108" class="icon" viewBox="0 0 1024 1024" version="1.1"
                        xmlns="http://www.w3.org/2000/svg" p-id="5475" width="24" height="24">
                        <path
                            d="M943.1 172c-2.4-0.2-245.1-25.3-413.8-147.8-5.1-3.7-11-5.6-17.3-5.6-6.2 0-12.2 1.9-17.3 5.6C326.9 146 83.3 171.8 80.9 172c-15.2 1.4-26.6 14.1-26.6 29.3 0 6.7 0.6 165.8 54.8 344.4 32.1 105.8 76.4 196.4 131.9 269.2 70.3 92.3 158.5 156 262 189.2 2.9 0.9 5.9 1.4 9 1.4s6.1-0.5 8.9-1.4c103.6-33.2 191.7-96.8 262-189.2 55.4-72.7 99.8-163.2 131.9-269.2 54.1-178.6 54.8-337.7 54.8-344.4C969.7 186.1 958.3 173.5 943.1 172zM910.1 227.2l-0.1 1.6c-2.9 58.1-13.4 174.4-51.4 299.9-66.7 220.1-183.1 360.1-346 416.1L512 945l-0.6-0.2C349 888.9 232.7 749.4 165.8 530.1c-39.8-130.5-49.4-254.2-51.8-301.4l-0.1-1.6 1.5-0.2c70.6-10.3 250.5-44.8 395.5-142.4l0.9-0.7 1 0.7C658 182.1 837.9 216.6 908.5 227L910.1 227.2z"
                            p-id="5476"></path>
                        <path
                            d="M641.8 351 467 580.3l-89-76.1c-5.3-4.5-12.1-7-19.1-7-8.6 0-16.8 3.7-22.4 10.3-10.5 12.3-9.1 31 3.3 41.5l112.7 96.4c5.2 4.4 12.4 7 19.6 7 0.9 0 1.8 0 2.7-0.1 8-0.8 15.4-5 20.3-11.4l193.7-254c4.8-6.3 6.8-14 5.7-21.8-1-7.8-5.1-14.7-11.3-19.5C670.1 335.6 651.6 338.1 641.8 351z"
                            p-id="5477"></path>
                    </svg>
                    <div class="in_container2">
                        <input placeholder="请在此输入验证码" v-model="mqcr" title="Inpit title" name="input-yzm" type="text"
                            class="input_field yzm" id="password_field"><el-image class="yzmtp" @click="reqcr()" :src="qcr"
                            :fit="fit" />
                    </div>
                </div>
                <button title="Sign In" type="submit" class="sign-in_btn" @click="sign()">
                    <span>注 册</span>
                </button>
                <p class="note">已有账号? <a href="../" target="_self">登录</a></p>
            </div>
        </div>

    </div>
</template>

<style>
.head {
    width: 100%;
    height: 55px;
    background: rgba(255, 255, 255, 0.3);
    box-shadow: 1px 1px 3px #000000;

}

.title1 {
    font-size: 25px;
    line-height: 55px;
    text-align: center;
    font-family: '宋体';
    width: 300px;
    margin-left: 30px;
}

#github {
    display: inline-block;
    position: absolute;
    right: 30px;
    top: 11.5px;
}

.right1 {
    display: block;
    width: 500px;
    margin: 0 auto;
    margin-top: 30px;
}

.form_container {
    width: fit-content;
    height: fit-content;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 15px;
    padding: 50px 40px 20px 40px;
    background-color: #ffffff;
    box-shadow: 0px 106px 42px rgba(0, 0, 0, 0.01),
        0px 59px 36px rgba(0, 0, 0, 0.05), 0px 26px 26px rgba(0, 0, 0, 0.09),
        0px 7px 15px rgba(0, 0, 0, 0.1), 0px 0px 0px rgba(0, 0, 0, 0.1);
    border-radius: 11px;
    font-family: "Inter", sans-serif;
}

.logo_container {
    box-sizing: border-box;
    width: 80px;
    height: 80px;
    background: linear-gradient(180deg, rgba(248, 248, 248, 0) 50%, #F8F8F888 100%);
    border: 1px solid #F7F7F8;
    filter: drop-shadow(0px 0.5px 0.5px #EFEFEF) drop-shadow(0px 1px 0.5px rgba(239, 239, 239, 0.5));
    border-radius: 11px;
}

.title_container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 10px;
}

.title {
    margin: 0;
    font-size: 2rem;
    font-weight: 700;
    color: #212121;
}

.subtitle {
    font-size: 0.725rem;
    max-width: 80%;
    text-align: center;
    line-height: 1.1rem;
    color: #8B8E98
}

.input_container {
    width: 100%;
    height: fit-content;
    position: relative;
    display: flex;
    flex-direction: column;
    gap: 5px;
}

.in_container2 {
    width: 100%;
    height: fit-content;
    position: relative;
    display: flex;
    flex-direction: row;
    gap: 5px;
}

.icon {
    width: 20px;
    position: absolute;
    z-index: 99;
    left: 12px;
    bottom: 9px;
}

.input_label {
    font-size: 0.75rem;
    color: #8B8E98;
    font-weight: 600;
}

.input_field {
    width: auto;
    height: 40px;
    padding: 0 0 0 40px;
    border-radius: 7px;
    outline: none;
    border: 1px solid #e5e5e5;
    filter: drop-shadow(0px 1px 0px #efefef) drop-shadow(0px 1px 0.5px rgba(239, 239, 239, 0.5));
    transition: all 0.3s cubic-bezier(0.15, 0.83, 0.66, 1);
}

.input_field:focus {
    border: 1px solid transparent;
    box-shadow: 0px 0px 0px 2px #242424;
    background-color: transparent;
}

.sign-in_btn {
    width: 100%;
    height: 40px;
    border: 0;
    background: #115DFC;
    border-radius: 7px;
    outline: none;
    color: #ffffff;
    cursor: pointer;
}

.sign-in_ggl {
    width: 100%;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    background: #ffffff;
    border-radius: 7px;
    outline: none;
    color: #242424;
    border: 1px solid #e5e5e5;
    filter: drop-shadow(0px 1px 0px #efefef) drop-shadow(0px 1px 0.5px rgba(239, 239, 239, 0.5));
    cursor: pointer;
}

.sign-in_apl {
    width: 100%;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    background: #212121;
    border-radius: 7px;
    outline: none;
    color: #ffffff;
    border: 1px solid #e5e5e5;
    filter: drop-shadow(0px 1px 0px #efefef) drop-shadow(0px 1px 0.5px rgba(239, 239, 239, 0.5));
    cursor: pointer;
}

.separator {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 30px;
    color: #8B8E98;
}

.separator .line {
    display: block;
    width: 100%;
    height: 1px;
    border: 0;
    background-color: #e8e8e8;
}

.note {
    font-size: 0.75rem;
    color: #8B8E98;
    text-decoration: underline;
}

.yzm {
    width: 390px;
    display: inline-block;
}

.yzmtp {
    display: inline-block;
    width: 120px;
    height: 40px;
}
</style>

<script>
import { request } from '@/utils/request';
import { ElMessage } from 'element-plus'

export default {
    name: 'SignView',
    data() {
        return {
            username: "",
            account: "",
            password: "",
            mqcr: "",
            qcr: "http://192.168.100.103:9090/user/qcr"
        }
    },
    created() {

    },
    methods: {
        reqcr() {
            var timestamp = new Date().getTime();
            this.qcr = "http://192.168.100.103:9090/user/qcr?t=" + timestamp
        },
        sign() {
            var that = this
            request.post('http://192.168.100.103:8888/user/sign', {
                "account": this.account,
                "id": 0,
                "nickname": this.mqcr,
                "password": this.password,
                "statu": 1,
                "username": this.username
            })
                .then(function (response) {
                    if(response.statu == "ok"){
                        ElMessage({
                            message: '注册成功!',
                            type: 'success',
                        })
                        ElMessage({
                            message: '正在跳转登录!',
                            type: 'success',
                        })
                        window.location.href = "../"
                    }
                    if(response.statu == "yzm"){
                        ElMessage({
                            message: '验证码错误!',
                            type: 'warning',
                        })
                        that.mqcr = ""
                        that.reqcr()
                    }
                    if(response.statu == "sjk"){
                        ElMessage({
                            message: '您输入的信息有误!',
                            type: 'warning',
                        })
                    }
                    if(response.statu == "have"){
                        ElMessage({
                            message: '用户已存在!',
                            type: 'warning',
                        })
                    }
                })
                .catch(function (error) {
                    console.log(error);
                    ElMessage({
                        message: '注册失败!',
                        type: 'warning',
                    })
                });
        }
    }
}
</script>