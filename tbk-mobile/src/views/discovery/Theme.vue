<template>

    <div class="bc" style="height: 100%">

        <div class="orange-home bc">

            <div class="orange-content">

                <!--头部-->
                <van-nav-bar title="精选主题推荐商品"
                             left-text="返回"
                             right-text="发现"
                             left-arrow
                             @click-left="onClickLeft"
                             @click-right="onClickRight"
                ></van-nav-bar>

                <!--主题推荐商品-->
                <van-row type="flex" justify="space-around">
                    <van-col span="24" style="text-align: center">
                        <img src="../../static/img/like.jpg"
                             width="100%" height="100%">
                    </van-col>
                </van-row>
                <orange-goods-card
                        v-for="(i,ind) in theme"
                        :key="'e' + ind"
                        :topTag='"优惠劵金额" + i.couponmoney'
                        :title="i.itemtitle"
                        :image="i.itempic"
                        :price="i.itemprice"
                        :priceTag="i.itemendprice"
                        :ratio="true"
                        :to='"/goods?id=" + i.itemid'
                        style="margin-top: 10px"
                ></orange-goods-card>

                <orange-technology-footer style="clear: both"></orange-technology-footer>

            </div>

        </div>

    </div>

</template>

<script>
    export default {
        name: "Theme",
        mounted() {

            this.$axios.get('discovery/theme/single',{
                params: {
                    themeId: this.$route.query.id,
                }
            }).then((rsp) => {

                if (rsp.data.code == 1) {

                    this.theme = rsp.data.data;

                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });

        },
        data() {
            return {
                theme: [],
            }
        },
        methods: {
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/discovery" });
            },
        }
    }
</script>

<style scoped>

</style>
