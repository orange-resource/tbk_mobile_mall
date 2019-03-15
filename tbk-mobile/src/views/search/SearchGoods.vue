<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="搜索商品"
                    left-text="返回"
                    right-text="搜索"
                    left-arrow
                    @click-right="onClickRight"
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--搜索-->
            <van-search
                    v-model="keyword"
                    placeholder="请输入搜索关键词"
                    show-action
                    @search="onSearch"
            >
                <div slot="action" @click="onSearch">搜索</div>
            </van-search>
            <!--搜索 end-->

            <!--出来商品-->
            <van-tabs @click="tabSearch">
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

    import { queue } from "../../static/queue";

    export default {
        name: "SearchGoods",
        mounted() {
            this.keyword = this.$route.query.keyword;
            this.getData(this.tagIndex,this.tab[this.tagIndex].total);
        },
        data() {
            return {
                keyword: '',
                tab: [
                    {name: '综合',loading: true,finished: false,total: 0,data: []},
                    {name: '最新',loading: true,finished: false,total: 0,data: []},
                    {name: '销量',loading: true,finished: false,total: 0,data: []},
                    {name: '价格',loading: true,finished: false,total: 0,data: []},
                ],
                tagIndex: 0,
                localKeyword: 'orange-tyh-keyword',
            }
        },
        methods:{
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/search/main" });
            },
            onSearch() { //搜索按钮触发
                try {
                    queue.insert({
                        key: this.localKeyword,
                        value: {keyword: this.keyword},
                        capacityNum: 20,
                    });
                } catch (e) {
                    console.log(e);
                }
                this.getData(this.tagIndex,1);
            },
            tabSearch(index, title) { //点击标签，换标签触发
                this.tagIndex = index;
                this.tab[this.tagIndex].total = 1;
                this.getData(this.tagIndex,1);
            },
            onLoad() { //继续加载数据事件
                this.tab[this.tagIndex].total+=1;
                this.getData(this.tagIndex,this.tab[this.tagIndex].total);
            },
            getData(index,page) {

                this.$axios.get('search/goods',{
                    params: {
                        tag: index,
                        page: page,
                        keyword: this.keyword,
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
