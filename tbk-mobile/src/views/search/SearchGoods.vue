<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="搜索商品"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--搜索筛选-->
            <van-search
                    v-model="value"
                    placeholder="请输入搜索关键词"
                    show-action
                    @search="onSearch"
            >
                <div slot="action" @click="onSearch">筛选</div>
            </van-search>
            <van-tabs animated>
                <van-tab>
                    <div slot="title">
                        <van-icon name="arrow-up" />筛选
                    </div>
                    <qzqt-goods-sell
                            v-for="g in 11"
                            image="https://x.dscmall.cn/storage/images/201809/goods_img/0_P_1536614291769.jpg"
                            title="CASIO卡西欧35周年限量G-SHOCK × A$AP FERG联名款GA-110FRG-7A"
                            price="13"
                            originalPrice="299"
                            logistics="11"
                            payment="13"
                            address="泉州"
                            tag="促销"
                    ></qzqt-goods-sell>
                </van-tab>
                <van-tab>
                    <div slot="title">
                        新品
                    </div>
                    内容
                </van-tab>
                <van-tab>
                    <div slot="title">
                        销量
                    </div>
                    内容
                </van-tab>
                <van-tab>
                    <div slot="title">
                        <van-icon name="arrow-down" />价格
                    </div>
                    内容
                </van-tab>
            </van-tabs>
            <!--搜索筛选 end-->

            <van-popup v-model="show" position="right" :overlay="false"
                       style="width: 100%;height: 100%;position: absolute;" class="bc">

                <van-nav-bar
                        title="筛选"
                        left-text="返回"
                        left-arrow
                        @click-left="show = false"
                />

                <qzqt-card>
                    <van-cell-group>
                        <van-switch-cell v-model="checked" title="仅看有货" />
                        <van-switch-cell v-model="checked" title="促销" />
                    </van-cell-group>
                </qzqt-card>

                <qzqt-card>
                    <van-panel title="价格区间" desc="" status="">
                        <van-row type="flex" justify="center" style="padding-bottom: 10px">
                            <van-col span="22">
                                <van-row type="flex" justify="center">
                                    <van-col span="10">
                                        <input style="width: 100%">
                                    </van-col>
                                    <van-col span="4" style="text-align: center">-</van-col>
                                    <van-col span="10">
                                        <input style="width: 100%">
                                    </van-col>
                                </van-row>
                            </van-col>
                        </van-row>

                    </van-panel>
                </qzqt-card>

                <qzqt-card>
                    <van-cell-group>
                        <van-field
                                label="品牌名"
                                placeholder="请输入品牌名"
                        />
                    </van-cell-group>
                </qzqt-card>

                <van-row type="flex" justify="center">
                    <van-col span="22">
                        <van-button type="danger" style="width: 100%">确认</van-button>
                    </van-col>
                </van-row>


            </van-popup>

        </div>

    </div>

</template>

<script>

    export default {
        name: "SearchGoods",
        data() {
            return {
                show: false,
                value: '',
                checked: true,
                activeNames: ['1'],
            }
        },
        methods:{
            onClickLeft() {
                this.$router.push({
                    name: 'searchMain',
                })
            },
            onSearch() {
                this.show = true;
            },
        }
    }
</script>

<style scoped>

</style>
