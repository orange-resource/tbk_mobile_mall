<template>

    <div style="display: flex;flex-direction: column">

        <!--头部-->
        <van-nav-bar
                title="雅雅DIY服装辅料"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--内容-->
        <div style="flex: auto;padding-bottom: 50px">

            <div style="height: 150px;background-color: red;position: relative">

                <img src="https://x.dscmall.cn/storage/data/store_street/street_thumb/1490160857982584904.jpg"
                width="100%" height="100%">

                <div style="position: absolute;top:50%;left:50%;margin-left: -35px;margin-top: -35px">
                    <img src="https://x.dscmall.cn/storage/images/seller_imgs/seller_logo/logo_thumb/1536872208964241423.jpg"
                         style="border-radius: 50%;background-color: #fff;height: 70px;width:70px;">
                </div>

                <van-row type="flex" justify="center"
                         style="height: 30px;align-items: center;position: absolute;bottom: 5px;width: 100%">
                    <van-col span="15">
                        <span style="color: #fff;font-weight: 700">雅雅DIY服装辅料</span>
                    </van-col>
                    <van-col span="7" style="text-align: right">
                        <span style="color: #fff;font-weight: 700">粉丝 1000000</span>
                    </van-col>
                </van-row>

            </div>


            <van-tabs>
                <van-tab title="全部商品">
                    <qzqt-goods-sell
                            v-for="g in 5"
                    image="https://x.dscmall.cn/storage/images/201809/goods_img/0_P_1536614291769.jpg"
                    title="CASIO卡西欧35周年限量G-SHOCK × A$AP FERG联名款GA-110FRG-7A"
                    price="13"
                    logistics="11"
                    payment="13"
                    address="泉州"
                    ></qzqt-goods-sell>
                </van-tab>
                <van-tab title="新品">
                    <qzqt-goods-sell
                            image="https://x.dscmall.cn/storage/images/201809/goods_img/0_P_1536614291769.jpg"
                            title="CASIO卡西欧35周年限量G-SHOCK × A$AP FERG联名款GA-110FRG-7A"
                            price="166"
                            originalPrice="2999"
                            logistics="11"
                            payment="13"
                            address="泉州"
                            tag="新品"
                    ></qzqt-goods-sell>
                </van-tab>
                <van-tab title="促销">
                    <qzqt-goods-sell
                            image="https://x.dscmall.cn/storage/images/201809/goods_img/0_P_1536614291769.jpg"
                            title="CASIO卡西欧35周年限量G-SHOCK × A$AP FERG联名款GA-110FRG-7A"
                            price="13"
                            originalPrice="299"
                            logistics="11"
                            payment="13"
                            address="泉州"
                            tag="促销"
                    ></qzqt-goods-sell>
                </van-tab>
            </van-tabs>

        </div>
        <!--内容 end-->

        <!--尾部-->
        <div class="footer">
            <van-row type="flex">
                <van-col span="6" style="border: 1px solid #e3e8ee;height: 50px;background-color: #fff">
                    <div @click="openDetails()"
                            style="display: flex;height:50px;flex-direction: column;align-items: center;justify-content: center">
                        <van-icon name="wap-home" style="color: darkgray;font-size: 13px" />
                        <span style="color: darkgray;font-size: 13px">店铺详情</span>
                    </div>
                </van-col>
                <van-col span="6" style="border: 1px solid #e3e8ee;height: 50px;background-color: #fff">
                    <div style="display: flex;height:50px;flex-direction: column;align-items: center;justify-content: center">
                        <van-icon name="bars" style="color: darkgray;font-size: 13px" />
                        <span style="color: darkgray;font-size: 13px">热门分类</span>
                    </div>
                </van-col>
                <van-col span="6" style="border: 1px solid #e3e8ee;height: 50px;background-color: #fff">
                    <div style="display: flex;height:50px;flex-direction: column;align-items: center;justify-content: center">
                        <van-icon name="service-o" style="color: darkgray;font-size: 13px" />
                        <span style="color: darkgray;font-size: 13px">客服</span>
                    </div>
                </van-col>
                <van-col span="6" style="border: 1px solid #e3e8ee;height: 50px;background-color: #f92028">
                    <div style="display: flex;height:50px;flex-direction: column;align-items: center;justify-content: center">
                        <van-icon name="like-o" style="color: #fff;font-size: 13px" />
                        <span style="color: #fff;font-size: 13px">关注</span>
                    </div>
                </van-col>
            </van-row>
        </div>
        <!--尾部 end-->

    </div>

</template>

<script>
    export default {
        name: "Shop",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'my',
                })
            },
            openDetails() {
                this.$router.push({
                    name: "shopDetails",
                })
            },
        }
    }
</script>

<style scoped>

    .footer{
        height: 50px;
        width: 100%;
        position:fixed;
        bottom:0px;
        left:0px;
    }

</style>
