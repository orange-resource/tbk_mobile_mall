<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="搜索"
                    left-text="首页"
                    left-arrow
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--搜索-->
            <van-search
                    v-model="value"
                    placeholder="请输入搜索关键词"
                    show-action
                    @search="onSearch"
            >
                <div slot="action" @click="onSearch">搜索</div>
            </van-search>
            <!--搜索 end-->

            <!--最近搜索-->
            <van-row type="flex" justify="center" style="margin-top: 20px">
                <van-col span="10" style="display: flex;align-items: center">
                    <span style="font-size: 15px;color: #232326">最近搜索</span>
                </van-col>
                <van-col span="10" style="display: flex;align-items: center;justify-content: flex-end">
                    <van-icon name="delete" />
                </van-col>
            </van-row>
            <van-row type="flex" justify="center">
                <van-col span="20">
                    <van-tag v-for="g in 20" style="margin-left: 10px;margin-top: 10px">标签</van-tag>
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
                    <van-tag v-for="g in 20" type="danger" style="margin-left: 10px;margin-top: 10px">标签</van-tag>
                </van-col>
            </van-row>
            <!--热门搜索 end-->

        </div>

    </div>

</template>

<script>

    export default {
        name: "Search",
        data() {
            return {
                value: '',
            }
        },
        methods: {
            onSearch() {
                console.log(this.value);
            },
            onClickLeft() {
                this.$router.push({
                    name: 'home',
                })
            },
        }
    }

</script>

<style scoped>
</style>
