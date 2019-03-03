<template>

    <div class="bc" style="height: 100%">

        <div class="qzqt-home bc">

            <div class="qzqt-content">

                <!--头部-->
                <van-search placeholder="请输入搜索关键词" v-model="keyword" />
                <qzqt-swipe :images="images"></qzqt-swipe>
                <!--头部 end-->

                <!--分类区-->
                <div v-for="g in grid"
                     style="float: left;width: 20%;display: flex;flex-direction: column;background-color: #fff;padding-bottom: 10px"
                     @click="gridOpen(g.toUrl)">
                    <img :src="g.imageUrl"
                         style="height: 70px"/>
                    <span style="font-size: 10px;text-align: center">{{g.name}}</span>
                </div>
                <!--分类区 end-->

                <!--文章热点-->
                <van-row type="flex" justify="space-around" style="clear: both;padding-top: 5px">
                    <van-col span="24">
                        <van-cell-group>
                            <van-cell to="/article/list" title="商场热点" label="咨询快达" value="更多"/>
                        </van-cell-group>
                        <van-tabbar :fixed="false">
                            <van-tabbar-item to="/article/list" icon="home-o" info="99">3G咨询</van-tabbar-item>
                            <van-tabbar-item to="/article/list" icon="home-o" info="99">站内快讯</van-tabbar-item>
                            <van-tabbar-item to="/article/list" icon="home-o" info="99">商城公告</van-tabbar-item>
                            <van-tabbar-item to="/article/list" icon="setting-o" info="99">公告</van-tabbar-item>
                            <van-tabbar-item to="/article/list" icon="setting-o" info="99">入驻说明</van-tabbar-item>
                        </van-tabbar>
                    </van-col>
                </van-row>
                <!--文章热点 end-->

                <!--广告区1-->
                <div v-for="g in pretty">
                    <div style="float: left;width: 50%;display: flex;flex-direction: column;" @click="gridOpen(g.toUrl)">
                        <img :src="g.imageUrl" width="100%" height="100%"/>
                    </div>
                </div>

                <van-row type="flex" justify="center" style="clear: both;">
                    <van-col span="24" style="display: flex;justify-content: center;align-items: center">
                        <img src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536796690071.jpg"
                             width="100%" height="100%">
                    </van-col>
                </van-row>
                <!--广告区1 end-->

                <!--分类瀑布-->
                <qzqt-category-waterfall
                        :data="categoryData"
                ></qzqt-category-waterfall>

                <qzqt-category-waterfall
                        :data="categoryData2"
                ></qzqt-category-waterfall>

                <qzqt-category-waterfall
                        :data="categoryData"
                ></qzqt-category-waterfall>

                <qzqt-category-waterfall
                        :data="categoryData2"
                ></qzqt-category-waterfall>
                <!--分类瀑布 end-->

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
                            <img src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536796784749.jpg"
                                 width="100%" height="100%">
                        </van-col>
                    </van-row>
                    <van-list
                            style="margin-top: 10px"
                            v-model="loading"
                            :finished="finished"
                            finished-text="没有更多了"
                            @load="onLoad"
                    >
                        <qzqt-goods-card
                                v-for="item in list"
                                topTag="推荐"
                                title="17年春夏新款百搭半身裙蛋糕裙 a字裙 裤裙伞裙大码裙子超短裙女 松紧腰围 带裤边打底衬 涤针织面料"
                                price="14"
                                image="https://x.dscmall.cn/storage/images/201703/thumb_img/0_thumb_G_1490174791219.jpg"
                                to="/my"
                        ></qzqt-goods-card>
                    </van-list>
                </div>
                <!--商品推荐 end-->

            </div>


            <qzqt-footer></qzqt-footer>

        </div>

    </div>

</template>

<script>

    export default {
        name: "Home",
        data() {
            return {
                categoryData: {
                    image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536797927775.jpg',
                    main: {
                        image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798552971.jpg',
                        to: 'goods',
                        dr: [
                            {
                                image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798553908.jpg',
                                to: 'goods',
                            },
                            {
                                image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798555717.jpg',
                                to: 'goods',
                            },
                        ],
                    },
                    middle: [
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798774807.jpg',
                            to: 'goods',
                        },
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798775204.jpg',
                            to: 'goods',
                        },
                    ],
                    bottom: [
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798776624.jpg',
                            to: 'goods',
                        },
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798777479.jpg',
                            to: 'goods',
                        },
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798778499.jpg',
                            to: 'goods',
                        },
                    ],
                },
                categoryData2: {
                    image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536797927775.jpg',
                    main: {
                        image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798552971.jpg',
                        to: 'goods',
                        dr: [
                            {
                                image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798553908.jpg',
                                to: 'goods',
                            },
                            {
                                image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798555717.jpg',
                                to: 'goods',
                            },
                        ],
                    },
                    bottom: [
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798776624.jpg',
                            to: 'goods',
                        },
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798777479.jpg',
                            to: 'goods',
                        },
                        {
                            image: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536798778499.jpg',
                            to: 'goods',
                        },
                    ],
                },
                list: [],
                loading: false,
                finished: false,
                keyword: '',
                images: [
                    {
                        src: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792288923.jpg',
                        to: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792288923.jpg',
                    },
                    {
                        src: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792289990.jpg',
                        to: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792289990.jpg',
                    },
                ],
                grid: [
                    {
                        name: '潮流女装',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                    {
                        name: '男装男鞋',
                        imageUrl: 'https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792341842.png',
                        toUrl: 'www.baidu.com',
                    },
                ],
                pretty: [
                    {
                        imageUrl: "https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536793226579.jpg",
                        toUrl: 'www.baidu.com',
                    },
                    {
                        imageUrl: "https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536793228116.jpg",
                        toUrl: 'www.baidu.com',
                    },
                ]
            }
        },
        methods: {
            gridOpen(open) {
                console.log(open);
            },
            onLoad() {
                // 异步更新数据
                setTimeout(() => {
                    for (let i = 0; i < 10; i++) {
                        this.list.push(this.list.length + 1);
                    }
                    // 加载状态结束
                    this.loading = false;

                    // 数据全部加载完成
                    if (this.list.length >= 40) {
                        this.finished = true;
                    }
                }, 500);
            },
        }
    }

</script>

<style scoped>

</style>
