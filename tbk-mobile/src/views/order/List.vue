<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <van-nav-bar
                    title="订单管理"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />

            <van-tabs>
                <van-tab v-for="index in 8" :title="'标签 ' + index">

                    <van-search
                            placeholder="搜索全部订单"
                            show-action
                    >
                        <div slot="action">搜索</div>
                    </van-search>

                    <qzqt-order-card
                            v-for="t in 1"
                            logo="https://x.dscmall.cn/storage/seller_imgs/seller_logo/logo_thumb/1490159042082423990.jpg"
                            title="雅雅DIY服装辅料"
                            status="等待买家付款"
                            number="1"
                            money="2214"
                            to="/order/main"
                    >

                        <div slot="content">
                            <qzqt-goods-settlement
                                    v-for="g in 2"
                                    image="https://x.dscmall.cn/storage/images/201703/thumb_img/0_thumb_G_1490146354766.jpg"
                                    title="中式现代实木布艺沙发组合现代转角大小户型客厅整装家具单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构"
                                    sku="单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构单床（颜色备注）;1500mm*2000mm;框架结构"
                                    price="13.00"
                                    piece="2"
                            >
                            </qzqt-goods-settlement>
                        </div>

                        <div slot="btn">
                            <van-button size="small" round type="danger" style="margin-right: 5px">评价</van-button>
                            <van-button size="small" round type="danger" style="margin-right: 5px">查看物流</van-button>
                            <van-button size="small" round type="danger">删除订单</van-button>
                        </div>

                    </qzqt-order-card>

                </van-tab>
            </van-tabs>

            <div>
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
                            v-for="h in list"
                            topTag="推荐"
                            title="17年春夏新款百搭半身裙蛋糕裙 a字裙 裤裙伞裙大码裙子超短裙女 松紧腰围 带裤边打底衬 涤针织面料"
                            price="14"
                            image="https://x.dscmall.cn/storage/images/201703/thumb_img/0_thumb_G_1490174791219.jpg"
                            to="/my"
                    ></qzqt-goods-card>
                </van-list>
            </div>

        </div>

    </div>

</template>

<script>

    export default {
        name: "List",
        data() {
            return {
                list: [],
                loading: false,
                finished: false,
            }
        },
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'my',
                })
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
