<template>

    <!--精选商品封装-->
    <div>

        <orange-card>

            <!--头部标题介绍-->
            <van-row type="flex">
                <van-col span="4">
                    <img class="headImage" src="../static/img/tou.jpg" />
                </van-col>
                <van-col span="20" class="box-name">
                    <span class="name">
                        淘优惠
                    </span>
                    <span class="total">
                        已被分享{{ total }}次
                    </span>
                </van-col>
            </van-row>

            <!--短文-->
            <van-row type="flex" justify="center">
                <van-col span="22">
                    <div class="content" v-html="content">

                    </div>
                </van-col>
            </van-row>

            <!--图片-->
            <van-row type="flex" justify="center">
                <van-col span="22">
                    <div v-for="(g,index) in goods" :key="index" class="box-float">
                        <img class="image" :src="g.image" @click="openGoods(g.to)"/>
                        <van-tag style="position: absolute; bottom: 0; left: 0;" type="danger">{{ g.price }}</van-tag>
                    </div>
                </van-col>
            </van-row>

            <!--底部-->
            <van-row type="flex" justify="center">
                <van-col span="22" class="box-footer">
                    <span class="time">{{ showTime | formatDate }}</span>
                </van-col>
            </van-row>

        </orange-card>

    </div>

</template>

<script>

    export default {
        name: "orange-handpick",
        props:[
            "total",
            "content",
            "goods",
            "showTime",
            "price",
        ],
        methods: {
            openGoods(to) {
                this.$router.push({ path: to });
            },
        },
        filters: {
            formatDate: function (value) {
                value = parseInt(value + "000");
                let date = new Date(value);
                let y = date.getFullYear();
                let MM = date.getMonth() + 1;
                MM = MM < 10 ? ('0' + MM) : MM;
                let d = date.getDate();
                d = d < 10 ? ('0' + d) : d;
                let h = date.getHours();
                h = h < 10 ? ('0' + h) : h;
                let m = date.getMinutes();
                m = m < 10 ? ('0' + m) : m;
                let s = date.getSeconds();
                s = s < 10 ? ('0' + s) : s;
                return y + '-' + MM + '-' + d + ' ' + h + ':' + m + ':' + s;
            }
        }
    }
</script>

<style scoped>

    .headImage {
        height: 40px;
        width: 40px;
        border-radius: 50%;
        padding: 5px 5px 0 10px;
    }

    .name {
        font-size: 15px;
        color: #999999;
    }

    .total {
        font-size: 10px;
        color: #999999;
        padding-left: 5px;
    }

    .box-name {
        display:flex;
        align-items: center;
    }

    .content {
        font-size: 15px;
    }

    .box-float {
        float: left;
        position: relative;
        padding-top: 5px;
        padding-left: 5px;
    }

    .image {
        height: 100px;
        width: 100px;
    }

    .time {
        font-size: 15px;
        color: #999999;
    }

    .box-footer {
        margin-bottom: 5px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

</style>
