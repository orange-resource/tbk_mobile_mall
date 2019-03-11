<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="系统消息"
                    left-text="返回"
                    right-text="我的"
                    left-arrow
                    @click-left="onClickLeft"
                    @click-right="onClickRight"
            />
            <!--头部 end-->

            <orange-article-card
                    v-for="(p,io) in 3"
                    :key="io"
                    title="资金管理"
                    author="orange"
                    date="2019.1.1"
                    to="article"
                    style="margin-top: 10px"
            ></orange-article-card>

        </div>

    </div>

</template>

<script>

    export default {
        name: "MsgList",
        methods: {
            onClickLeft() {
                window.history.go(-1);
            },
            onClickRight() {
                location.assign("/my");
            },
        },
    }
</script>

<style scoped>
</style>
