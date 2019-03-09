<template>

    <div class="bc" style="height: 100%">

        <div class="orange-home bc">

            <div class="orange-content">

                <!--头部-->
                <orange-search to="/search/main"></orange-search>
                <orange-swipe :images="swipe"></orange-swipe>
                <!--头部 end-->

                <!--广告区1-->
                <!--<div v-for="g in pretty">-->
                    <!--<div style="float: left;width: 50%;display: flex;flex-direction: column;" @click="gridOpen(g.toUrl)">-->
                        <!--<img :src="g.imageUrl" width="100%" height="100%"/>-->
                    <!--</div>-->
                <!--</div>-->

                <!--<van-row type="flex" justify="center" style="clear: both;">-->
                    <!--<van-col span="24" style="display: flex;justify-content: center;align-items: center">-->
                        <!--<img src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536796690071.jpg"-->
                             <!--width="100%" height="100%">-->
                    <!--</van-col>-->
                <!--</van-row>-->
                <!--广告区1 end-->

                <!--广告区 2-->
                <van-row type="flex" justify="center" style="clear: both;">
                    <van-col span="24" style="display: flex;justify-content: center;align-items: center">
                        <img src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536803202470.jpg"
                             width="100%" height="100%">
                    </van-col>
                </van-row>
                <!--广告区2 end-->

                <!--商品推荐-->
                <div style="clear: both;">
                    <van-row type="flex" justify="space-around">
                        <van-col span="24" style="text-align: center">
                            <img src="../../static/img/like.jpg"
                                 width="100%" height="100%">
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
                            :to='"../goods?id=" + i.itemid'
                            style="margin-top: 10px"
                    ></orange-goods-card>
                </div>
                <!--商品推荐 end-->

                <orange-technology-footer style="clear: both"></orange-technology-footer>

            </div>


            <orange-footer></orange-footer>

        </div>

    </div>

</template>

<script>

    export default {
        name: "Home",
        mounted() {
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
                    {
                        src: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792288923.jpg',
                        to: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792288923.jpg',
                    },
                    {
                        src: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792289990.jpg',
                        to: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792289990.jpg',
                    },
                ],
                deserver: [] //今日值得买数据
            }
        },
        methods: {
        }
    }

</script>

<style scoped>

</style>
