<template>

	<div class="bc" style="height: 100%">

		<div class="orange-home bc">

			<div class="orange-content content">

				<!--头部-->
				<van-nav-bar title="发现好物"></van-nav-bar>

				<!--中间-->
				<van-tabs type="card">
					<van-tab title="精选单品">

						<van-list
								v-model="handpickLoad.loading"
								:finished="handpickLoad.finished"
								finished-text="没有更多数据了..."
								@load="handpickOnLoad()"
						>
							<orange-handpick
									v-for="(h,index) in handpick"
									:key="index"
									:total="h.dummy_click_statistics"
									:content="h.show_content"
									:images="h.itempic"
									:showTime="h.show_time"
									:to='"goods?id=" + h.itemid'
							></orange-handpick>
						</van-list>

					</van-tab>
					<van-tab title="好货专场">

						<van-list
								v-model="newsLoad.loading"
								:finished="newsLoad.finished"
								finished-text="没有更多数据了..."
								@load="newsOnLoad()"
						>
							<orange-news
									v-for="(h,index) in news"
									:key="'news' + index"
									:total="h.share_times"
									:content="h.show_text"
									:showTime="h.activity_start_time"
									:goods="h.goods"
							></orange-news>
						</van-list>

					</van-tab>
					<van-tab title="趣味发圈">

					</van-tab>
				</van-tabs>

				<!--底部-->
				<orange-technology-footer style="clear: both"></orange-technology-footer>

			</div>


		</div>

		<div class="footer">
		    <orange-footer></orange-footer>
		</div>

	</div>

</template>

<script>

	export default {
	    name: "Card",
		mounted() {
		},
	    data() {
	        return {
	            handpick: [],
				handpickLoad: {
                    loading: false,
                    finished: false,
					total: 0,
				},
	            news: [],
				newsLoad: {
                    loading: false,
                    finished: false,
					total: 0,
				},
            }
	    },
	    methods: {
            handpickOnLoad() {
                this.getHandpick(this.handpickLoad.total+=1);
			},
			getHandpick(page) { //获取精选商品数据
                this.$axios.get('discovery/handpick',{
                    params: {
                        page: page,
					}
				}).then((rsp) => {
                    if (rsp.data.code == 1) {
                        for (let i = 0;i < rsp.data.data.length;i++) {
                            this.handpick.push(rsp.data.data[i]);
                        }
                        this.handpickLoad.loading = false;
                    } else {
                        this.handpickLoad.finished  = true;
                    }
                }).catch((e) => {
                    this.$alert.dialogUnknown(e);
                })
			},
            newsOnLoad() {
                this.getNews(this.newsLoad.total+=1);
			},
			getNews(page) { //获取精选商品数据
                this.$axios.get('discovery/news',{
                    params: {
                        page: page,
					}
				}).then((rsp) => {
                    if (rsp.data.code == 1) {
                        for (let i = 0;i < rsp.data.data.length;i++) {

                            rsp.data.data[i].goods = [];
                            let itemData = rsp.data.data[i].item_data;
                            for (let p = 0;p < itemData.length;p++) {
                                rsp.data.data[i].goods.push({
                                    image: itemData[p].itempic,
                                    price: '卷后价格' + itemData[p].itemendprice,
                                    to: "goods?id=" + itemData[p].itemid,
                                });
							}

                            this.news.push(rsp.data.data[i]);
                        }
                        this.newsLoad.loading = false;
                    } else {
                        this.newsLoad.finished  = true;
                    }
                }).catch((e) => {
                    this.$alert.dialogUnknown(e);
                })
			},
	    }
	}

</script>

<style>
</style>
