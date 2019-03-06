<template>

    <!--横线块 组件-->

    <div>
        <van-row type="flex" justify="center" style="display: flex;align-items: center;text-align: center">
            <van-col span="6">
                <hr>
            </van-col>
            <van-col span="10">
                <span>{{ title }}</span>
            </van-col>
            <van-col span="6">
                <hr>
            </van-col>
        </van-row>
    </div>

</template>

<script>
    export default {
        name: "orange-horizontal-piece",
        props:["title"],
    }
</script>

<style scoped>
    hr {
        background-color:#E4E7ED;height:1px;border:none;
    }
</style>
