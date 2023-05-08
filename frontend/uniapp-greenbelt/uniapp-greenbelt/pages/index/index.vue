<template>
	<view>
		<view class="top"></view>
		<view>
			<form action="" class="form">
				<div class="Group">
					<label for="Password">设备地址</label>
					<input id="Password" type="text">
				</div>
				<div class="Group">
					<button class="btn">登录</button>
				</div>
			</form>
			<h3>Green Belt</h3>
			<h5>基于大数据和物联网的可视化城市绿化带自动灌溉系统</h5>
			<h4>开源地址：https://github.com/tyza66/GreenBelt</h4>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {

		},
		methods: {}
	}
</script>

<style>
	.top {
		height: var(--status-bar-height);
		width: 100%;
		background-color: #FFFFFF;
	}

	.form {
		display: flex;
		flex-direction: column;
		width: 700rpx;
		height: 280px;
		background-color: #FFF;
		margin: 0;
		/*box-shadow: -1px 0px 25px 0px #21719369;*/
		padding: 2.25em;
		box-sizing: border-box;
		/*border: solid 1px #DDD;
	  border-radius: 0.5em;*/
		font-family: sans-serif;
		font-size: 16px;
		font-weight: 400;
		margin: 0 auto;
		margin-top: 100rpx;
	}

	.form .Group {
		margin-bottom: 2em;
	}

	.form label {
		margin: 0 0 10px;
		display: block;
		font-size: 1.25em;
		color: #217093;
		font-weight: 600;
		font-family: inherit;
	}

	.form input {
		padding: 0.3em 0.5em 0.4em;
		background-color: #f3fafd;
		border: solid 2px #217093;
		border-radius: 4px;
		box-sizing: border-box;
		width: 100%;
		height: 50px;
		font-size: 1.3em;
		color: #353538;
		font-weight: 600;
		font-family: inherit;
		transition: box-shadow 0.2s linear, border-color 0.25s ease-out;
	}

	.form input:focus {
		outline: none;
		box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
		background-color: #edf8fc;
		border: solid 2px #4eb8dd;
	}

	.form input::placeholder {
		color: #21719383;
	}

	.form .btn {
		margin: 0;
		padding: 0.5em;
		background-color: #4eb8dd;
		border: none;
		border-radius: 4px;
		box-sizing: border-box;
		box-shadow: none;
		width: 100%;
		height: 80px;
		font-size: 1.4em;
		color: #FFF;
		font-weight: 600;
		font-family: inherit;
		transition: transforme 0.1s ease-in-out, background-color 0.2s ease-out;
	}

	.form .btn:hover {
		cursor: pointer;
		background-color: #217093;
	}

	.form .btn:active {
		transform: scale(0.98);
	}
	h3,h4,h5{
		text-align: center;
	}
</style>