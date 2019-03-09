<template>

    <div style="background-color: #fff;height: 100%">

        <div style="background-color: #fff">

            <!--头部-->
            <van-nav-bar
                    title="阅读"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <van-row type="flex" justify="center" style="padding-top: 20px;padding-bottom: 5px">
                <van-col span="22">
                    <span style="font-weight: 600;font-size: 20px">资金管理</span>
                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" style="display: flex;flex-direction: row">
                    <div>
                        <van-icon style="color: darkgray;font-size: 13px" name="underway-o" />
                        <span style="color: darkgray;font-size: 13px;margin-left: 3px">2018.1.7</span>
                    </div>
                    <div style="margin-left: 10px">
                        <van-icon style="color: darkgray;font-size: 13px" name="eye-o" />
                        <span style="color: darkgray;font-size: 13px;margin-left: 3px">22</span>
                    </div>
                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" v-html="content" style="padding-top: 10px;margin-bottom: 20px">

                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" style="text-align: center;padding-bottom: 20px">
                    <span style="color: darkgray;font-size: 13px;">泉州创为科技</span>
                </van-col>
            </van-row>

        </div>

    </div>

</template>

<script>
    export default {
        name: "Article",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'articleList',
                })
            },
        },
        data() {
            return {
                content: '全球领先的电子产品及第二大移动通信终端制造商三星电子今天在北京宣布，为全面支持中国开展3G' +
                    '移动通信业务，将在3G服务正式商用之际，向中国市场推出 15款3G手机。这些产品分别支持中国三大无线运营商' +
                    '的各种3G服务，并已经得到运营商的合作认可。凭借在电子和通信领域的整体技术实力和对消费者的准确 把握，' +
                    '三星电子已经开始全面发力中国的3G移动通信市场。' + '<br><br><br>'+'全球领先的电子产品及第二大移动通信终端制造商三星电子今天在北京宣布，为全面支持中国开展3G' +
                    '移动通信业务，将在3G服务正式商用之际，向中国市场推出 15款3G手机。这些产品分别支持中国三大无线运营商' +
                    '的各种3G服务，并已经得到运营商的合作认可。凭借在电子和通信领域的整体技术实力和对消费者的准确 把握，' +
                    '三星电子已经开始全面发力中国的3G移动通信市场。' +'全球领先的电子产品及第二大移动通信终端制造商三星电子今天在北京宣布，为全面支持中国开展3G' +
                    '移动通信业务，将在3G服务正式商用之际，向中国市场推出 15款3G手机。这些产品分别支持中国三大无线运营商' +
                    '的各种3G服务，并已经得到运营商的合作认可。凭借在电子和通信领域的整体技术实力和对消费者的准确 把握，' +
                    '三星电子已经开始全面发力中国的3G移动通信市场。'+'全球领先的电子产品及第二大移动通信终端制造商三星电子今天在北京宣布，为全面支持中国开展3G' +
                    '移动通信业务，将在3G服务正式商用之际，向中国市场推出 15款3G手机。这些产品分别支持中国三大无线运营商' +
                    '的各种3G服务，并已经得到运营商的合作认可。凭借在电子和通信领域的整体技术实力和对消费者的准确 把握，' +
                    '三星电子已经开始全面发力中国的3G移动通信市场。'  ,

            }
        },
    }
</script>

<style scoped>


</style>
