<template>

	<div class="bc" style="height: 100%">

		<div class="qzqt-home bc">

			<div class="qzqt-content content">

				<van-nav-bar title="达人说"></van-nav-bar>

				<div style="height: 200px;" class="head">

					<div class="slide-box">
						<qzqt-card class="slide-item radius"></qzqt-card>
						<qzqt-card class="slide-item radius"></qzqt-card>
						<qzqt-card class="slide-item radius"></qzqt-card>
					</div>

				</div>



			</div>


		</div>

		<div class="footer">
		    <qzqt-footer></qzqt-footer>
		</div>


	</div>

</template>

<script>

	export default {
	    name: "Card",
		mounted() {
			this.$axios.get('talent/getAll').then((rsp) => {
				if (rsp.data.code == 1) {
				    
				} else {
					this.$notify('数据获取异常，请重新刷新页面');
				}
			})
		},
	    data() {
	        return {
	        }
	    },
	    methods: {
	    }
	}

</script>

<style>
	.slide-box{
            display: -webkit-box;
            overflow-x: scroll;
            -webkit-overflow-scrolling:touch;
        }
    .slide-item{
        width: 250px;
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
