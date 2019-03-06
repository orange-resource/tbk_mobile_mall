<template>

	<div class="bc" style="height: 100%">

		<div class="orange-home">

			<div v-if="isPageLoadComplete == 0 || isPageLoadComplete == 1" class="orange-content content">
				<orange-loading :show="isPageLoadComplete"></orange-loading>
			</div>

			<div v-if="isPageLoadComplete == 2" class="orange-content content">

				<!--头部-->
				<van-nav-bar title="发现好物"></van-nav-bar>

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
