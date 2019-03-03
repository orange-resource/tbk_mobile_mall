<template>

    <div class="bc" style="height: 100%">

        <div class="bc qzqt-home">

            <div class="qzqt-content">
                <!--头部-->
                <van-nav-bar
                        title="购物车结算"
                        left-text="返回"
                        left-arrow
                        @click-left="onClickLeft"
                />
                <!--头部 end-->

                <qzqt-shipping-address-card
                        name="Orange"
                        phoneNumber="18559386053"
                        address="广东省 深圳市 龙岗区 南湾街道 深圳市龙岗区布澜路62"
                >
                </qzqt-shipping-address-card>

                <qzqt-order-card
                        v-for="t in 1"
                        logo="https://x.dscmall.cn/storage/seller_imgs/seller_logo/logo_thumb/1490159042082423990.jpg"
                        title="雅雅DIY服装辅料"
                        status=""
                        number="1"
                        money="2214"
                        to="/order/main"
                >

                    <div slot="content">
                        <qzqt-goods-settlement
                                v-for="g in 2"
                                image="https://x.dscmall.cn/storage/images/201703/thumb_img/0_thumb_G_1490146354766.jpg"
                                title="中式现代实木布艺沙发组合现代转角大小户型客厅整装家具单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构"
                                sku="单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构"
                                price="13.00"
                                piece="2"
                        >
                        </qzqt-goods-settlement>
                    </div>

                    <div slot="footer">
                        <van-cell title="配送方式" value="顺丰 ¥10.00" />
                        <van-cell-group>
                            <van-field
                                    v-model="message"
                                    label="买家留言"
                                    type="textarea"
                                    placeholder="请输入留言"
                                    rows="1"
                                    autosize
                            />
                        </van-cell-group>
                    </div>

                </qzqt-order-card>

                <qzqt-card>
                    <van-cell class="radius" title="支付方式" value="在线支付" />
                    <van-cell class="radius" title="发票信息" value="个人" />
                    <van-cell class="radius" title="优惠卷" value="不使用优惠卷" />
                </qzqt-card>

                <qzqt-card>
                    <van-cell class="radius" title="总计金额" value="¥ 1110" size="large" />
                </qzqt-card>
            </div>

            <div class="qzqt-footer">
                <van-submit-bar
                        :price="3050"
                        button-text="结算"
                        @submit="onSubmit"
                />
            </div>

        </div>

    </div>

</template>

<script>
    export default {
        name: "Settlement",
        data() {
            return {
                message: '',
            }
        },
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'cart',
                })
            },
            onSubmit() {

            },
        }
    }
</script>

<style scoped>

</style>
