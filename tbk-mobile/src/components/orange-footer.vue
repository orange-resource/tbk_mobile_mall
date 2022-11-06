<template>
    <div class="orange-footer">
        <van-tabbar v-model="active">
            <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
            <van-tabbar-item to="/hot" icon="fire-o">热销区</van-tabbar-item>
            <van-tabbar-item to="/search/main" icon="search">搜索商品</van-tabbar-item>
            <van-tabbar-item to="/discovery" icon="aim">发现</van-tabbar-item>
            <van-tabbar-item to="/my" icon="manager-o">我的</van-tabbar-item>
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
        methods: {
        },
        mounted(){
            switch (this.$route.name) {
                case "home":
                    this.active = 0;
                    break;
                case "hot":
                    this.active = 1;
                    break;
                case "searchMain":
                    this.active = 2;
                    break;
                case "discovery":
                    this.active = 3;
                    break;
                case "my":
                    this.active = 4;
                    break;
            }
        }
    }
</script>

<style scoped>

</style>
