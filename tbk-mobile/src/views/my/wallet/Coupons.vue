<template>

    <div>

        <!--头部-->
        <van-nav-bar
                title="我的优惠卷"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--优惠卷单元格-->
        <van-coupon-cell
                :coupons="coupons"
                :chosen-coupon="chosenCoupon"
                @click="showList = true"
        />
        <!--优惠卷单元格 end-->

        <!--优惠卷展示区-->
        <van-popup v-model="showList" position="bottom">
            <van-coupon-list
                    :coupons="coupons"
                    :chosen-coupon="chosenCoupon"
                    :disabled-coupons="disabledCoupons"
                    @change="onChange"
                    @exchange="onExchange"
            />
        </van-popup>
        <!--优惠卷展示区 end-->

    </div>

</template>

<script>

    const coupon = {
        available: 1,
        discount: 0,
        denominations: 150,
        originCondition: 0,
        reason: '',
        value: 150,
        name: '优惠券名称',
        startAt: 1489104000,
        endAt: 1514592000
    };


    export default {
        name: "Coupons",
        data() {
            return {
                showList: true,
                chosenCoupon: -1,
                coupons: [coupon],
                disabledCoupons: [coupon]
            }
        },
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'my',
                })
            },
            onChange(index) {
                this.showList = false;
                this.chosenCoupon = index;
            },
            onExchange(code) {
                this.coupons.push(coupon);
            },
        }
    }
</script>

<style scoped>

</style>
