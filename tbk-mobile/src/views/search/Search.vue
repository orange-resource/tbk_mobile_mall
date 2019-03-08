<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="搜索"
                    left-text="返回"
                    right-text="首页"
                    left-arrow
                    @click-left="onClickLeft"
                    @click-right="onClickRight"
            />
            <!--头部 end-->

            <!--搜索-->
            <van-search
                    v-model="keyword"
                    placeholder="请输入搜索关键词"
                    show-action
                    @search="onSearch"
            >
                <div slot="action" @click="onSearch">搜索</div>
            </van-search>
            <!--搜索 end-->

            <!--最近搜索-->
            <!--<van-row type="flex" justify="center" style="margin-top: 20px">-->
                <!--<van-col span="10" style="display: flex;align-items: center">-->
                    <!--<span style="font-size: 15px;color: #232326">最近搜索</span>-->
                <!--</van-col>-->
                <!--<van-col span="10" style="display: flex;align-items: center;justify-content: flex-end">-->
                    <!--<van-icon name="delete" />-->
                <!--</van-col>-->
            <!--</van-row>-->
            <!--<van-row type="flex" justify="center">-->
                <!--<van-col span="20">-->
                    <!--<van-tag v-for="g in 20" style="margin-left: 10px;margin-top: 10px">-->
                        <!---->
                    <!--</van-tag>-->
                <!--</van-col>-->
            <!--</van-row>-->
            <!--最近搜索 end-->

            <!--热门搜索-->
            <van-row type="flex" justify="center" style="margin-top: 20px">
                <van-col span="20" style="display: flex;align-items: center">
                    <span style="font-size: 15px;color: #232326">热门搜索</span>
                </van-col>
            </van-row>
            <van-row type="flex" justify="center">
                <van-col span="20">
                    <van-tag v-for="(i,index) in hotKeyword" :key="index"
                             @click="tagSearch(i.keyword)"
                             type="danger" style="margin-left: 10px;margin-top: 10px">
                        {{ i.keyword }}
                    </van-tag>
                </van-col>
            </van-row>
            <!--热门搜索 end-->

        </div>

    </div>

</template>

<script>

    export default {
        name: "Search",
        mounted() {

            this.$axios.get('search/hotKeyword').then((rsp) => {

                if (rsp.data.code == 1) {
                    for (let i = 0;i < rsp.data.data.length;i++) {
                        this.hotKeyword.push(rsp.data.data[i]);
                        if (i == 20) {
                            break;
                        }
                    }
                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });

        },
        data() {
            return {
                hotKeyword: [],
                keyword: '',
            }
        },
        methods: {
            onSearch() {
                location.assign("/search/goods?keyword=" + this.keyword);
            },
            tagSearch(keyword) {
                location.assign("/search/goods?keyword=" + keyword);
            },
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                location.assign("/");
            },
        }
    }

</script>

<style scoped>
</style>
