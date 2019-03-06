import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
    mode: 'history',
  routes: [
      {
          path: '/',
          name: 'home',
          component: () => import('./views/home/Home.vue')
      },
      {
          path: '/hot',
          name: 'hot',
          component: () => import('./views/hot/Index')
      },
      {
          path: '/discovery',
          name: 'discovery',
          component: () => import('./views/discovery/List')
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
          component: () => import('@/views/goods/Index'),
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
          path: "*",
          redirect: "/"
      }
  ]
})
