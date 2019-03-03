<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="我的钱包"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

            <!--资金展示区-->
            <div class="card" style="background-color: #0196fd;">
                <van-row type="flex" style="height: 30px;align-items: center;">
                    <van-col span="1"></van-col>
                    <van-col span="22">
                        <span style="color: #fff;font-weight: 600">可用金额 (元)</span>
                    </van-col>
                    <van-col span="1"></van-col>
                </van-row>
                <van-row type="flex" style="height: 30px;align-items: center;padding-bottom: 20px">
                    <van-col span="1"></van-col>
                    <van-col span="10">
                        <span style="color: #fff;font-weight: 600">0.00</span>
                    </van-col>
                    <van-col span="13" style="text-align: right;margin-right: 5px">
                        <van-tag round type="danger">冻结金额: 0.00</van-tag>
                    </van-col>
                </van-row>
                <van-row type="flex" style="height: 30px;align-items: center;padding-bottom: 10px">
                    <van-col span="1"></van-col>
                    <van-col span="7">
                        <span style="color: #fff;font-weight: 600">红包 0</span>
                    </van-col>
                    <van-col span="8" style="text-align: center">
                        <span style="color: #fff;font-weight: 600">储值卡 0</span>
                    </van-col>
                    <van-col span="7" style="text-align: right">
                        <span style="color: #fff;font-weight: 600">积分 0</span>
                    </van-col>
                    <van-col span="1"></van-col>
                </van-row>
            </div>
            <!--资金展示区 end-->

            <!--充值提现区-->
            <div class="card" style="background-color: #fff">
                <van-row type="flex">
                    <van-col span="12" style="text-align: center;border-right: 1px solid #ddd">
                        <van-button size="small" round type="danger">充值</van-button>
                    </van-col>
                    <van-col span="12" style="text-align: center">
                        <van-button size="small" round type="danger">提现</van-button>
                    </van-col>
                </van-row>
            </div>
            <!--充值提现区 end-->

            <!--其他-->
            <div class="card" style="background-color: #fff;">
                <van-cell value="" icon="shop-o" is-link>
                    <template slot="title">
                        <span class="custom-text">账户明细</span>
                    </template>
                </van-cell>
                <van-cell value="" icon="shop-o" is-link>
                    <template slot="title">
                        <span class="custom-text">申请记录</span>
                    </template>
                </van-cell>
                <van-cell value="" icon="shop-o" is-link>
                    <template slot="title">
                        <span class="custom-text">增值发票</span>
                    </template>
                </van-cell>
            </div>
            <!--其他 end-->

        </div>

    </div>

</template>

<script>
    export default {
        name: "Wallet",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'my',
                })
            },
        }
    }
</script>

<style scoped>
    .card{
        padding-top: 5px;padding-bottom: 5px;
        margin: 1em 1em 1em 1em;
        border-radius: 5px;
    }
</style>
