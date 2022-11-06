<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="新手教程"
                    left-text="返回"
                    right-text="我的"
                    left-arrow
                    @click-left="onClickLeft"
                    @click-right="onClickRight"
            />
            <!--头部 end-->

            <orange-article-card
                    v-for="(single,index) in list"
                    :key="index"
                    :title="single.title"
                    :author="single.author"
                    :date="single.createDate"
                    :image="single.image"
                    :to='"/my/msg/article?type=2&id=" + single.id'
                    style="margin-top: 10px"
            ></orange-article-card>

        </div>

    </div>

</template>

<script>

    import { time } from "../../static/time";

    export default {
        name: "MsgList",
        mounted() {
            this.$axios.get('course/list').then((rsp) => {

                if (rsp.data.code == 9) {
                    for (let i = 0;i < rsp.data.data.length;i++) {
                        rsp.data.data[i].createDate = time.timeStampDate({
                            time: rsp.data.data[i].createDate
                        });
                        this.list.push(rsp.data.data[i]);
                    }
                } else {
                    this.$alert.notifyNoData(rsp.data.msg);
                }

            }).catch((e) => {
                this.$alert.dialogUnknown(e);
            });
        },
        data() {
            return {
                list: [],
            }
        },
        methods: {
            onClickLeft() {
                this.$router.back(-1);
            },
            onClickRight() {
                this.$router.push({ path: "/my" });
            },
        },
    }
</script>

<style scoped>
</style>
