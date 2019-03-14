<template>

    <div>

        <van-row type="flex" justify="center">
            <van-col span="24" style="display: flex;justify-content: center;align-items: center">
                <img :src="data.image"
                     width="100%" height="100%">
            </van-col>
        </van-row>

        <van-row type="flex" justify="center">
            <van-col span="12" style="">
                <img :src="data.main.image" @click="open(data.main.to)"
                     width="100%" height="100%">
            </van-col>
            <van-col span="12" style="display: flex;flex-direction: column">
                <img v-for="i in data.main.dr" :src="i.image" @click="open(i.to)"
                     width="100%" height="108px">
            </van-col>
        </van-row>


        <van-row type="flex" justify="center">
            <van-col v-for="i in data.middle" span="12" style="display: flex;justify-content: center;align-items: center">
                <img :src="i.image" @click="open(i.to)"
                     width="100%" height="100%">
            </van-col>
        </van-row>

        <van-row type="flex" justify="center">
            <van-col v-for="i in data.bottom" span="8" style="display: flex;justify-content: center;align-items: center">
                <img :src="i.image" @click="open(i.to)"
                     width="100%" height="100%">
            </van-col>
        </van-row>

    </div>

</template>

<script>
    export default {
        name: "orange-category-waterfall",
        props: ["data"],
        methods: {
            open(to) {
                this.$router.push({ path: to });
            },
        }
    }
</script>

<style scoped>

</style>
