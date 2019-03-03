<template>

    <div style="background-color: #fff">

        <!--头部-->
        <van-nav-bar
                title="注册"
                left-text="首页"
                left-arrow
                @click-left="onClickLeft"
        />
        <!--头部 end-->

        <!--平台logo-->
        <van-row type="flex" justify="center">
            <van-col span="10" style="display: flex;justify-content: center;padding: 1em 0 1em 0;">
                <img src="https://x.dscmall.cn/storage/data/gallery_album/108/original_img/108_P_1536793979472.gif"
                     style="border-radius: 50%;box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);"
                     width="80px" height="80px">
            </van-col>
        </van-row>
        <!--平台logo end-->

        <!--注册区-->
        <van-cell-group style="margin-top: 10px">
            <van-field
                    value=""
                    label="用户名"
                    left-icon="contact"
            />
        </van-cell-group>
        <van-cell-group>
            <van-field
                    value=""
                    label="密码"
                    left-icon="more-o"
            />
        </van-cell-group>
        <van-cell-group>
            <van-field
                    value=""
                    label="手机号"
                    left-icon="phone-o"
            />
        </van-cell-group>
        <van-cell-group>
            <van-field
                    center
                    clearable
                    left-icon="chat-o"
                    label="短信验证码"
                    placeholder="请输入短信验证码"
            >
                <van-button slot="button" size="small" type="primary">发送验证码</van-button>
            </van-field>
        </van-cell-group>

        <van-row type="flex" justify="end">
            <van-col span="24" style="padding: 1em 1em 1.3em 0;display: flex;flex-direction: row;
            align-items: center;justify-content: flex-end">
                <van-checkbox v-model="checked" style="color: #4b89dc;font-size: 15px;padding-left: 5px"></van-checkbox>
                <span style="color: #4b89dc;font-size: 15px;padding-left: 5px" @click="openAgreement()">用户协议</span>
            </van-col>
        </van-row>

        <van-row type="flex" justify="center">
            <van-col span="18">
                <van-button type="danger" size="large">注册</van-button>
            </van-col>
        </van-row>
        <!--注册区 end-->

        <!--登陆-->
        <van-row type="flex" justify="center" style="margin-top: 2em">
            <van-col span="18" style="text-align: center">
                <span style="color: #f92028;font-weight: 500;font-size: 15px" @click="openLogin()">密码登陆</span>
            </van-col>
        </van-row>
        <!--登陆 end-->

        <!--用户协议-->
        <van-popup v-model="show" position="right" :overlay="false" style="width: 100%;height: 100%;position: absolute">

            <van-nav-bar
                    title="用户协议"
                    left-text="返回"
                    left-arrow
                    @click-left="show = false"
            />

            <span v-html="desc">

            </span>

        </van-popup>
        <!--用户协议 end-->

    </div>

</template>

<script>
    export default {
        name: "Register",
        data() {
            return {
                checked: false,
                show: false,
                desc:'用户协议\n' +
                    '特别提示\n' +
                    '北京陌陌科技有限公司（以下简称“陌陌科技”）在此特别提醒您（用户）在注册成为用户之前，请认真阅读本《用户协议》（以下简称“协议”），确保您充分理解本协议中各条款。请您审慎阅读并选择接受或不接受本协议。除非您接受本协议所有条款，否则您无权注册、登录或使用本协议所涉服务。您的注册、登录、使用等行为将视为对本协议的接受，并同意接受本协议各项条款的约束。\n' +
                    '\n' +
                    '本协议约定陌陌科技与用户之间关于“陌陌”软件服务（以下简称“服务”）的权利义务。“用户”是指注册、登录、使用本服务的个人。本协议可由陌陌科技随时更新，更新后的协议条款一旦公布即代替原来的协议条款，恕不再另行通知，用户可在本网站查阅最新版协议条款。在陌陌科技修改协议条款后，如果用户不接受修改后的条款，请立即停止使用陌陌科技提供的服务，用户继续使用陌陌科技提供的服务将被视为接受修改后的协议。\n' +
                    '\n' +
                    '一、帐号注册\n' +
                    '1、用户在使用本服务前需要注册一个“陌陌”帐号。“陌陌”帐号应当使用手机号码绑定注册，请用户使用尚未与“陌陌”帐号绑定的手机号码，以及未被陌陌科技根据本协议封禁的手机号码注册“陌陌”帐号。陌陌科技可以根据用户需求或产品需要对帐号注册和绑定的方式进行变更，而无须事先通知用户。\n' +
                    '\n' +
                    '2、“陌陌”系基于地理位置的移动社交产品，用户注册时应当授权陌陌科技公开及使用其地理位置信息方可成功注册“陌陌”帐号。故用户完成注册即表明用户同意陌陌科技提取、公开及使用用户的地理位置信息。如用户需要终止向其他用户公开其地理位置信息，可自行设置为隐身状态。\n' +
                    '\n' +
                    '3、鉴于“陌陌”帐号的绑定注册方式，您同意陌陌科技在注册时将使用您提供的手机号码及/或自动提取您的手机号码及自动提取您的手机设备识别码等信息用于注册。您同意给予运营商授权，授权运营商有权自动提取您的手机号码进行认证并用于“陌陌”账号注册，您保证遵守运营商的相关服务条款（点击查看服务条款），如运营商对您的手机号认证成功，则您的注册即完成。如您不同意对运营商的授权和/或服务条款或者是您的手机号认证失败，您可以手动修改运营商提取的手机号码，采取验证码方式进行注册登录。\n' +
                    '\n' +
                    '4、在用户注册及使用本服务时，陌陌科技需要搜集能识别用户身份的个人信息以便陌陌科技可以在必要时联系用户，或为用户提供更好的使用体验。陌陌科技搜集的信息包括但不限于用户的姓名、性别、年龄、出生日期、身份证号、地址、学校情况、公司情况、所属行业、兴趣爱好、常出没的地方、个人说明；陌陌科技同意对这些信息的使用将受限于第三条用户个人隐私信息保护的约束。\n' +
                    '\n' +
                    '二、服务内容\n' +
                    '1、本服务的具体内容由陌陌科技根据实际情况提供，包括但不限于授权用户通过其帐号进行即时通讯、添加好友、加入群组、关注他人、发布留言。陌陌科技可以对其提供的服务予以变更，且陌陌科技提供的服务内容可能随时变更；用户将会收到陌陌科技关于服务变更的通知。\n' +
                    '\n' +
                    '2、陌陌科技提供的服务包含免费服务与收费服务。用户可以通过付费方式购买收费服务，具体方式为：用户通过网上银行、支付宝或其他“陌陌”平台提供的付费途径支付一定数额的人民币购买“陌陌”平台的虚拟货币——陌陌币，然后根据陌陌科技公布的资费标准以陌陌币购买用户欲使用的收费服务，从而获得收费服务使用权限。对于收费服务，陌陌科技会在用户使用之前给予用户明确的提示，只有用户根据提示确认其同意按照前述支付方式支付费用并完成了支付行为，用户才能使用该等收费服务。支付行为的完成以银行或第三方支付平台生成“支付已完成”的确认通知为准。',
            };
        },
        methods: {
            openLogin() {
                this.$router.push({
                    name: "login",
                })
            },
            onClickLeft() {
                this.$router.push({
                    name: 'home',
                })
            },
            openAgreement() {
                this.show = true
            },
        }
    }
</script>

<style scoped>

</style>
