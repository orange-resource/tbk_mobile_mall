<template>

    <div class="" style="height: 100%;">

        <div class="orange-home">

            <div class="orange-content">

                <!--头部-->
                <!-- <orange-search to="/search/main"></orange-search> -->
                <orange-swipe :images="swipe"></orange-swipe>
                <!--头部 end-->

                <!--分类区-->
                <div style="margin-top:8px"></div>
                <div style="float: left;width: 20%;display: flex;flex-direction: column;background-color: #fff;padding-bottom: 10px"
                     @click="gridOpen('/home/district?type=1&title=今日上新')">
                    <img src='../../static/img/今日上新.jpg'
                         style="height: 70px;border-radius: 35%;margin-left: 2px;margin-right: 2px"/>
                    <span style="font-size: 10px;text-align: center;color: #999999">今日上新</span>
                </div>
                <div style="float: left;width: 20%;display: flex;flex-direction: column;background-color: #fff;padding-bottom: 10px"
                     @click="gridOpen('/home/district?type=2&title=9.9包邮')">
                    <img src='../../static/img/9.9包邮.jpg'
                         style="height: 70px;border-radius: 35%;margin-left: 2px;margin-right: 2px"/>
                    <span style="font-size: 10px;text-align: center;color: #999999">9.9包邮</span>
                </div>
                <div style="float: left;width: 20%;display: flex;flex-direction: column;background-color: #fff;padding-bottom: 10px"
                     @click="gridOpen('/home/district?type=3&title=30元封顶')">
                    <img src='../../static/img/30元封顶.jpg'
                         style="height: 70px;border-radius: 35%;margin-left: 2px;margin-right: 2px"/>
                    <span style="font-size: 10px;text-align: center;color: #999999">30元封顶</span>
                </div>
                <div style="float: left;width: 20%;display: flex;flex-direction: column;background-color: #fff;padding-bottom: 10px"
                     @click="gridOpen('/home/district?type=9&title=天猫商品')">
                    <img src='../../static/img/天猫商品.jpg'
                         style="height: 70px;border-radius: 35%;margin-left: 2px;margin-right: 2px"/>
                    <span style="font-size: 10px;text-align: center;color: #999999">天猫商品</span>
                </div>
                <div style="float: left;width: 20%;display: flex;flex-direction: column;background-color: #fff;padding-bottom: 10px"
                     @click="gridOpen('/home/district?type=8&title=品牌爆款')">
                    <img src='../../static/img/品牌爆款.jpg'
                         style="height: 70px;border-radius: 35%;margin-left: 2px;margin-right: 2px"/>
                    <span style="font-size: 10px;text-align: center;color: #999999">品牌爆款</span>
                </div>
                <!--分类区 end-->

                <div style="clear: both"></div>
                <!--聚划算，淘抢购-->
                <div>
                    <div style="float: left;width: 50%;display: flex;flex-direction: column;" @click="gridOpen('/home/district?type=4&title=聚划算')">
                        <img src="../../static/img/聚划算.jpg" width="100%" height="100%"/>
                    </div>
                    <div style="float: left;width: 50%;display: flex;flex-direction: column;" @click="gridOpen('/home/district?type=5&title=淘抢购')">
                        <img src="../../static/img/淘抢购.jpg" width="100%" height="100%"/>
                    </div>
                </div>

                <!--达人说-->
                <van-row type="flex" justify="center" style="clear: both;">
                    <van-col span="24" style="display: flex;justify-content: center;align-items: center">
                        <img src="../../static/img/达人说.jpg"
                             width="100%" height="100%" @click="openTalent()">
                    </van-col>
                </van-row>

                <!--超值品牌-->
                <van-row type="flex" justify="center" style="clear: both;margin-top: 10px">
                    <van-col span="24" style="display: flex;justify-content: center;align-items: center">
                        <img src="../../static/img/超值大牌.jpg"
                             width="100%" height="100%" @click="openBrand()">
                    </van-col>
                </van-row>

                <!--商品推荐-->
                <div style="clear: both;">
                    <van-row type="flex" justify="space-around">
                        <van-col span="24" style="text-align: center">
                            <img src="../../static/img/like.jpg"
                                 width="100%" height="45px">
                        </van-col>
                    </van-row>
                    <orange-goods-card
                            v-for="(i,index) in deserver"
                            :key="'e' + index"
                            :topTag='"优惠劵金额" + i.couponmoney'
                            :title="i.itemtitle"
                            :image="i.itempic"
                            :price="i.itemprice"
                            :priceTag="i.itemendprice"
                            :ratio="true"
                            :to='"/goods?id=" + i.itemid'
                            style="margin-top: 10px"
                    ></orange-goods-card>
                    <div style="clear: both;"></div>
                </div>
                <!--商品推荐 end-->

                <orange-technology-footer></orange-technology-footer>

            </div>


            <orange-footer></orange-footer>

        </div>

    </div>

</template>

<script>

    export default {
        name: "Home",
        mounted() {

            this.$axios.get('carousel/getListBySort').then((rsp) => {

                if (rsp.data.code == 9) {
                    for (let i = 0;i < rsp.data.data.length;i++) {
                        this.swipe.push({
                            src: rsp.data.data[i].image,
                            to: rsp.data.data[i].clickUrl,
                        });
                    }
                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });

            this.$axios.get('home/deserver').then((rsp) => {

                if (rsp.data.code == 1) {
                    this.deserver = rsp.data.item_info;
                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });
        },
        data() {
            return {
                swipe: [ //轮播大图

                ],
                deserver: [], //今日值得买数据
                grid: [
                    {
                        name: '今日上新',
                        imageUrl: '/static/img/3.jpg',
                        toUrl: '',
                    },
                    {
                        name: '9.9包邮',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: '/home/district?type=2',
                    },
                    {
                        name: '30元封顶',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: '/home/district?type=3',
                    },
                    {
                        name: '天猫商品',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: '/home/district?type=9',
                    },
                    {
                        name: '品牌爆款',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: '/home/district?type=8',
                    },
                ],
                pretty: [
                    {
                        name: '聚划算',
                        imageUrl: "https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536793226579.jpg",
                        toUrl: '/home/district?type=4',
                    },
                    {
                        name: '淘抢购',
                        imageUrl: "https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536793228116.jpg",
                        toUrl: '/home/district?type=5',
                    },
                ]
            }
        },
        methods: {
            gridOpen(to) {
                this.$router.push({ path: to });
            },
            openBrand() {
                this.$router.push({ path: "/home/brand" });
            },
            openTalent() {
                this.$router.push({ path: "/talent" });
            },
        }
    }

</script>

<style scoped>

</style>
