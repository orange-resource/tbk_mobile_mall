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
	      path: '/talent',
	      name: 'talent',
	      component: () => import('./views/talent/List.vue')
	  },
	  {
	      path: '/talent/article',
	      name: 'talentArticle',
	      component: () => import('./views/talent/Article.vue')
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
