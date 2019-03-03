<template>

    <div>

        <div
             style="float: left;width: 50%;background-color: #fff;" @click="open()">
            <div style="padding: .3em .3em .3em;position: relative">
                <img :src="image"
                width="100%" height="180px" style="border-radius: 5px;"/>
                <van-tag v-if="bottomTag != null" type="danger" style="position: absolute;bottom:0;right:0">
                    {{ bottomTag }}
                </van-tag>
                <van-tag v-if="topTag != null" type="danger" style="position: absolute;top:0;left:0">
                    {{ topTag }}
                </van-tag>
            </div>
            <div style="text-align: center;">
                <a class="twolist-hidden" style="height: 45px">
                    {{ title }}
                </a>
                <div class="twolist-hidden" style="padding: .3em .3em .3em .3em;color: red;display: flex;flex-direction: row;justify-content: center">
                    <van-tag v-if="priceTag != null" type="danger" style="margin-right: 3px">
                        {{ priceTag }}
                    </van-tag>
                    <div v-if="price != null">
                        ¥{{ price }}
                    </div>
                </div>
            </div>
        </div>

    </div>

</template>

<script>
    export default {
        name: "qzqt-goods-card",
        props:[
            "bottomTag","topTag","title","price","priceTag","image","to"
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
