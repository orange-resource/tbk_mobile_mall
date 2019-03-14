<template>

    <!--订单卡片-->

    <div class="radius" style="margin: 10px 10px 10px 10px;background-color: #fff;">

        <van-row type="flex" justify="center" style="padding-top: 10px;">
            <van-col span="11" style="display: flex;flex-direction: row;align-items: center">
                <img :src="logo"
                     width="15px" height="15px" style="border-radius: 50%" >
                <span style="font-size: 12px;color: rgb(51, 51, 51);font-weight: 600;margin-left: 5px">
                    {{ title }}
                </span>
            </van-col>
            <van-col span="11" style="text-align: right">
                <span style="font-size: 12px;color: rgb(255, 80, 0);font-weight: 600;" @click="open(to)">
                    {{ status }}
                </span>
            </van-col>
        </van-row>

        <van-row type="flex" justify="center">
            <van-col span="22">
                <slot name="content"></slot>
            </van-col>
        </van-row>

        <van-row type="flex" justify="center">
            <van-col span="22" style="text-align: right">
                <span style="font-size: 12px;color: darkgrey;font-weight: 600;margin-left: 5px">
                    共{{ number }}件商品
                </span>
                <span style="font-size: 12px;color: rgb(51, 51, 51);font-weight: 600;margin-left: 5px">
                    合计：¥ {{ money }}
                </span>
            </van-col>
        </van-row>

        <van-row type="flex" justify="center">
            <van-col span="24">
                <hr class="hr">
            </van-col>
        </van-row>

        <van-row type="flex" justify="center" style="padding-bottom: 10px;">
            <van-col span="22">
                <slot name="footer"></slot>
            </van-col>
        </van-row>

        <van-row type="flex" justify="center" style="padding-bottom: 10px;">
            <van-col span="22" style="display: flex;flex-direction: row;justify-content: flex-end;">
                <slot name="btn"></slot>
            </van-col>
        </van-row>

    </div>

</template>

<script>
    export default {
        name: "orange-order-card",
        props: ["logo","title","status","number","money","to"],
        methods: {
            open(to) {
                this.$router.push({ path: to });
            },
        },
    }
</script>

<style scoped>
</style>
