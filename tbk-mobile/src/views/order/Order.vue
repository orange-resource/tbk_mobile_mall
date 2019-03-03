<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <van-nav-bar
                    title="订单明细"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />

            <qzqt-card>
                <van-cell class="radius" title="卖家已发货" value="还剩7天20时自动确认"/>
            </qzqt-card>

            <qzqt-shipping-address-card
                    name="Orange"
                    phoneNumber="18559386053"
                    address="广东省 深圳市 龙岗区 南湾街道 深圳市龙岗区布澜路62"
            >
            </qzqt-shipping-address-card>

            <qzqt-order-card
                    logo="https://x.dscmall.cn/storage/seller_imgs/seller_logo/logo_thumb/1490159042082423990.jpg"
                    title="雅雅DIY服装辅料"
                    status="等待买家付款"
                    number="3"
                    money="2214"
            >

                <div slot="content">
                    <qzqt-goods-settlement
                            v-for="g in 1"
                            image="https://x.dscmall.cn/storage/images/201703/thumb_img/0_thumb_G_1490146354766.jpg"
                            title="中式现代实木布艺沙发组合现代转角大小户型客厅整装家具单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构"
                            sku="单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构"
                            price="13.00"
                            piece="2"
                    >
                    </qzqt-goods-settlement>
                </div>

                <div slot="btn">
                    <van-button size="small" round type="danger">退款</van-button>
                </div>

            </qzqt-order-card>

            <qzqt-card>
                <van-cell class="radius" title="运费" value="¥ 0.00" />
                <van-cell class="radius" title="优惠" value="¥ 0.00" />
                <van-cell class="radius" title="实付款" value="¥ 5.00" />
            </qzqt-card>

            <qzqt-card>
                <van-cell class="radius" title="订单编号" value="2019010922001132180547752729" />
                <van-cell class="radius" title="订单备注" value="18059511056" />
                <van-cell class="radius" title="创建时间" value="2019-01-09 11:49:03" />
                <van-cell class="radius" title="付款时间" value="2019-01-09 11:49:03" />
                <van-cell class="radius" title="发货时间" value="2019-01-09 11:49:03" />
            </qzqt-card>
            <br>

        </div>

    </div>

</template>

<script>
    export default {
        name: "Order",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'orderList',
                })
            },
        }
    }
</script>

<style scoped>

</style>
