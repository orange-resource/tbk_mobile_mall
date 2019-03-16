"use strict";

import Vue from 'vue';
import axios from "axios";

import { Toast } from 'vant';

Vue.use(Toast);

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

let baseUrl = '';
if (process.env.NODE_ENV == "development") { //测试环境
    baseUrl = "http://localhost/tbk";
} else if (process.env.NODE_ENV == "production") { //发布环境
    baseUrl = "http://tyh.wywxy.top/tbk";
}

let config = {
  baseURL: baseUrl,
  timeout: 60000 * 5, // Timeout
  withCredentials: true, // Check cross-site Access-Control
};

let toast;

const _axios = axios.create(config);

_axios.interceptors.request.use(
  function(config) {
      // Do something before request is sent
      toast = Toast.loading({
          duration: 0,
          mask: true,
          message: '拼命加载中...'
      });
      return config;
  },
  function(error) {
      // Do something with request error
      toast.clear();
      return Promise.reject(error);
  }
);

// Add a response interceptor
_axios.interceptors.response.use(
  function(response) {
      // Do something with response data

      toast.clear();

      return response;
  },
  function(error) {
      toast.clear();
      return Promise.reject(error);
  }
);

Plugin.install = function(Vue, options) {
  Vue.axios = _axios;
  window.axios = _axios;
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios;
      }
    },
    $axios: {
      get() {
        return _axios;
      }
    },
  });
};

Vue.use(Plugin);

export default Plugin;
