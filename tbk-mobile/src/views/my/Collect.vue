<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="收藏商品"
                    left-text="返回"
                    right-text="我的"
                    left-arrow
                    @click-right="onClickRight"
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--删除-->
            <van-row type="flex" justify="center">
                <van-col span="22" style="margin-top: 10px">
                    <span style="font-size: 15px;color: #999999">
                        提示: 收藏夹最多保存100个宝贝，如果超出100个宝贝，如果此时收藏了新的宝贝，最末尾的宝贝将会自动删除
                    </span>
                </van-col>
            </van-row>
            <van-row type="flex" justify="center">
                <van-col span="22" style="margin: 10px 0 10px 0">
                    <van-button size="large" round type="primary" @click="remove()">全部删除</van-button>
                </van-col>
            </van-row>

            <!--出来商品-->
            <orange-goods-sell
                    v-for="(i,index) in data"
                    :key="index"
                    :image="i.itempic"
                    :title="i.itemtitle"
                    :price="i.itemendprice"
                    :originalPrice="i.itemprice"
                    :payment="i.itemsale"
                    :to='"/goods?id=" + i.itemid'
            ></orange-goods-sell>

            <orange-up></orange-up>

        </div>

    </div>

</template>

<script>

    import { queue } from "../../static/queue";

    export default {
        name: "Collect",
        mounted() {
            this.data = queue.get(this.collectKey);
        },
        data() {
            return {
                data: [],
                collectKey: 'orange-tyh-collect',
            }
        },
        methods: {
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/my" });
            },
            remove() {
                queue.remove(this.collectKey);
                this.data = queue.get(this.collectKey);
            }
        }
    }
</script>

<style scoped>

</style>
