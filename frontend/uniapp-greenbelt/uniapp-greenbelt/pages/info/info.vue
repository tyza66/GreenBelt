<template>
	<view>
		<view class="top"></view>
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