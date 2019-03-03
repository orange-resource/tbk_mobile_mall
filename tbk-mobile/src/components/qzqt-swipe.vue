<template>

    <van-swipe :autoplay="3000">
        <van-swipe-item v-for="image in images">
            <img :src="image.src" width="100%" height="100%" @click="open(image.to)" />
            <van-tag style="position: absolute; bottom: 5px; left: 0;" type="danger">广告</van-tag>
        </van-swipe-item>

    </van-swipe>

</template>

<script>
    export default {
        name: "qzqt-swipe",
        props: ["images"],
        methods: {
            open(to) {
                this.$router.push({ path: to });
            },
        }
    }
</script>

<style scoped>

</style>
