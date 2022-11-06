<template>

    <div style="position: relative; width: 100%; height: 100%;" @click="open()">
        <img :src="src" style="flex: none" width="100%" height="100%" alt="alt">
        <van-tag style="position: absolute; bottom: 0; left: 0;" type="danger">广告</van-tag>
    </div>

</template>

<script>
    export default {
        name: "orange-advertising",
        props: ["src","to"],
        methods: {
            open() {
                this.$router.push({ path: this.to });
            },
        }
    }
</script>

<style scoped>

</style>
