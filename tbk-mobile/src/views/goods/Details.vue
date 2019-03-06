<template>

    <div class="bc" style="height: 100%">

        <div class="orange-home bc">

            <div v-if="isPageLoadComplete == 0 || isPageLoadComplete == 1" class="orange-content">
                <van-nav-bar
                        title="商品详情 加载中..."
                        left-text="返回"
                        right-text="首页"
                        left-arrow
                        @click-left="onClickLeft"
                        @click-right="onClickRight"
                />
                <orange-loading :show="isPageLoadComplete"></orange-loading>
            </div>

            <div v-if="isPageLoadComplete == 2" class="orange-content">

                <!--头部-->
                <van-nav-bar title="商品详情"
                             left-text="返回"
                             right-text="首页"
                             left-arrow
                             @click-left="onClickLeft"
                             @click-right="onClickRight"
                ></van-nav-bar>

                <!--图片展示-->
                <van-swipe style="background-color: #fff">
                    <van-swipe-item>
                        <img :src="details.itempic"
                             width="100%" height="375px"/>
                    </van-swipe-item>
                </van-swipe>

                <!--商品标题区-->
                <div style="padding: .5em 1em 0 1em;background-color: #fff">
                    <div>
                        <span style="color: red;font-size: 20px;font-weight: 600">
                            ¥{{ details.itemendprice }}
                        </span>
                        <span style="color: #999999">
                            (卷后价格)
                        </span>
                    </div>
                </div>
                <div style="padding: 0 5em 0 1em;background-color: #fff;position: relative">
                    <span style="font-weight: 600">
                        {{ details.itemtitle }}
                    </span>
                    <div style="position: absolute;right: 0;bottom: .5em">
                        <van-button @click="openShare()" type="danger" size="small">分享</van-button>
                    </div>
                </div>
                <van-row type="flex" style="background-color: #fff;padding: 10px 0 10px 0">
                    <van-col span="1"></van-col>
                    <van-col span="7">
                        <span style="color: darkgray;font-size: 13px">原价{{ details.itemprice }}</span>
                    </van-col>
                    <van-col span="8" style="text-align: center">
                        <span style="color: darkgray;font-size: 13px">卷金额{{ details.couponmoney }}</span>
                    </van-col>
                    <van-col span="7" style="text-align: right">
                        <span style="color: darkgray;font-size: 13px">月销{{ details.itemsale }}</span>
                    </van-col>
                    <van-col span="1"></van-col>
                </van-row>
                <!--商品标题区 end-->

                <!--推荐语-->
                <van-panel title="商品简介" desc="" status="">
                    <van-row type="flex" justify="center">
                        <van-col span="20" style="padding: 5px 0 5px 0">
                            <span style="font-size: 15px;color: #999999">{{ details.itemdesc }}</span>
                        </van-col>
                    </van-row>
                </van-panel>

                <!--使用教程-->
                <van-panel title="优惠劵使用简介" desc="" status="">
                    <van-row type="flex" justify="center">
                        <van-col span="20" style="padding: 5px 0 5px 0">
                            <span style="font-size: 15px;color: #999999">
                                点击立即领卷按钮，会跳转到淘宝官方领卷页面进行领卷
                            </span>
                        </van-col>
                    </van-row>
                </van-panel>

                <van-actionsheet v-model="share" title="分享商品">
                    <van-row type="flex" justify="center">
                        <van-col span="24" style="text-align: center;justify-content: center;align-items: center">
                            <div id="qrcode" style="display: inline"></div>
                        </van-col>
                    </van-row>
                    <van-row type="flex" justify="center">
                        <van-col span="24" style="text-align: center;justify-content: center;align-items: center">
                            <span style="font-size: 15px;color: #999999">长按图片，保存二维码</span>
                        </van-col>
                    </van-row>
                </van-actionsheet>

                <orange-technology-footer></orange-technology-footer>

            </div>

            <!--底部-->
            <div v-if="isPageLoadComplete == 2" class="orange-footer">
                <van-goods-action>
                    <van-goods-action-big-btn
                            @click="openTb()"
                            text="查看商品详情" />
                    <van-goods-action-big-btn
                            @click="btv()"
                            primary
                            text="立即领卷"
                    />
                </van-goods-action>
            </div>
            <!--底部 end-->

        </div>

    </div>

</template>

<script>

    import QRCode from 'qrcodejs2'
    import '../../static/jquery-1.9.1.min.js'

    export default {
        name: "Details",
        mounted() {

            this.$axios.get('goods/getDetails',{
                params: {
                    goodsId: this.$route.query.id,
                }
            }).then((rsp) => {

                if (rsp.data.code == 1) {

                    this.details = rsp.data.data;

                    this.isPageLoadComplete = 2;

                } else {
                    this.isPageLoadComplete = 1;
                    this.$alert.notifyNoData();
                }

            }).catch((e) => {
                this.isPageLoadComplete = 1;
                this.$alert.dialogUnknown(e);
            });

        },
        data() {
            return {
                share: false,
                isPageLoadComplete: 0, //页面是否加载完成 0.正在加载 1.加载失败 2.加载完毕 ...
                details: '',
            }
        },
        methods: {
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/" });
            },
            openShare() {
                this.share = true;
                this.$nextTick(function() {
                    if ($("#qrcode").children("img").length < 1) { //检测dom是否存在
                        new QRCode(document.getElementById('qrcode'), {
                            text: "http://172.20.10.3/#" + this.$route.fullPath,
                            width: 200,
                            height: 200,
                        });
                        setInterval(function () { //让图片居中
                            $("#qrcode").children("img").css("display","inline");
                        },50);
                    }
                });
            },
            openTb: function () {
                this.$dialog.alert({
                    message: '链接将跳转淘宝，商品详情看完，觉得满意返回本页面点击立即领卷按钮进行领卷'
                }).then(() => {
                    location.assign('http://detail.m.tmall.com/item.htm?id=' + this.details.itemid);
                });
            },
            btv() { //领卷
                this.$toast('正在前往淘宝官方领卷页面，请耐心等待...');
                this.$axios.get('goods/ratesurl',{
                    params: {
                        goodsId: this.$route.query.id,
                    }
                }).then((rsp) => {

                    if (rsp.data.code == 1) {
                        location.assign(rsp.data.data.coupon_click_url);
                    } else {
                        this.$alert.notifyNoData();
                    }

                }).catch((e) => {
                    this.$alert.dialogUnknown(e);
                });
            },
        }
    }
</script>

<style scoped>
</style>
