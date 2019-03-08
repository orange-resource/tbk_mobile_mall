<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="文章列表"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <van-tabs >
                <van-tab v-for="(i,index) in 8" :title="'标签 ' + index" :key="index">
                    <div style="padding-bottom: 10px">

                        <orange-article-card
                                v-for="(p,io) in 3"
                                :key="io"
                                title="资金管理"
                                author="orange"
                                date="2019.1.1"
                                visit="52"
                                to="main"
                                style="margin-top: 10px"
                        ></orange-article-card>

                    </div>
                </van-tab>
            </van-tabs>

        </div>

    </div>

</template>

<script>

    export default {
        name: "Article",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'home',
                })
            },
        },
    }
</script>

<style scoped>
</style>
