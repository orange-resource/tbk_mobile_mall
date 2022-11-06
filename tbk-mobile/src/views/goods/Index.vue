<template>

    <div class="bc" style="height: 100%">

        <div class="orange-home bc">

            <div class="orange-content">

                <!--头部-->
                <van-nav-bar title="商品详情"
                             left-text="返回"
                             right-text="首页"
                             left-arrow
                             @click-left="onClickLeft"
                             @click-right="onClickRight"
                ></van-nav-bar>

                <!--图片展示-->
                <div style="height: 420px">
                    <img class="main-img" :src="details.itempic"
                             width="100%" height="420px"/>
                </div>

                <!--商品标题区-->
                <div style="padding: .5em 1em 0 1em;background-color: #fff">
                    <div>
                        <span style="color: red;font-size: 20px;font-weight: 600">
                            ¥{{ details.itemendprice }}
                        </span>
                        <span style="color: #999999;font-size: 10px;">
                            (卷后价格)
                        </span>
                    </div>
                </div>
                <div style="padding: 10px 5em 0 1em;background-color: #fff;position: relative">
                    <span style="font-weight: 600">
                        {{ details.itemtitle }}
                    </span>
                    <div style="position: absolute;right: 0;bottom: .5em">
                        <van-button @click="openShare()" type="info" size="small">分享</van-button>
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

                <!--猜你喜欢-->
                <van-row type="flex" justify="space-around">
                    <van-col span="24" style="text-align: center">
                        <img src="../../static/img/like.jpg"
                             width="100%" height="45px">
                    </van-col>
                </van-row>
                <orange-goods-card
                        v-for="(i,ind) in like"
                        :key="'e' + ind"
                        :topTag='"优惠劵金额" + i.couponmoney'
                        :title="i.itemtitle"
                        :image="i.itempic"
                        :price="i.itemprice"
                        :priceTag="i.itemendprice"
                        :ratio="true"
                        :to='"../goods?id=" + i.itemid'
                        style="margin-top: 10px"
                ></orange-goods-card>

                <van-action-sheet v-model="share" title="分享商品">
                    <br>
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
                    <br>
                </van-action-sheet>

                <orange-technology-footer style="clear: both"></orange-technology-footer>

            </div>

            <!--底部-->
            <div class="orange-footer">
                <van-goods-action>
                    <van-goods-action-icon
                            :icon="collect.icon"
                            :text="collect.name"
                            @click="clickCollect()"
                    />
                    <van-goods-action-button
                            @click="openTb()"
                            type="warning"
                            text="查看商品详情" />
                    <van-goods-action-button
                            @click="btv()"
                            type="danger"
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

    import { queue } from "../../static/queue";

    export default {
        name: "Details",
        mounted() {

            this.$axios.get('goods/getDetails',{
                params: {
                    goodsId: this.$route.query.id,
                }
            }).then((rsp) => {

                if (rsp.data.code == 1) {

                    rsp.data.data.itemId = rsp.data.data.itemid;
                    this.details = rsp.data.data;

                    try {
                        let isExist = queue.isExist(this.collectKey,rsp.data.data.itemId);
                        if (isExist == true) {
                            this.collect.name = "已收藏";
                            this.collect.icon = "star";
                            this.collect.isCollect = true;
                        } else {
                            this.collect.name = "收藏";
                            this.collect.icon = "star-o";
                            this.collect.isCollect = false;
                        }
                        isExist = queue.isExist(this.footprintKey,rsp.data.data.itemId);
                        if (isExist == false) {
                            queue.insert({
                                key: this.footprintKey,
                                value: this.details,
                            });
                        }
                    } catch (e) {
                        console.log(e);
                    }

                    this.$axios.get('goods/like',{
                        params: {
                            goodsId: this.details.itemid,
                        }
                    }).then((rsp) => {

                        if (rsp.data.code == 1) {

                            this.like = rsp.data.data;

                        } else {
                            this.$alert.notifyNoData(rsp.data.msg);
                        }

                    }).catch((e) => {
                        this.$alert.dialogUnknown(e);
                    });

                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });

        },
        data() {
            return {
                share: false,
                isPageLoadComplete: 0, //页面是否加载完成 0.正在加载 1.加载失败 2.加载完毕 ...
                details: [],
                like: '',
                collect: {
                    icon: 'star-o',
                    name: '收藏',
                    isCollect: false,
                },
                footprintKey: 'orange-tyh-footprint',
                collectKey: 'orange-tyh-collect',
            }
        },
        methods: {
            clickCollect() { //收藏
                if (this.collect.isCollect == true) {
                    queue.removeItem(this.collectKey,[this.details.itemId]);
                    this.collect.name = "收藏";
                    this.collect.icon = "star-o";
                    this.collect.isCollect = false;
                } else {
                    queue.insert({
                        key: this.collectKey,
                        value: this.details,
                    });
                    this.collect.name = "已收藏";
                    this.collect.icon = "star";
                    this.collect.isCollect = true;
                }
            },
            onClickLeft() {
                this.$router.back(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/" });
            },
            openShare() {
                this.share = true;
                this.$nextTick(function() {
                    if ($("#qrcode").children("img").length < 1) { //检测dom是否存在
                        new QRCode(document.getElementById('qrcode'), {
                            text: window.location.href,
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
                this.$axios.get('goods/rates',{
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
    .main-img {
        border: none;
    }
</style>
