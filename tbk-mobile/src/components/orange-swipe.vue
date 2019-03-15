<template>

    <van-swipe :autoplay="3000">
        <van-swipe-item v-for="(image,index) in images" :key="index">
            <img :src="image.src" width="100%" height="170px" @click="open(image.to)" />
        </van-swipe-item>

    </van-swipe>

</template>

<script>
    export default {
        name: "orange-swipe",
        props: ["images"],
        methods: {
            open(to) {
                location.assign(to);
            },
        }
    }
</script>

<style scoped>

</style>
