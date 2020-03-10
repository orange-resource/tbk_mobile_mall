<template>

    <div style="background-color: #fff;height: 100%">

        <div style="background-color: #fff">

            <!--头部-->
            <van-nav-bar
                    :title="data.title"
                    left-text="返回"
                    right-text="我的"
                    left-arrow
                    @click-left="onClickLeft"
                    @click-right="onClickRight"
            />
            <!--头部 end-->

            <van-row type="flex" justify="center" style="padding-top: 20px;padding-bottom: 5px">
                <van-col span="22">
                    <span style="font-weight: 600;font-size: 20px">{{ data.title }}</span>
                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" style="display: flex;flex-direction: row">
                    <div>
                        <van-icon style="color: darkgray;font-size: 13px" name="underway-o" />
                        <span style="color: darkgray;font-size: 13px;margin-left: 3px">
                            {{ data.createDate }}
                        </span>
                    </div>
                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" style="padding-top: 10px;margin-bottom: 20px">
                    <div v-html="data.content" style="width: 100%">

                    </div>
                </van-col>
            </van-row>

            <van-row type="flex" justify="center">
                <van-col span="22" style="text-align: center;padding-bottom: 20px">
                    <span style="color: darkgray;font-size: 13px;">{{ data.author }}</span>
                </van-col>
            </van-row>

        </div>

    </div>

</template>

<script>

    import { time } from "../../static/time";

    export default {
        name: "Article",
        mounted() {

            let url = '';
            if (this.$route.query.type == 1) { //系统消息
                url = 'systemMessage/article';
            } else if (this.$route.query.type == 2) { //新手教程
                url = 'course/article';
            }

            this.$axios.get(url,{
                params: {
                    articleId: this.$route.query.id
                }
            }).then((rsp) => {

                if (rsp.data.code == 9) {
                    rsp.data.data.createDate = time.timeStampDate({
                        time: rsp.data.data.createDate
                    });
                    this.data = rsp.data.data;
                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });
        },
        methods: {
            onClickLeft() {
                this.$router.back(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/my" });
            }
        },
        data() {
            return {
                data: [],
            }
        },
    }
</script>

<style scoped>


</style>
