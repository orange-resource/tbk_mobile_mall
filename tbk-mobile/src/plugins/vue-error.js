
import Vue from 'vue';
import { Dialog } from 'vant';

Vue.use(Dialog);

Vue.config.errorHandler = function (err, vm, info) {

    Dialog.alert({
        title: '系统提示',
        message: '哎呀我的天！发生了未知错误\n' + err
    }).then(() => {
        // on close
    });

};
