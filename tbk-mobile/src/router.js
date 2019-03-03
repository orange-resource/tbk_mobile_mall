import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
  routes: [
      {
          path: '/',
          name: 'home',
          component: () => import('./views/home/Home.vue')
      },
      {
          path: '/category',
          name: 'category',
          component: () => import('./views/category/Category.vue')
      },
      {
          path: '/cart',
          name: 'cart',
          component: () => import('./views/cart/Cart.vue')
      },
      {
          path: '/cart/settlement',
          name: 'cartSettlement',
          component: () => import('./views/cart/Settlement.vue')
      },
      {
          path: '/my',
          name: 'my',
          component: () => import('@/views/my/My.vue'),
      },
      {
          path: '/my/collect',
          name: 'collect',
          component: () => import('@/views/my/Collect.vue'),
      },
      {
          path: '/my/store',
          name: 'store',
          component: () => import('@/views/my/Store.vue'),
      },
      {
          path: '/my/footprint',
          name: 'footprint',
          component: () => import('@/views/my/Footprint.vue'),
      },
      {
          path: '/my/wallet/main',
          name: 'wallet',
          component: () => import('@/views/my/wallet/Wallet.vue'),
      },
      {
          path: '/my/wallet/coupons',
          name: 'coupons',
          component: () => import('@/views/my/wallet/Coupons.vue'),
      },
      {
          path: '/my/address/main',
          name: 'receiverAddress',
          component: () => import('@/views/my/address/ReceiverAddress.vue'),
      },
      {
          path: '/my/address/receiverAddress/form',
          name: 'receiverAddressForm',
          component: () => import('@/views/my/address/ReceiverAddressForm.vue'),
      },
      {
          path: '/my/setting/main',
          name: 'setting',
          component: () => import('@/views/my/setting/Setting.vue'),
      },
      {
          path: '/goods',
          name: 'goods',
          component: () => import('@/views/goods/Goods.vue'),
      },
      {
          path: '/shop',
          name: 'shop',
          component: () => import('@/views/shop/Shop.vue'),
      },
      {
          path: '/shop/details',
          name: 'shopDetails',
          component: () => import('@/views/shop/Details.vue'),
      },
      {
          path: '/login',
          name: 'login',
          component: () => import('@/views/user/Login.vue'),
      },
      {
          path: '/register',
          name: 'register',
          component: () => import('@/views/user/Register.vue'),
      },
      {
          path: '/forgetPassword',
          name: 'forgetPassword',
          component: () => import('@/views/user/ForgetPassword.vue'),
      },
      {
          path: '/updatePassword',
          name: 'updatePassword',
          component: () => import('@/views/user/UpdatePassword.vue'),
      },
      {
          path: '/article/list',
          name: 'articleList',
          component: () => import('@/views/article/List.vue'),
      },
      {
          path: '/article/main',
          name: 'articleMain',
          component: () => import('@/views/article/Article.vue'),
      },
      {
          path: '/search/main',
          name: 'searchMain',
          component: () => import('@/views/search/Search.vue'),
      },
      {
          path: '/search/goods',
          name: 'searchGoods',
          component: () => import('@/views/search/SearchGoods.vue'),
      },
      {
          path: '/order/list',
          name: 'orderList',
          component: () => import('@/views/order/List.vue'),
      },
      {
          path: '/order/main',
          name: 'orderMain',
          component: () => import('@/views/order/Order.vue'),
      },
  ]
})
