<template>

    <div class="bc" style="height: 100%">

        <div class="bc">

            <!--头部-->
            <van-nav-bar
                    title="雅雅DIY服装辅料"
                    left-text="返回"
                    left-arrow
                    @click-left="onClickLeft"
            />
            <!--头部 end-->

           <div style="background-color: #fff">

               <qzqt-store-card
                       logo="https://x.dscmall.cn/storage/seller_imgs/seller_logo/logo_thumb/1490153973737916372.jpg"
                       name="绿联"
                       attention="104325"
                       isAttention=0
               ></qzqt-store-card>

               <van-row type="flex" justify="center" style="padding-bottom: 10px">
                   <van-col span="7" style="display: flex;flex-direction: row">
                       <van-tag plain round type="danger" style="font-size: 13px">
                           商品 5分 高
                       </van-tag>
                   </van-col>
                   <van-col span="8" style="text-align: center">
                       <van-tag plain round type="primary" style="font-size: 13px">
                           商品 5分 高
                       </van-tag>
                   </van-col>
                   <van-col span="7" style="text-align: right">
                       <van-tag plain round type="success" style="font-size: 13px">
                           商品 5分 高
                       </van-tag>
                   </van-col>
               </van-row>

               <van-row type="flex" justify="center">
                   <van-col span="24">
                       <hr class="hr">
                   </van-col>
               </van-row>

               <van-row type="flex" justify="center" style="padding-bottom: 10px">
                   <van-col span="7" style="display: flex;flex-direction: column;align-items: center;">
                       <span style="font-size: 20px">10</span>
                       <span style="font-size: 10px;color: darkgrey">全部商品</span>
                   </van-col>
                   <van-col span="8" style="display: flex;flex-direction: column;align-items: center;">
                       <span style="font-size: 20px">0</span>
                       <span style="font-size: 10px;color: darkgrey">新品</span>
                   </van-col>
                   <van-col span="7" style="display: flex;flex-direction: column;align-items: center;">
                       <span style="font-size: 20px">2</span>
                       <span style="font-size: 10px;color: darkgrey">促销</span>
                   </van-col>
               </van-row>

           </div>

            <div style="background-color: #fff;margin-top: 10px">

                <van-row type="flex" justify="center">
                    <van-col span="24">
                        <van-cell title="在线客服" value="联系" icon="location-o" />
                        <van-cell title="店铺二维码" value="展示" icon="location-o" />
                        <van-cell title="商家电话" value="打call" icon="location-o" />
                    </van-col>
                </van-row>

            </div>


            <div style="background-color: #fff;margin-top: 10px">

                <van-row type="flex" justify="center">
                    <van-col span="24">
                        <van-cell title="公司简介" />
                        <van-cell value="">
                            <template slot="title">
                                <span class="custom-text">公司名称 : </span>
                                <van-tag>绿联有限公司</van-tag>
                            </template>
                        </van-cell>
                        <van-cell value="">
                            <template slot="title">
                                <span class="custom-text">所在地区 : </span>
                                <van-tag>福建泉州</van-tag>
                            </template>
                        </van-cell>
                        <van-cell value="">
                            <template slot="title">
                                <span class="custom-text">主营品牌 : </span>
                                <van-tag>绿联</van-tag>
                            </template>
                        </van-cell>
                    </van-col>
                </van-row>

            </div>

        </div>

    </div>

</template>

<script>
    export default {
        name: "Details",
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'shop',
                })
            },
        }
    }
</script>

<style scoped>

</style>
