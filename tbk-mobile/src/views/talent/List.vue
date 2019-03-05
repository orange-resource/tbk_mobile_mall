<template>

	<div class="bc" style="height: 100%">

		<div class="orange-home">

			<div v-if="isPageLoadComplete == 0 || isPageLoadComplete == 1" class="orange-content content">
				<orange-loading :show="isPageLoadComplete"></orange-loading>
			</div>

			<div v-if="isPageLoadComplete == 2" class="orange-content content">

				<!--头部-->
				<van-nav-bar title="达人说"></van-nav-bar>

				<!--头部滑动卡片-->
				<div style="height: 200px;" class="head">

					<div class="slide-box">
						<orange-card v-for="(i,index) in topdata" :key="'q' + index" style="position: relative;" class="slide-item radius">
							<img :src="i.article_banner"
								 class="radius" width="100%" height="100%" alt="图片被橘子酸到火星了..."
								 @click="openArticle(i.id)"
							/>
							<van-tag style="position: absolute; bottom: 0; left: 0;" type="danger">{{i.shorttitle}}</van-tag>
						</orange-card>
					</div>

				</div>

				<!--中部-->
				<van-tabs>
					<van-tab title="最新文章">
						<orange-goods-card
								v-for="(i,index) in newdata"
								:key="'w' + index"
								topTag="最新"
								:title="i.name"
								:image="i.image"
								:to='"talent/article?id=" + i.id'
								style="margin-top: 10px"
						></orange-goods-card>
					</van-tab>
					<van-tab v-for="(list,inde) in clickdata" :key="inde" :title="list.name">
						<orange-goods-card
								v-for="(i,ind) in list.data"
								:key="'e' + ind"
								:topTag="list.name"
								:title="i.name"
								:image="i.image"
								:to='"talent/article?id=" + i.id'
								style="margin-top: 10px"
						></orange-goods-card>
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

            this.$axios.get('talent/getAll').then((rsp) => {
                if (rsp.data.code == 1) {
                    this.topdata = rsp.data.data.topdata;
                    this.newdata = rsp.data.data.newdata;
                    for (let i = 0;i < rsp.data.data.clickdata.length;i++) {
                        for (let p = 0;p < 4;p++) {
                            if (rsp.data.data.clickdata[i].talentcat == p+1) {
                                this.clickdata[p].data.push(rsp.data.data.clickdata[i]);
                            }
                        }
                    }
                    this.isPageLoadComplete = 2;
                } else {
                    this.isPageLoadComplete = 1;
                    this.$alert.notifyNoData();
                }
            }).catch((e) => {
                this.$alert.dialogUnknown(e);
                this.isPageLoadComplete = 1;
			})
		},
	    data() {
	        return {
	            isPageLoadComplete: 0, //页面是否加载完成 0.正在加载 1.加载失败 2.加载完毕 ...
                topdata: [],
                newdata: [],
                clickdata: [ //1.好物,2.潮流,3.美食,4.生活
                    {
                        name: '好物',
						data: [],
					},
                    {
                        name: '潮流',
                        data: [],
					},
                    {
                        name: '美食',
                        data: [],
					},
                    {
                        name: '生活',
                        data: [],
					},
				],
            }
	    },
	    methods: {
            openArticle(articleId) {
                this.$router.push({ path: 'talent/article?id=' + articleId });
			},
	    }
	}

</script>

<style>
    .slide-item{
        width: 300px;
        height: 150px;
        border:3px solid #ccc;
        margin-right: 30px;
		margin-left: 10px;
    }
	.head{
        background: url('../../static/img/bj.png') no-repeat;
        background-size: 100% 100%;
		display: flex;
		justify-content: center;
		align-items: center;
    }
</style>
