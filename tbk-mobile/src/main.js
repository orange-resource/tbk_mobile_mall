import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import './plugins/axios'
import './plugins/vant'
import './plugins/qs'
import './plugins/vue-error'

//公共样式
import './static/css/layout.css'
import './static/css/common.css'

//引入自有组件
import './plugins/qzqt'
import './plugins/orange'

Vue.config.productionTip = false;



new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
