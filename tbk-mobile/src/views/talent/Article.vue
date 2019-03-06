<template>

    <div style="background-color: #fff;height: 100%">

        <div v-if="isPageLoadComplete == 0 || isPageLoadComplete == 1" style="background-color: #fff">
            <van-nav-bar
                    title="达人说文章介绍 加载中..."
                    left-text="返回"
                    right-text="达人说"
                    left-arrow
                    @click-left="onClickLeft"
                    @click-right="onClickRight"
            />
            <orange-loading :show="isPageLoadComplete"></orange-loading>
        </div>

        <div v-if="isPageLoadComplete == 2" style="background-color: #fff">

            <!--头部-->
            <van-nav-bar
                    :title="title"
                    left-text="返回"
                    left-arrow
                    right-text="达人说"
                    @click-right="onClickRight"
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--短介绍区域-->
            <van-row type="flex" justify="center" style="padding-top: 20px;padding-bottom: 5px">
                <van-col span="22">
                    <span style="font-weight: 600;font-size: 20px">{{ shortTitle }}</span>
                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" style="display: flex;flex-direction: row">
                    <div>
                        <van-icon style="color: darkgray;font-size: 13px" name="manager-o" />
                        <span style="color: darkgray;font-size: 13px;margin-left: 3px">{{ talentName }}</span>
                    </div>
                    <div style="margin-left: 10px">
                        <van-icon style="color: darkgray;font-size: 13px" name="eye-o" />
                        <span style="color: darkgray;font-size: 13px;margin-left: 3px">{{ readTimes }}</span>
                    </div>
                </van-col>
            </van-row>

            <!--正文开始-->
            <van-row type="flex" justify="center">
                <van-col span="22" style="text-align: center;margin: 5px 0 5px 0">
                    <span style="font-size: 15px">本文推荐商品</span>
                </van-col>
            </van-row>
            <orange-goods-sell
                    v-for="(i,index) in goods"
                    :key="'q' + index"
                    :image="i.itempic"
                    :title="i.itemtitle"
                    :price="i.itemendprice"
                    :payment="i.itemsale"
                    :to='"../goods?id=" + i.itemid'
            ></orange-goods-sell>

            <van-row type="flex" justify="center">
                <van-col span="22" v-html="content" style="margin-bottom: 20px">
                </van-col>
            </van-row>

            <!--底部-->
            <orange-technology-footer></orange-technology-footer>

        </div>

    </div>

</template>

<script>

    import '../../static/jquery-1.9.1.min.js'
    import '../../static/css/commodity.css'

    export default {
        name: "Article",
        methods: {
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/talent" });
            },
        },
        mounted() {

            this.$axios.get('talent/getArticle',{
                params: {
                    articleId: this.$route.query.id
                }
            }).then((rsp) => {

                if (rsp.data.code == 1) {
                    this.title = rsp.data.data.name;
                    this.shortTitle = rsp.data.data.shorttitle;
                    this.readTimes = rsp.data.data.readtimes;
                    this.talentName = rsp.data.data.talent_name;
                    this.goods = rsp.data.data.items;
                    this.content = rsp.data.data.article
                        .replace(/&lt;img/g, "<img width='100%' ") //处理图片不会撑过头
                        .replace(/&lt;/g, "<")
                        .replace(/&gt;/g, ">")
                        .replace(/&amp;/g, "&")
                        .replace(/&quot;/g, '"')
                        .replace(/&apos;/g, "'");
                    setInterval(function () { //将文中出现的商品全部删除
                        $(".single-content").html('');
                    },1000);
                    this.isPageLoadComplete = 2;
                } else {
                    this.isPageLoadComplete = 1;
                    this.$alert.notifyNoData();
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
                this.isPageLoadComplete = 1;
            })

        },
        data() {
            return {
                isPageLoadComplete: 0, //页面是否加载完成 0.正在加载 1.加载失败 2.加载完毕 ...
                title: '',
                shortTitle: '',
                readTimes: '',
                talentName: '',
                content: ''  ,
                goods: [],
            }
        },
    }
</script>

<style scoped>

</style>
