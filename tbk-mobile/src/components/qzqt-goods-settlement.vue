<template>

    <!--商品结算-->

    <div>

        <van-row type="flex" justify="center" style="padding: 10px 0 10px 0;background-color: #fff" @click="open()">
            <van-col span="22" style="display: flex;flex-direction: row">
                <div style="width: 100px;position: relative">
                    <img :src="image"
                         width="100px" height="100px" />
                    <van-tag v-if="tag != null" type="danger" style="position: absolute;top:0;left:0;">{{ tag }}</van-tag>
                </div>
                <div style="flex: auto">
                    <div class="twolist-hidden" style="height: 40px;width: 100%;padding-left: 5px;">
                        <a style="font-size: 12px;color: rgb(51, 51, 51);">
                            {{ title }}
                        </a>
                    </div>
                    <div class="twolist-hidden" style="height: 40px;width: 100%;padding-left: 5px;">
                        <a style="font-size: 12px;color: rgb(153, 153, 153);">
                            {{ sku }}
                        </a>
                    </div>
                    <van-row type="flex" justify="center" style="background-color: #fff;padding: 10px 0 10px 5px">
                        <van-col span="8">
                        </van-col>
                        <van-col span="8" style="text-align: center">
                            <span style="color: #eb5211;font-size: 13px;">¥{{ price }}</span>
                        </van-col>
                        <van-col span="8" style="text-align: right">
                            <span style="color: rgb(153, 153, 153);;font-size: 13px">x{{ piece }}</span>
                        </van-col>
                    </van-row>
                </div>
            </van-col>
        </van-row>

    </div>

</template>

<script>
    export default {
        name: "qzqt-goods-settlement",
        props:[
            "title","price","sku","image","tag","to","piece"
        ],
        methods: {
            open() {
                this.$router.push({ path: this.to });
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
