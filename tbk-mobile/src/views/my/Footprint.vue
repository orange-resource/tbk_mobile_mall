<template>

    <div>

        <!--头部-->
        <van-nav-bar
                title="我的足迹"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--功能区-->
        <van-row type="flex" justify="space-around" style="margin-top: 10px;margin-bottom: 10px">
            <van-col span="24" style="text-align: center">
                <van-button size="small" type="danger" @click="onClickLeft()">全部删除</van-button>
            </van-col>
        </van-row>
        <!--功能区 end-->

        <!--商品展示区-->
        <van-list
                v-model="loading"
                :finished="finished"
                finished-text="没有更多了"
                @load="onLoad"
        >
            <qzqt-goods-card
                    v-for="item in list"
                    bottomTag="2018.14.14来访"
                    topTag="春节商品"
                    title="17年春夏新款百搭半身裙蛋糕裙 a字裙 裤裙伞裙大码裙子超短裙女 松紧腰围 带裤边打底衬 涤针织面料"
                    price="14"
                    image="https://x.dscmall.cn/storage/images/201703/thumb_img/0_thumb_G_1490174791219.jpg"
                    priceTag="优惠价"
                    to="/my"
            ></qzqt-goods-card>
        </van-list>
        <!--商品展示区 end-->

    </div>

</template>

<script>
    export default {
        name: "Footprint",
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
