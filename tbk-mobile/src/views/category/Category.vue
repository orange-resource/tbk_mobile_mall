<template>

    <div class="bc" style="height: 100%">

        <div class="orange-home bc" style="height: 100%">
            <div class="orange-content" style="display: flex;flex-direction: column">

                <div style="height: 44px">
                    <van-search placeholder="请输入搜索关键词" v-model="keyword" />
                </div>

                <div style="flex: auto;display: flex;flex-direction: row">

                    <div style="width: 100px;overflow:auto;flex-shrink: 0">
                        <van-badge-group :active-key="activeKey" @change="onChange">
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                            <van-badge  title="g" />
                        </van-badge-group>
                        <br>
                    </div>

                    <div style="flex: auto;overflow:auto;">

                        <van-row type="flex" style="padding-top: 10px;text-align: center">
                            <van-col span="1"></van-col>
                            <van-col span="22">
                                <orange-advertising src="https://x.dscmall.cn/storage/data/touch_catads/15444645367579.jpg">
                                </orange-advertising>
                            </van-col>
                            <van-col span="1"></van-col>
                        </van-row>

                        <van-row v-for="y in 2" type="flex" justify="center" style="padding-top: 10px">
                            <van-col span="22">
                                <orange-horizontal-piece
                                        style="font-size: 15px;"
                                        title="女装">
                                </orange-horizontal-piece>
                                <div v-for="t in 10"
                                     style="float: left;width: 33.333333333333333333333333333%;padding-top: 10px;height: 85px">
                                    <div style="display: flex;flex-direction: column;align-items: center">
                                        <img src="https://x.dscmall.cn/storage/images/201809/thumb_img/0_thumb_G_1536532312220.jpg"
                                        width="63px" height="63px"
                                        >
                                        <span style="font-size: 10px;color: darkgrey;margin-top: 2px">冰箱</span>
                                    </div>
                                </div>
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
            for (let i = 0;i < 100;i++) {
                this.items.push({
                    text: '童话故事' + i,
                    id: i,
                    children: [
                        {
                            text: '鞋子' + i,
                            id: 2,
                        },
                    ]
                });
            }
        },
        data() {
            return {
                keyword: '',
                items: [],
                // 左侧高亮元素的index
                mainActiveIndex: 0,
                // 被选中元素的id
                activeId: 0,
                activeKey: 0
            };
        },
        methods: {
            onSearch() {
                alert(this.keyword);
            },
            onNavClick(index) {
                this.mainActiveIndex = index;
            },
            onItemClick(data) {
                this.activeId = data.id;
            },
            onChange(key) {
                this.activeKey = key;
            },
        }
    }

</script>

<style scoped>

</style>
