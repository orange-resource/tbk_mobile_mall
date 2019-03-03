<template>
    <div>

        <!--头部-->
        <van-nav-bar
                title="我的收藏夹"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--广告位-->
        <van-row type="flex">
            <van-col span="24">
                <qzqt-advertising src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536792288923.jpg">
                </qzqt-advertising>
            </van-col>
        </van-row>
        <!--广告位 end    -->

        <!--商品展示-->
        <div class="content-card">
            <van-row type="flex" justify="space-around">
                <van-col span="24" style="text-align: center">
                    <van-button size="small" type="danger" @click="onClickLeft()">全部删除</van-button>
                </van-col>
            </van-row>
            <van-row type="flex" justify="space-around" style="padding-top: 10px">
                <van-col span="24">

                    <van-list
                            v-model="loading"
                            :finished="finished"
                            finished-text="没有更多了"
                            @load="onLoad"
                    >
                        <van-card
                                v-for="item in list"
                                tag="打折"
                                price="2.00"
                                desc="8g2400笔记本"
                                title="笔记本华硕 华硕啊啊啊啊啊啊啊啊啊啊"
                                thumb="https://img.yzcdn.cn/upload_files/2017/07/02/af5b9f44deaeb68000d7e4a711160c53.jpg"
                                origin-price="10.00"
                        >
                            <div slot="footer">
                                <van-button size="mini" type="danger">删除</van-button>
                            </div>
                        </van-card>
                    </van-list>

                </van-col>
            </van-row>
        </div>
        <!--商品展示 end-->

    </div>
</template>

<script>
    export default {
        name: "Collect",
        data() {
            return {
                list: [],
                loading: false,
                finished: false
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

    .content-card{
        background-color: #fff;
        margin-top: 8px;
    }

</style>
