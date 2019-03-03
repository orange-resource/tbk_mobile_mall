<template>

    <div class="bc" style="height: 100%">

        <div class="qzqt-home bc">

            <div class="qzqt-content content">

                <van-nav-bar title="购物车"></van-nav-bar>

                <qzqt-card v-for="c in cardGoods">

                    <van-row type="flex" style="height: 40px;line-height: 40px">
                        <van-col span="2"></van-col>
                        <van-col span="2">
                            <van-checkbox v-model="c.checked"></van-checkbox>
                        </van-col>
                        <van-col span="20">
                            <van-cell class="radius" value="领卷" icon="shop-o" is-link>
                                <template slot="title">
                                    <span class="custom-text">{{c.shopName}}</span>
                                </template>
                            </van-cell>
                        </van-col>
                    </van-row>
                    <van-row type="flex" justify="space-around" v-for="g in c.items">
                        <van-col span="2"></van-col>
                        <van-col span="2">
                            <van-checkbox v-model="g.checked"></van-checkbox>
                        </van-col>
                        <van-col span="18">
                            <van-card
                                    :num="g.num"
                                    :tag="g.tag"
                                    :price="g.price"
                                    :desc="g.desc"
                                    :title="g.title"
                                    :thumb="g.thumb"
                                    :origin-price="g.originPrice"
                            >
                                <div slot="footer">
                                    <van-button size="mini" type="danger">删除</van-button>
                                    <van-button size="mini" type="danger">选择配置</van-button>
                                    <van-stepper v-model="g.num" style="margin-top: 5px" />
                                </div>
                            </van-card>
                        </van-col>
                        <van-col span="2"></van-col>
                    </van-row>

                </qzqt-card>

                <qzqt-card>
                    <van-row type="flex" justify="space-around">
                        <van-col span="24" style="text-align: center">
                            <van-button size="small" type="danger">清空失效宝贝</van-button>
                        </van-col>
                    </van-row>
                    <van-row type="flex" justify="space-around" style="padding-top: 10px">
                        <van-col span="3" style="text-align: center">
                            <van-tag>失效</van-tag>
                        </van-col>
                        <van-col span="19">
                            <van-card
                                    desc="8g2400笔记本"
                                    title="商品标题"
                                    thumb="https://img.yzcdn.cn/upload_files/2017/07/02/af5b9f44deaeb68000d7e4a711160c53.jpg"
                            >
                                <div slot="footer">
                                    <van-button size="mini" type="danger">删除</van-button>
                                </div>
                            </van-card>
                        </van-col>
                        <van-col span="2"></van-col>
                    </van-row>
                </qzqt-card>

                <div class="content-card">
                    <van-row type="flex" justify="space-around">
                        <van-col span="24" style="text-align: center">
                            <van-tag plain type="danger">猜你喜欢</van-tag>
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

            </div>

            <div class="footer">
                <van-submit-bar
                        style="bottom: 50px"
                        :price="3050"
                        button-text="结算"
                        @submit="onSubmit"
                >
                    <van-checkbox v-model="checked" style="padding-left: 10px">全选</van-checkbox>
                </van-submit-bar>
                <qzqt-footer></qzqt-footer>
            </div>

        </div>

    </div>

</template>

<script>

    export default {
        name: "Card",
        data() {
            return {
                list: [],
                loading: false,
                finished: false,
                checked: false,
                value: 1,
                cardGoods: [
                    {
                        shopName: 'QQ售卖店铺',
                        checked: false,
                        items: [
                            {
                                checked: false,
                                title: '笔记本啊，华硕的笔记本啊看看啊看看啊',
                                desc: '8g2400配置',
                                thumb: 'https://img.yzcdn.cn/upload_files/2017/07/02/af5b9f44deaeb68000d7e4a711160c53.jpg',
                                tag: '爱你',
                                price: 20,
                                originPrice: 40,
                                num: 3,
                            },
                            {
                                checked: false,
                                title: '笔记本啊，华硕的笔记本啊看看啊看看啊',
                                desc: '8g2400配置',
                                thumb: 'https://img.yzcdn.cn/upload_files/2017/07/02/af5b9f44deaeb68000d7e4a711160c53.jpg',
                                tag: '爱你',
                                price: 20,
                                originPrice: 40,
                                num: 3,
                            },
                        ]
                    },
                    {
                        shopName: 'QQ售卖店铺1',
                        checked: false,
                        items: [
                            {
                                checked: false,
                                title: '笔记本啊，华硕的笔记本啊看看啊看看啊',
                                desc: '8g2400配置',
                                thumb: 'https://img.yzcdn.cn/upload_files/2017/07/02/af5b9f44deaeb68000d7e4a711160c53.jpg',
                                tag: '爱你',
                                price: 20,
                                originPrice: 40,
                                num: 3,
                            },
                        ]
                    },
                ]
            }
        },
        methods: {
            onSubmit() {

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
    .content{
        background-color: #f4f4f4
    }

    .content-card{
        background-color: #fff;
        margin-top: 8px;
    }

    .footer {
        height: 100px;
    }
</style>
