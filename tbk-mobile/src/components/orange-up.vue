<template>

    <div class="top" v-if="show">
        <van-row type="flex" justify="center">
            <van-col span="24">
                <img src="../static/img/up.png" width="100%" height="100%" @click="up()"/>
            </van-col>
        </van-row>
    </div>

</template>

<script>
    export default {
        name: "orange-up",
        mounted() {
            this.$nextTick(function () {
                window.addEventListener('scroll', this.scrollToTop)
            });
        },
        data() {
            return {
                show: false,
            }
        },
        methods: {
            scrollToTop() {
                let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
                if (scrollTop > 1000) {
                    this.show = true;
                } else {
                    this.show = false;
                }
            },
            up() {
                document.body.scrollTop = 0;
                document.documentElement.scrollTop = 0;
            },
        },
        deactivated() {
            document.removeEventListener('scroll',this.scrollToTop,false)
        }
    }
</script>

<style scoped>

    .top {
        position: fixed;
        right: 10px;
        bottom: 10%;
        height:40px;
        width:40px;
        z-index: 999999;
    }

</style>
