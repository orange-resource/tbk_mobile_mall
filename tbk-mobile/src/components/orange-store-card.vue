<template>

    <div>

        <van-row type="flex" justify="center" style="padding: 1em 0 1em 0;background-color: #fff">
            <van-col span="15" style="display: flex;flex-direction: row;">
                <img :src="logo"
                     width="64px" height="64px" style="border: 1px solid darkgrey">
                <div style="display: flex;flex-direction: column;padding-left: 10px">
                    <span style="font-size: 15px">{{ name }}</span>
                    <span style="color: #999;font-size: 13px;margin-top: 5px">
                               已经有{{ attention }}人关注
                    </span>
                    <div style="display: flex;flex-direction: row;padding-top: 5px">
                        <van-icon name="star-o" />
                        <van-icon name="star-o" />
                        <van-icon name="star-o" />
                    </div>
                </div>
            </van-col>
            <van-col span="7" style="display: flex;justify-content: flex-end;align-items: center">
                <van-button v-if="isAttention == 0" round type="danger" plain size="small">未关注</van-button>
                <van-button v-if="isAttention == 1" round type="danger" plain size="small">已关注</van-button>
            </van-col>
        </van-row>

    </div>

</template>

<script>
    export default {
        name: "orange-store-card",
        props: ["logo","name","attention","isAttention","to"],
    }
</script>

<style scoped>

</style>
