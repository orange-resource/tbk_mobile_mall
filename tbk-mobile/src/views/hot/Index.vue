<template>

    <div class="bc">

        <div class="orange-home bc" style="height: 100%">
            <div class="orange-content" style="display: flex;flex-direction: column">

                <div style="flex: auto;display: flex;flex-direction: row">

                    <div style="width: 70px;overflow:auto;flex-shrink: 0">
                        <van-sidebar v-model="activeKey" @change="onChange">
                            <van-sidebar-item v-for="(i,index) in category" :title="i.name" :key="'sidebar' + index" />
                        </van-sidebar>
                    </div>

                    <div class="slide" style="flex: auto;overflow:auto;">

                        <van-row type="flex" justify="center" style="padding-top: 10px">

                            <van-col span="22">

                                <orange-horizontal-piece
                                    style="font-size: 15px; padding-top: 15px; padding-bottom: 15px"
                                    title="今日热销">
                                </orange-horizontal-piece>
                                <div v-if="loading" class="loading">
                                    <van-loading color="#1989fa" />
                                </div>
                                <orange-goods-sell
                                    v-else
                                    v-for="(i,index) in goods"
                                    :key="'q' + index"
                                    :image="i.itempic"
                                    :title="i.itemtitle"
                                    :price="i.itemendprice"
                                    :originalPrice="i.itemprice"
                                    :payment="i.itemsale"
                                    :to='"/goods?id=" + i.itemid'
                                ></orange-goods-sell>

                            </van-col>

                        </van-row>
                        <br><br>
                    </div>

                </div>

            </div>

            <orange-footer></orange-footer>

        </div>

    </div>



</template>

<script>

    export default {
        name: "Category",
        mounted() {
            this.getData();
        },
        data() {
            return {
                loading: true,
                keyword: '',
                // 左侧高亮元素的index
                mainActiveIndex: 0,
                // 被选中元素的id
                activeId: 0,
                activeKey: 0,
                //0全部，1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，
                // 9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物
                category: [
                    {name: '全部'},
                    {name: '女装'},
                    {name: '男装'},
                    {name: '内衣'},
                    {name: '美妆'},
                    {name: '配饰'},
                    {name: '鞋品'},
                    {name: '箱包'},
                    {name: '儿童'},

                    {name: '母婴'},
                    {name: '居家'},
                    {name: '美食'},
                    {name: '数码'},
                    {name: '家电'},
                    {name: '其他'},
                    {name: '车品'},
                    {name: '文体'},
                    {name: '宠物'},
                ],
                goods: '',
            };
        },
        methods: {
            getData() {
                this.$axios.get('/home/hot',{
                    params: {
                        category: this.activeKey,
                    }
                }).then((rsp) => {

                    if (rsp.data.code == 1) {
                        this.goods = rsp.data.data;
                        window.scrollTo(0, 0)
                        this.loading = false
                    } else {
                        this.$alert.notifyNoData(rsp.data.msg);
                    }

                }).catch((e) => {
                    this.$alert.dialogUnknown(e);
                });
            },
            onSearch() {
                alert(this.keyword);
            },
            onChange(key) {
                this.activeKey = key;
                this.getData();
            },
        }
    }

</script>

<style scoped>
    .loading {
        height: 150px;
        border-radius: 10px;
        background-color: #fff;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
