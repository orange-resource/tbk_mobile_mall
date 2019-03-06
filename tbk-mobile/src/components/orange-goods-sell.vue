<template>

    <div>

        <van-row type="flex" justify="center" style="padding: 10px 0 10px 0;background-color: #fff;margin-top: 5px">
            <van-col span="22" style="display: flex;flex-direction: row">
                <div style="width: 100px;position: relative">
                    <img :src="image"
                         width="100px" height="100px" />
                    <van-tag v-if="tag != null" type="danger" style="position: absolute;top:0;left:0;">{{ tag }}</van-tag>
                </div>
                <div style="flex: auto">
                    <div class="twolist-hidden" style="height: 40px;width: 100%;padding-left: 5px;">
                        <a style="font-size: 14px;color: #4b566a" @click="open()">
                            {{ title }}
                        </a>
                    </div>
                    <div style="margin-top: 10px;padding-left: 5px;">
                        <span style="color: #eb5211;font-size: 16px;">¥{{ price }}</span>
                        <span v-if="originalPrice != null" style="color: #eb5211;font-size: 13px;padding-left: 10px">
                            <s>¥{{ originalPrice }}</s>
                        </span>
                    </div>
                    <van-row type="flex" justify="center" style="background-color: #fff;padding: 5px 0 10px 5px">
                        <van-col span="8">
                            <span v-if="logistics == null" style="color: darkgray;font-size: 13px"></span>
                            <span v-if="logistics != null" style="color: darkgray;font-size: 13px">运费{{ logistics }}</span>
                        </van-col>
                        <van-col span="8" style="text-align: center">
                            <span v-if="payment == null" style="color: darkgray;font-size: 13px">0人付款</span>
                            <span v-if="payment != null" style="color: darkgray;font-size: 13px">{{ payment }}人付款</span>
                        </van-col>
                        <van-col span="8" style="text-align: right">
                            <span v-if="address == null" style="color: darkgray;font-size: 13px"></span>
                            <span v-if="address != null" style="color: darkgray;font-size: 13px">{{ address }}</span>
                        </van-col>
                    </van-row>
                </div>
            </van-col>
        </van-row>

    </div>

</template>

<script>
    export default {
        name: "orange-goods-sell",
        props:[
            "logistics","payment","title","price","originalPrice","address","image","tag","to"
        ],
        methods: {
            open() {
                location.assign(this.to);
            },
        }
    }
</script>

<style scoped>
    .twolist-hidden {
        -webkit-line-clamp: 2;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient: vertical;
    }
</style>
