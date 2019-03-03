<template>

    <div>

        <!--头部-->
        <van-nav-bar
                title="我的个人设置"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--头像上传-->
        <div style="text-align: center">
            <van-uploader :after-read="onRead">
                <img src="https://x.dscmall.cn/storage/uploads/3488_5c2c153512556.jpeg"
                     style="height: 80px;width: 80px;border-radius: 50%" />
            </van-uploader>
        </div>
        <!--头像上传 end-->

        <!--设置输入区-->
        <van-cell-group style="margin-top: 10px">
            <van-field
                    v-model="form.username"
                    label="昵称"
                    placeholder="请输入用户昵称"
            />
            <van-field
                    v-model="form.desc"
                    label="签名"
                    placeholder="请输入签名"
                    type="textarea"
                    rows="1"
                    autosize
            />
        </van-cell-group>

        <van-cell title="出生日期" :value="birthdate" @click="openTime()"/>

        <van-cell title="性别设置" :value="sex" @click="openSex()"/>

        <!--设置输入区 end-->

        <!--按钮组-->
        <van-row type="flex" justify="space-around" style="margin-top: 15px">
            <van-col span="2"></van-col>
            <van-col span="20">
                <van-button type="danger" size="large">保存</van-button>
            </van-col>
            <van-col span="2"></van-col>
        </van-row>
        <!--按钮组 end-->

        <van-actionsheet
                v-model="show"
                :actions="actions"
        >
            <van-datetime-picker
                    v-model="currentDate"
                    type="date"
                    :min-date="minDate"
                    :max-date="maxDate"
                    @cancel="show = false"
                    @confirm="confirmTime(currentDate)"
            />
        </van-actionsheet>

        <van-actionsheet
                v-model="showSex"
                :actions="actions"
        >
            <van-radio-group v-model="radio">
                <van-cell-group>
                    <van-cell title="保密" clickable @click="radio = '1'">
                        <van-radio name="1" />
                    </van-cell>
                    <van-cell title="男" clickable @click="radio = '2'">
                        <van-radio name="2" />
                    </van-cell>
                    <van-cell title="女" clickable @click="radio = '3'">
                        <van-radio name="3" />
                    </van-cell>
                </van-cell-group>
            </van-radio-group>
            <van-button type="danger" size="large" @click="confirmSex(radio)">确认</van-button>
        </van-actionsheet>

    </div>

</template>

<script>
    export default {
        name: "Setting",
        data() {
            return {
                birthdate: '2002/2/3',
                sex: '保密',
                minDate: new Date(1800,1,1),
                maxDate: new Date(),
                currentDate: new Date(),
                show: false,
                showSex: false,
                actions: [
                    {
                        name: '设置'
                    },
                ],
                radio: '1',
                form: {
                    username: '',
                    desc: '',
                }
            }
        },
        methods: {
            onClickLeft() {
                this.$router.push({
                    name: 'my',
                })
            },
            onRead(file) {
                console.log(file)
            },
            openTime() {
                this.show = true;
            },
            confirmTime(date) {
                this.birthdate = date.toLocaleDateString();
                this.show = false;
            },
            openSex() {
                this.showSex = true;
            },
            confirmSex(radio) {
                switch (radio) {
                    case "1":
                        this.sex = "保密";
                        break;
                    case "2":
                        this.sex = "男";
                        break;
                    case "3":
                        this.sex = "女";
                        break;
                }
                this.showSex = false;
            },
        }
    }
</script>

<style scoped>

</style>
