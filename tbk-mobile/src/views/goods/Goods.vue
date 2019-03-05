<template>

    <div class="bc" style="height: 100%">

        <div class="orange-home bc">

            <div class="orange-content">

                <!--头部轮播-->
                <van-swipe @change="onChange" style="background-color: #fff">
                    <van-swipe-item>
                        <img src="https://x.dscmall.cn/storage/images/201703/goods_img/0_P_1490211620030.jpg"
                             width="100%" height="375px"/>
                    </van-swipe-item>
                    <van-swipe-item>
                        <img src="https://x.dscmall.cn/storage/images/201703/goods_img/0_P_1490211620030.jpg"
                             width="100%" height="375px"/>
                    </van-swipe-item>
                    <van-swipe-item>
                        <img src="https://x.dscmall.cn/storage/images/201703/goods_img/0_P_1490211620030.jpg"
                             width="100%" height="375px"/>
                    </van-swipe-item>

                    <div style="position: absolute;top: 10px;left: 5px" slot="indicator">
                        <div style="display: flex;justify-content: center;align-items:center;
                background-color: #fff;border-radius: 50%;width: 30px;height: 30px">
                            <van-icon name="arrow-left" style="font-weight: 600" />
                        </div>
                    </div>
                    <div style="position: absolute;top: 10px;right: 5px" slot="indicator">
                        <div style="display: flex;justify-content: center;align-items:center;
                background-color: #fff;border-radius: 50%;width: 30px;height: 30px">
                            <van-icon name="search" style="font-weight: 600"  @click="zoom()" />
                        </div>
                    </div>

                    <div class="custom-indicator" slot="indicator">
                        {{ current + 1 }}/3
                    </div>
                </van-swipe>
                <!--头部轮播 end-->

                <!--商品标题区-->
                <div style="padding: .5em 1em 0 1em;background-color: #fff">
                    <div>
                        <span style="color: red;font-size: 20px;font-weight: 600">¥1080-13987</span>
                    </div>
                </div>
                <div style="padding: 0 5em 0 1em;background-color: #fff;position: relative">
            <span style="font-weight: 600">
                中式现代实木布艺沙发组合现代转角大小户型客厅整装家具
            </span>
                    <div style="position: absolute;right: 0;bottom: .5em">
                        <van-button type="danger" size="small">分享</van-button>
                    </div>
                </div>
                <van-row type="flex" style="background-color: #fff;padding: 10px 0 10px 0">
                    <van-col span="1"></van-col>
                    <van-col span="7">
                        <span style="color: darkgray;font-size: 13px">免运费</span>
                    </van-col>
                    <van-col span="8" style="text-align: center">
                        <span style="color: darkgray;font-size: 13px">月销32565</span>
                    </van-col>
                    <van-col span="7" style="text-align: right">
                        <span style="color: darkgray;font-size: 13px">江西赣州</span>
                    </van-col>
                    <van-col span="1"></van-col>
                </van-row>
                <!--商品标题区 end-->

                <!--商品服务简介区-->
                <div style="margin-top: 5px">
                    <van-cell title="领卷" is-link value="满598减40..." />
                    <van-cell title="服务" is-link value="7天无理由..." />
                    <van-cell title="规格" is-link value="适用人数..." />
                    <van-cell title="参数" is-link value="品牌 型号..." />
                </div>
                <!--商品服务简介区 end-->

                <!--宝贝评价-->
                <div style="margin-top: 5px;background-color: #fff;padding-bottom: 10px">
                    <van-cell title="全部评价(1403)" is-link value="查看全部" />
                    <van-row type="flex">
                        <van-col span="1"></van-col>
                        <van-col span="2">
                            <img src="https://x.dscmall.cn/storage/uploads/image/2018/10/20/94eb5a7fc63404be0465f63f62e6f40d.jpg"
                                 width="20px" height="20px" style="border-radius: 50%" />
                        </van-col>
                        <van-col span="20">
                            <span style="color: darkgray;font-size: 13px">暗***香</span>
                        </van-col>
                        <van-col span="1"></van-col>
                    </van-row>
                    <van-row type="flex">
                        <van-col span="1"></van-col>
                        <van-col span="22" class="twolist-hidden">
                            <a style="font-size: 15px">
                                自从注册了淘宝、天猫、一直就不在意淘宝币和积分怎么用，后来知道了评论的重要性，晒图的重要性，
                                还有晒视频！家里的东西大多都是在电商购买的，以来不用出门瞎逛，而来还能免去出门的后续琐事。
                                真的天猫超市让我越来越懒，可是有什么办法呢，天猫的东西那么好，日期很新鲜，质量有保障，物流配送快捷
                                ，买生活用品假货风险很低，买大品牌比实体店折扣低，还送购物券和津贴，对我们真是太用心了。以前都没有认
                                真评价过，以后需要还会回顾的。
                            </a>
                        </van-col>
                        <van-col span="1"></van-col>
                    </van-row>
                </div>
                <!--宝贝评价 end-->

                <!--店铺简介-->
                <div style="margin-top: 5px;background-color: #fff;padding: 10px 0 10px 0">
                    <van-row type="flex">
                        <van-col span="1"></van-col>
                        <van-col span="17" style="display: flex;flex-direction: row">
                            <img src="https://x.dscmall.cn/storage/uploads/image/2018/10/20/94eb5a7fc63404be0465f63f62e6f40d.jpg"
                                 width="50px" height="50px" style="border-radius: 10%" />
                            <div style="display: flex;flex-direction: column">
                                <span style="font-size: 15px;padding-left: 5px">白糖玫瑰  轻文艺男装店</span>
                                <div style="display: flex;flex-direction: row;padding-left: 5px">
                                    <img src="https://x.dscmall.cn/storage/uploads/image/2018/10/20/94eb5a7fc63404be0465f63f62e6f40d.jpg"
                                         width="20px" height="20px" />
                                    <img src="https://x.dscmall.cn/storage/uploads/image/2018/10/20/94eb5a7fc63404be0465f63f62e6f40d.jpg"
                                         width="20px" height="20px" />
                                    <img src="https://x.dscmall.cn/storage/uploads/image/2018/10/20/94eb5a7fc63404be0465f63f62e6f40d.jpg"
                                         width="20px" height="20px" />
                                </div>
                            </div>
                        </van-col>
                        <van-col span="5" style="text-align: center;line-height: 50px">
                            <van-button size="small" round type="danger">进入店铺</van-button>
                        </van-col>
                        <van-col span="1"></van-col>
                    </van-row>
                    <van-row type="flex" style="background-color: #fff;padding: 10px 0 10px 0">
                        <van-col span="1"></van-col>
                        <van-col span="7">
                            <span style="color: darkgray;font-size: 13px">宝贝描述 4.7 平</span>
                        </van-col>
                        <van-col span="8" style="text-align: center">
                            <span style="color: darkgray;font-size: 13px">卖家服务 4.8 高</span>
                        </van-col>
                        <van-col span="7" style="text-align: right">
                            <span style="color: darkgray;font-size: 13px">物流服务 4.8 平</span>
                        </van-col>
                        <van-col span="1"></van-col>
                    </van-row>
                </div>
                <!--店铺简介 end-->

                <!--宝贝详情-->
                <van-row type="flex" justify="space-around" style="margin: 10px 0 10px 0">
                    <van-col span="24" style="text-align: center">
                        <van-tag plain type="danger">宝贝详情介绍</van-tag>
                    </van-col>
                </van-row>
                <div v-html="desc">
                </div>
                <!--宝贝详情 end-->

            </div>

            <!--底部-->
            <div class="orange-footer">
                <van-goods-action>
                    <van-goods-action-mini-btn
                            icon="chat-o"
                            text="客服"
                    />
                    <van-goods-action-mini-btn
                            info="5"
                            icon="cart-o"
                            text="购物车"
                    />
                    <van-goods-action-mini-btn
                            icon="shop-o"
                            text="店铺"
                    />
                    <van-goods-action-big-btn text="加入购物车" />
                    <van-goods-action-big-btn
                            primary
                            text="立即购买"
                    />
                </van-goods-action>
            </div>
            <!--底部 end-->

        </div>

    </div>

</template>

<script>

    import { ImagePreview } from 'vant';

    export default {
        name: "Goods",
        data() {
            return {
                current: 0,
                desc: '<img width="100%" height="100%" src="https://x.dscmall.cn/storage/uploads/image/2018/10/20/94eb5a7fc63404be0465f63f62e6f40d.jpg" />',
            }
        },
        methods: {
            onChange(index) {
                this.current = index;
            },
            zoom() {
                ImagePreview([
                    'https://x.dscmall.cn/storage/images/201703/goods_img/0_P_1490211620030.jpg',
                ]);
            },
        }
    }
</script>

<style scoped>
    .custom-indicator {
        position: absolute;
        right: 5px;
        bottom: 5px;
        padding: 2px 5px;
        font-size: 12px;
        color: #fff;
        background: rgba(0, 0, 0, 0.1);
    }
    .twolist-hidden {
         -webkit-line-clamp: 2;
         overflow: hidden;
         text-overflow: ellipsis;
         display: -webkit-box;
         -webkit-box-orient: vertical;
     }
</style>
