<template>

    <div>

        <van-row type="flex" justify="center">
            <van-col span="22" style="display: flex;justify-content: center;align-items: center;margin: 20px 0 20px 0">
                <img src="../../static/img/404.png" style="height: 200px" />
            </van-col>
        </van-row>
        <van-row type="flex" justify="center">
            <van-col span="22" style="display: flex;justify-content: center;align-items: center;margin: 20px 0 20px 0">
                <span>哎呀，404啦！你地址搜索的有误了啦！</span>
            </van-col>
        </van-row>
        <van-row type="flex" justify="center">
            <van-col span="22" style="display: flex;justify-content: center;align-items: center;margin: 20px 0 20px 0">
                <van-button plain type="primary" size="large" @click="openHome()">飞往首页</van-button>
            </van-col>
        </van-row>

        <orange-technology-footer></orange-technology-footer>

    </div>

</template>

<script>
    export default {
        name: "404",
        methods: {
            openHome() {
                this.$router.push({ path: "/" });
            },
        },
    }
</script>

<style scoped>

</style>
