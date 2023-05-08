<template>
	<view>
		<view class="top"></view>
		<view>
			<h2>地址：{{address}}</h2>
			<h2>温度：{{wd}}</h2>
			<h2>湿度：{{sd}}</h2>
			<h2>光照：{{ld}}</h2>
			<h2>水泵：{{wt}}</h2>
			<button class="button" type="primary" @click="ow()">开启水泵</button>
			<button class="button" type="primary" @click="cw()">关闭水泵</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				address: "192.168.100.106:80",
				wd: '0',
				sd: '0',
				ld: '0',
				wt: '关闭'
			}
		},onLoad(option) {
			this.address = option.address
		},
		created() {
			var that = this
			setInterval(function() {
				uni.request({
					url: "http://" + that.address + '/wd',
					method: 'GET',
					success: (res) => {
						//console.log(res.data);
						that.wd = res.data
					},
					fail: (res) => {
						console.log(res.data);
					}
				});
				uni.request({
					url: "http://" + that.address + '/sd',
					method: 'GET',
					success: (res) => {
						//console.log(res.data);
						that.sd = res.data
					},
					fail: (res) => {
						console.log(res.data);
					}
				});
				uni.request({
					url: "http://" + that.address + '/ld',
					method: 'GET',
					success: (res) => {
						//console.log(res.data);
						that.ld = res.data
					},
					fail: (res) => {
						console.log(res.data);
					}
				});
			}, 2000)
			uni.request({
				url: "http://" + this.address + '/wc',
				method: 'GET',
				success: (res) => {
					//console.log(res.data);
				},
				fail: (res) => {
					console.log(res.data);
				}
			});
		},
		methods: {
			ow(){
				var that = this
				uni.request({
					url: "http://" + this.address + '/wo',
					method: 'GET',
					success: (res) => {
						//console.log(res.data);
					},
					fail: (res) => {
						console.log(res.data);
					}
				});
				that.wt = "开启"
			},cw(){
				var that = this
				uni.request({
					url: "http://" + this.address + '/wc',
					method: 'GET',
					success: (res) => {
						//console.log(res.data);
					},
					fail: (res) => {
						console.log(res.data);
					}
				});
				that.wt = "关闭"
			}
			
		}
	}
</script>

<style>
	.top {
		height: var(--status-bar-height);
		width: 100%;
		background-color: #FFFFFF;
	}
</style>