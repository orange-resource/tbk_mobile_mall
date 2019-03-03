<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="我的关注店铺"
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

            <!--店铺展示-->
            <qzqt-store-card
                    v-for="i in 5"
                logo="https://x.dscmall.cn/storage/seller_imgs/seller_logo/logo_thumb/1490153973737916372.jpg"
                name="绿联"
                attention="104325"
                isAttention=1
                style="margin-top: 10px;"
            ></qzqt-store-card>
            <!--店铺展示 end-->

        </div>

    </div>

</template>

<script>

    export default {
        name: "Store",
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

</style>
