<template>

    <div style="background-color: #fff">

        <!--头部-->
        <van-nav-bar
                title="修改密码"
                left-text="首页"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--平台logo-->
        <van-row type="flex" justify="center">
            <van-col span="10" style="display: flex;justify-content: center;padding: 1em 0 1em 0;">
                <img src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536793979472.gif"
                     style="border-radius: 50%;box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);"
                     width="80px" height="80px">
            </van-col>
        </van-row>
        <!--平台logo end-->

        <!--输入区-->
        <van-cell-group style="margin-top: 10px">
            <van-field
                    value=""
                    label="手机号"
                    left-icon="phone-o"
            />
        </van-cell-group>
        <van-cell-group>
            <van-field
                    center
                    clearable
                    left-icon="chat-o"
                    label="短信验证码"
                    placeholder="请输入短信验证码"
            >
                <van-button slot="button" size="small" type="primary">发送验证码</van-button>
            </van-field>
        </van-cell-group>
        <van-cell-group>
            <van-field
                    value=""
                    label="新密码"
                    left-icon="more-o"
            />
        </van-cell-group>

        <van-row type="flex" justify="center" style="margin-top: 20px">
            <van-col span="18">
                <van-button type="danger" size="large">修改密码</van-button>
            </van-col>
        </van-row>
        <!--输入区 end-->

        <!--登陆-->
        <van-row type="flex" justify="center" style="margin-top: 2em">
            <van-col span="18" style="text-align: center">
                <span style="color: #f92028;font-weight: 500;font-size: 15px" @click="openLogin()">密码登陆</span>
            </van-col>
        </van-row>
        <!--登陆 end-->

    </div>

</template>

<script>
    export default {
        name: "ForgetPassword",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'home',
                })
            },
            openLogin() {
                this.$router.push({
                    name: "login",
                })
            },
        }
    }
</script>

<style scoped>

</style>
