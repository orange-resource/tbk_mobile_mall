<template>

    <van-row type="flex" justify="space-around">
        <van-col span="24" style="text-align: center">
            <img v-if="show == 0" src="../static/img/loading.png"
                 width="100%" height="100%">
            <img v-if="show == 1" src="../static/img/dr.png"
                 width="100%" height="100%">
        </van-col>
    </van-row>

</template>

<script>
    export default {
        name: "orange-loading",
        props: ["show"],
    }
</script>

<style scoped>

</style>
