<template>
    <div class="qzqt-footer">
        <van-tabbar v-model="active">
            <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
            <van-tabbar-item to="/category" icon="coupon-o">分类</van-tabbar-item>
            <van-tabbar-item to="/cart" icon="shopping-cart-o">购物车</van-tabbar-item>
            <van-tabbar-item to="/my" icon="contact">我</van-tabbar-item>
        </van-tabbar>
    </div>
</template>

<script>
    export default {
        name: "qzqt-footer",
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
                case "category":
                    this.active = 1;
                    break;
                case "cart":
                    this.active = 2;
                    break;
                case "my":
                    this.active = 3;
                    break;
            }
        }
    }
</script>

<style scoped>

</style>
