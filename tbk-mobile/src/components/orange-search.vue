<template>

    <div style="height: 45px;background-color: #F2F6FC">
        <van-row type="flex" justify="center" style="height: 45px;" >
            <van-col span="20" style="justify-content: center;align-items: center;display: flex">
                <van-icon name="search" color="#999999" @click="open()"/>
                <span style="font-size: 15px;color: #999999;margin-left: 5px" @click="open()">点击开始搜索商品</span>
            </van-col>
        </van-row>
    </div>

</template>

<script>
    export default {
        name: "orange-search",
        props:["to"],
        methods: {
            open() {
                location.assign(this.to);
            },
        },
    }
</script>

<style scoped>

</style>
