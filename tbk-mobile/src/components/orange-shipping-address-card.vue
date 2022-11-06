<template>

    <!--收货地址卡片-->

    <div>

        <qzqt-card>
            <van-cell class="radius" title="收货信息" value=""/>
            <van-row type="flex" justify="center">
                <van-col span="22" style="display: flex;flex-direction: row;align-items: center;margin-top: 10px">
                    <span style="font-size: 14px;color: #323233;">{{ name }}</span>
                    <span style="font-size: 10px;color: darkgrey;margin-left: 5px">{{ phoneNumber }}</span>
                </van-col>
            </van-row>
            <van-row type="flex" justify="center" style="padding-bottom: 10px">
                <van-col span="22">
                    <span style="font-size: 10px;color: darkgrey;">
                        {{ address }}
                    </span>
                </van-col>
            </van-row>
        </qzqt-card>

    </div>

</template>

<script>
    export default {
        name: "orange-shipping-address-card",
        props:["name","phoneNumber","address"],
    }
</script>

<style scoped>

</style>
