<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="搜索"
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
            <van-row v-if="recentKeyword.length > 0" type="flex" justify="center" style="margin-top: 20px">
                <van-col span="10" style="display: flex;align-items: center">
                    <span style="font-size: 15px;color: #232326">最近搜索</span>
                </van-col>
                <van-col span="10" style="display: flex;align-items: center;justify-content: flex-end">
                    <van-icon name="delete" @click="deleteKeyword()" />
                </van-col>
            </van-row>
            <van-row type="flex" justify="center">
                <van-col span="20">
                    <van-tag v-for="(i,index) in recentKeyword" :key="index"
                             @click="tagSearch(i.keyword)"
                             size="large"
                             type="danger" style="margin-left: 10px;margin-top: 10px">
                        {{ i.keyword }}
                    </van-tag>
                </van-col>
            </van-row>
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
                             size="large"
                             type="danger" style="margin-left: 10px;margin-top: 10px">
                        {{ i.keyword }}
                    </van-tag>
                </van-col>
            </van-row>
            <!--热门搜索 end-->
            <br><br>
            <br>

        </div>

        <div class="footer">
            <orange-footer></orange-footer>
        </div>

    </div>

</template>

<script>

    import { queue } from "../../static/queue";

    export default {
        name: "Search",
        mounted() {

            try {
                this.recentKeyword = queue.get(this.localKeyword);
            } catch (e) {
                console.log(e);
            }

            this.$axios.get('search/keyword').then((rsp) => {

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
                recentKeyword: [],
                keyword: '',
                localKeyword: 'orange-tyh-keyword',
            }
        },
        methods: {
            onSearch() {
                if (this.keyword === "") {
                    this.$notify({ type: 'warning', message: '搜索关键词不能为空' })
                    return;
                }

                try {
                    queue.insert({
                        key: this.localKeyword,
                        value: {
                            keyword: this.keyword
                        },
                        capacityNum: 20, //队列容量
                    });
                } catch (e) {
                    console.log(e);
                }
                this.$router.push({ path: "/search/goods?keyword=" + this.keyword });
            },
            tagSearch(keyword) {
                this.$router.push({ path: "/search/goods?keyword=" + keyword });
            },
            deleteKeyword() { //清空最近搜索的关键词
                this.recentKeyword = [];
                queue.remove(this.localKeyword);
            },
        }
    }

</script>

<style scoped>
</style>
