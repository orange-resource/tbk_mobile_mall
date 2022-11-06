
import Vue from 'vue'

import { Dialog,Notify } from 'vant';

Vue.use(Dialog);
Vue.use(Notify);

var alert = {

    dialogUnknown: function (msg) {
        msg = msg || '';
        let content = '哎呀！我的天爷呀！发生了未知错误！\n';
        content+='错误原因如下：\n';
        content+='1.系统错误\n';
        content+='2.网络连接可能断掉\n';
        content+='解决方案：重新刷新页面试试\n';
        content+=msg;
        Dialog.alert({
            title: '处理提示',
            message: content
        }).then(() => {
        });
    },

    notifyNoData: function (msg) {
        Notify('数据获取完毕');
    }

};

Vue.prototype.$alert = alert;
