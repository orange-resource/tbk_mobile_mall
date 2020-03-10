<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    :title="title"
                    left-text="返回"
                    right-text="首页"
                    left-arrow
                    @click-right="onClickRight"
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--出来商品-->
            <van-tabs @click="choiceCategory">
                <van-tab v-for="(name,index) in category" :key="index" :title="name">
                </van-tab>
            </van-tabs>
            <van-tabs @click="tabSearch" type="card" style="margin-top: 10px">
                <van-tab v-for="(t,index) in tab" :key="index" :title="t.name">

                    <van-list
                            v-model="t.loading"
                            :finished="t.finished"
                            finished-text="没有更多了"
                            @load="onLoad"
                    >
                        <orange-goods-sell
                                v-for="(i,index) in t.data"
                                :key="index"
                                :image="i.itempic"
                                :title="i.itemtitle"
                                :price="i.itemendprice"
                                :originalPrice="i.itemprice"
                                :payment="i.itemsale"
                                :to='"/goods?id=" + i.itemid'
                        ></orange-goods-sell>
                    </van-list>

                </van-tab>
            </van-tabs>

            <orange-up></orange-up>

        </div>

    </div>

</template>

<script>

    export default {
        name: "SearchGoods",
        mounted() {

            if (this.$route.query.title == '9.9包邮' && this.$route.query.type == 2) {
            } else if (this.$route.query.title == '今日上新' && this.$route.query.type == 1) {
            } else if (this.$route.query.title == '30元封顶' && this.$route.query.type == 3) {
            } else if (this.$route.query.title == '天猫商品' && this.$route.query.type == 9) {
            } else if (this.$route.query.title == '品牌爆款' && this.$route.query.type == 8) {
            } else if (this.$route.query.title == '聚划算' && this.$route.query.type == 4) {
            } else if (this.$route.query.title == '淘抢购' && this.$route.query.type == 5) {
            } else {
                this.$router.push({ path: "/error/404" });
            }

            this.title = this.$route.query.title;
            this.type = this.$route.query.type;

            this.getData(this.tagIndex,this.tab[this.tagIndex].total);

        },
        data() {
            return {
                type: '',
                tab: [
                    {name: '综合',loading: true,finished: false,total: 1,data: []},
                    {name: '卷后价',loading: true,finished: false,total: 1,data: []},
                    {name: '销量',loading: true,finished: false,total: 1,data: []},
                    {name: '超优惠',loading: true,finished: false,total: 1,data: []},
                ],
                tagIndex: 0,
                category: [
                    '全部',
                    '女装',
                    '男装',
                    '内衣',
                    '美妆',
                    '配饰',
                    '鞋品',
                    '箱包',
                    '儿童',
                    '母婴',
                    '居家',
                    '美食',
                    '数码',
                    '家电',
                    '其他',
                    '车品',
                    '文体',
                    '宠物',
                ],
                cid: 0,
                title: '',
            }
        },
        methods:{
            onClickLeft() {
                this.$router.back(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/" });
            },
            tabSearch(index, title) { //点击标签，换标签触发
                this.tagIndex = index;
                this.tab[this.tagIndex].total = 1;
                this.getData(this.tagIndex,1);
            },
            choiceCategory(index, title) { //点击标签，换标签触发
                this.cid = index;
                this.tab[this.tagIndex].total = 1;
                this.getData(this.tagIndex,1);
            },
            onLoad() { //继续加载数据事件
                this.tab[this.tagIndex].total+=1;
                this.getData(this.tagIndex,this.tab[this.tagIndex].total);
            },
            getData(index,page) {

                this.$axios.get('home/district',{
                    params: {
                        tag: index,
                        page: page,
                        type: this.type,
                        category: this.cid,
                    }
                }).then((rsp) => {

                    if (rsp.data.code == 1) {
                        if (page == 1) {
                            this.tab[index].data = [];
                        }
                        for (let i = 0;i < rsp.data.data.length;i++) {
                            this.tab[index].data.push(rsp.data.data[i]);
                        }
                        this.tab[index].loading = false;
                    } else {
                        this.tab[index].loading = false;
                        this.tab[index].finished = true;
                        this.$alert.notifyNoData(rsp.data.msg);
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
