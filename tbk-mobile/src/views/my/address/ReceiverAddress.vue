<template>

    <div>

        <!--头部-->
        <van-nav-bar
                title="我的收货地址"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--地址-->
        <van-address-list
                v-model="chosenAddressId"
                :list="list"
                :disabled-list="disabledList"
                disabled-text="以下地址超出配送范围"
                @add="onAdd"
                @edit="onEdit"
        />
        <!--地址 end-->

    </div>

</template>

<script>
    export default {
        name: "HarvestAddress",
        data() {
            return {
                chosenAddressId: '1',
                list: [
                    {
                        id: '1',
                        name: '张三',
                        tel: '13000000000',
                        address: '浙江省杭州市西湖区文三路 138 号东方通信大厦 7 楼 501 室'
                    },
                    {
                        id: '2',
                        name: '李四',
                        tel: '1310000000',
                        address: '浙江省杭州市拱墅区莫干山路 50 号'
                    },
                    {
                        id: '3',
                        name: '李四',
                        tel: '1310000000',
                        address: '浙江省杭州市拱墅区莫干山路 50 号'
                    },
                    {
                        id: '4',
                        name: '李四',
                        tel: '1310000000',
                        address: '浙江省杭州市拱墅区莫干山路 50 号'
                    },
                ],
                disabledList: [
                ]
            }
        },
        methods: {
            open(name) {
                this.$router.push({
                    name: name,
                })
            },
            onClickLeft() {
                this.$router.push({
                    name: 'my',
                })
            },
            onAdd() {
                this.$toast('新增地址');
                this.open("receiverAddressForm");
            },

            onEdit(item, index) {
                this.$toast('编辑地址:' + index);
                this.open("receiverAddressForm");
            },
        }
    }
</script>

<style scoped>

</style>
