<template>

    <div class="bc" style="height: 100%">

        <div class="qzqt-home bc">
            <div class="qzqt-content content">

                <!--头部-->
                <div class="head">
                    <img class="head-ortrait" :src="user.headPortrait">
                    <span class="head-name">{{ user.username }}</span>
                    <p class="head-signature">{{ user.desc }}</p>
                </div>
                <!--头部 end-->

                <!--头部紧接-->
                <div class="head-immediately">
                    <div class="head-immediately-common" @click="openCollect()">
                        <span>{{ user.data.collectNumber }}</span>
                        <p>收藏夹</p>
                    </div>
                    <div class="head-immediately-common" @click="openStore()">
                        <span>{{ user.data.attentionNumber }}</span>
                        <p>关注店铺</p>
                    </div>
                    <div class="head-immediately-common" @click="openFootprint()">
                        <span>{{ user.data.footprintNumber }}</span>
                        <p>足迹</p>
                    </div>
                </div>
                <!--头部紧接 end-->

                <!--订单卡片-->
                <div class="order-card">
                    <van-cell-group>
                        <van-cell to="/order/list" title="我的订单" value="全部订单"/>
                    </van-cell-group>
                    <van-tabbar :fixed="false" v-model="active">
                        <van-tabbar-item to="/order/list" icon="after-sale" :info="user.data.obligationNumber">待付款</van-tabbar-item>
                        <van-tabbar-item to="/order/list" icon="bulb-o" :info="user.data.sendGoodNumber">待发货</van-tabbar-item>
                        <van-tabbar-item to="/order/list" icon="logistics" :info="user.data.receivingGoodNumber">待收货</van-tabbar-item>
                        <van-tabbar-item to="/order/list" icon="edit" :info="user.data.evaluateNumber">评价</van-tabbar-item>
                        <van-tabbar-item to="/order/list" icon="service-o" :info="user.data.refundNumber">退款/售后</van-tabbar-item>
                    </van-tabbar>
                </div>
                <!--订单卡片 end-->

                <!--钱包卡片-->
                <div class="order-card">
                    <van-cell-group>
                        <van-cell to="/my/wallet/main" title="我的钱包" value="资金管理"/>
                    </van-cell-group>
                    <div class="head-immediately">
                        <div class="head-immediately-common" @click="openWallet()">
                            <span style="color: red">{{ user.money.balance }}</span>
                            <p>余额</p>
                        </div>
                        <div class="head-immediately-common" @click="openWallet()">
                            <span style="color: red">{{ user.money.redPacket }}</span>
                            <p>红包</p>
                        </div>
                        <div class="head-immediately-common" @click="openWallet()">
                            <span style="color: red">{{ user.money.integral }}</span>
                            <p>积分</p>
                        </div>
                        <div class="head-immediately-common" @click="openCoupons()">
                            <span style="color: red">{{ user.money.coupons }}</span>
                            <p>优惠卷</p>
                        </div>
                    </div>
                </div>
                <!--钱包卡片 end-->

                <!--其余的一个一个的-->
                <div class="other">
                    <van-cell-group>
                        <van-cell to="/shop" icon="shop-collect-o" title="我的店铺" value="" />
                        <van-cell to="/my/setting/main" icon="user-o" title="账户设置" value="" />
                        <van-cell to="/my/address/main" icon="location-o" title="我的收获地址" value="" />
                        <van-cell icon="service-o" title="客服中心" value="" />
                        <van-cell to="/updatePassword" icon="edit" title="修改密码" value="" />
                        <van-cell to="/login" icon="exchange" title="换号登陆" value="" />
                        <van-cell to="/login" icon="share" title="退出系统" value="" />
                    </van-cell-group>
                </div>
                <!--其余的一个一个的 end-->

            </div>
            <qzqt-footer></qzqt-footer>
        </div>

    </div>

</template>

<script>

    export default {
        name: "My",
        mounted() {
        },
        data(){
          return {
              active: -1,

              user: {
                  headPortrait: 'https://x.dscmall.cn/img/user_default.png',
                  username: 'Orange',
                  desc: '不要被人言左右，要相信自己的判断',
                  data: {
                      //收藏夹数量
                      collectNumber: 19,
                      //关注店铺数量
                      attentionNumber: 20,
                      //足迹数量
                      footprintNumber: 30,
                      //待付款数量
                      obligationNumber: 10,
                      //待发货数量
                      sendGoodNumber: 220,
                      //待收货数量
                      receivingGoodNumber: 15,
                      //评价数量
                      evaluateNumber: 60,
                      //退款售后数量
                      refundNumber: 23,
                  },
                  money: {
                      //余额
                      balance: 1.2,
                      //红包
                      redPacket: 4,
                      //积分
                      integral: 100,
                      //优惠卷
                      coupons: 3,
                  }
              }
          }
        },
        methods: {
            open(name) {
                this.$router.push({
                    name: name,
                })
            },
            openCollect() {
                this.open('collect');
            },
            openStore() {
                this.open('store');
            },
            openFootprint() {
                this.open('footprint');
            },
            openWallet() {
                this.open('wallet');
            },
            openCoupons() {
                this.open('coupons');
            },
            openReceiverAddress() {
                this.open('receiverAddress');
            },
        },
    }
</script>

<style scoped>

    .content{
        display: flex;
        flex-direction: column;
        background-color: #F2F6FC;
    }

    .head{
        background: url('../../static/img/bj.png') no-repeat;
        background-size: 100% 100%;
        display: flex;
        height: 180px;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }
    .head-ortrait {
        height: 80px;
        border-radius: 50%;
    }
    .head-name{
        margin-top: 10px;
        color: #ffffff;
        font-size: 15px;
    }
    .head-signature{
        font-size: 10px;
        color: #ffffff;
    }

    .head-immediately{
        display: flex;
        flex-direction: row;
        background-color: #fff;
        padding-top: 10px;
        height: 60px;
    }
    .head-immediately-common{
        display: flex;
        width: 33%;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        font-size: 13px;
    }

    .order-card{
        padding-top: 5px;
    }
    .order-card-content{
        display: flex;
        flex-direction: row;
        padding-bottom: 10px;
    }

    .other{
        padding-top: 5px;
    }

</style>
