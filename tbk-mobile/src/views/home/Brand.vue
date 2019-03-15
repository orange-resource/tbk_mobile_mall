<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="超值大牌"
                    left-text="返回"
                    right-text="首页"
                    left-arrow
                    @click-right="onClickRight"
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--出来商品-->
            <van-tabs @click="tabSearch">
                <van-tab v-for="(j,inde) in tab" :key="'k' + inde" :title="j.name">

                    <van-list
                            v-model="j.loading"
                            :finished="j.finished"
                            finished-text="没有更多了"
                            @load="onLoad"
                    >
                        <orange-card v-for="(t,index) in j.data" :key="'p'+index">

                            <img :src='t.brand_logo'
                                 class="theme-image" width="100%"
                            />

                            <van-row type="flex" justify="center">
                                <van-col span="22">
                                    <span>{{ t.fq_brand_name }}</span>
                                </van-col>
                            </van-row>

                            <van-row type="flex" justify="center">
                                <van-col span="22" v-html="t.introduce" class="theme-content">

                                </van-col>
                            </van-row>

                            <orange-goods-sell
                                    v-for="(i,ind) in t.item"
                                    :key="'q' + ind"
                                    :image="i.itempic"
                                    :title="i.itemtitle"
                                    :price="i.itemendprice"
                                    :originalPrice="i.itemprice"
                                    :payment="i.itemsale"
                                    :to='"/goods?id=" + i.itemid'
                            ></orange-goods-sell>

                        </orange-card>
                    </van-list>

                </van-tab>
            </van-tabs>

            <orange-up></orange-up>

        </div>

    </div>

</template>

<script>

    export default {
        name: "Brand",
        mounted() {

        },
        data() {
            return {
                tab: [
                    {name: '全部',loading: false,finished: false,total: 0,data: []},
                    {name: '母婴童品',loading: false,finished: false,total: 0,data: []},
                    {name: '百变女装',loading: false,finished: false,total: 0,data: []},
                    {name: '食品酒水',loading: false,finished: false,total: 0,data: []},
                    {name: '居家日用',loading: false,finished: false,total: 0,data: []},
                    {name: '美妆洗护',loading: false,finished: false,total: 0,data: []},
                    {name: '品质男装',loading: false,finished: false,total: 0,data: []},
                    {name: '舒适内衣',loading: false,finished: false,total: 0,data: []},
                    {name: '箱包配饰',loading: false,finished: false,total: 0,data: []},
                    {name: '男女鞋靴',loading: false,finished: false,total: 0,data: []},
                    {name: '宠物用品',loading: false,finished: false,total: 0,data: []},
                    {name: '数码家电',loading: false,finished: false,total: 0,data: []},
                    {name: '车品文体',loading: false,finished: false,total: 0,data: []},
                ],
                tagIndex: 0,
            }
        },
        methods:{
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/" });
            },
            tabSearch(index, title) { //点击标签，换标签触发
                this.tagIndex = index;
            },
            onLoad() { //继续加载数据事件
                this.tab[this.tagIndex].total+=1;
                this.getData(this.tagIndex,this.tab[this.tagIndex].total);
            },
            getData(index,page) {

                this.$axios.get('home/brand',{
                    params: {
                        tag: index,
                        page: page,
                    }
                }).then((rsp) => {

                    console.log(rsp.data);
                    console.log(rsp.data.code);
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

    .theme-image {
        height: 150px;
        border-radius: 5%;
    }

    .theme-content {
        font-size: 15px;
        color: #999999;
        padding-bottom: 5px
    }

</style>
