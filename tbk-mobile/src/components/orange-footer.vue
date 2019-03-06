<template>
    <div class="orange-footer">
        <van-tabbar v-model="active">
            <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
            <van-tabbar-item to="/hot" icon="fire-o">热销区</van-tabbar-item>
            <van-tabbar-item to="/discovery" icon="aim">发现</van-tabbar-item>
            <van-tabbar-item to="/talent" icon="thumb-circle-o">达人说</van-tabbar-item>
        </van-tabbar>
    </div>
</template>

<script>
    export default {
        name: "orange-footer",
        data() {
            return {
                active: 0
            }
        },
        mounted(){
            switch (this.$route.name) {
                case "home":
                    this.active = 0;
                    break;
                case "hot":
                    this.active = 1;
                    break;
                case "discovery":
                    this.active = 2;
                    break;
                case "talent":
                    this.active = 3;
                    break;
            }
        }
    }
</script>

<style scoped>

</style>
