import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
    mode: 'history',
  routes: [
      {
          path: '/',
          name: 'home',
          component: () => import('./views/home/Home')
      },
      {
          path: '/home/district',
          name: 'homeDistrict',
          component: () => import('./views/home/District')
      },
      {
          path: '/home/brand',
          name: 'homeBrand',
          component: () => import('./views/home/Brand')
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
          path: '/discovery/theme',
          name: 'discoveryTheme',
          component: () => import('./views/discovery/Theme')
      },
	  {
	      path: '/talent',
	      name: 'talent',
	      component: () => import('./views/talent/List')
	  },
	  {
	      path: '/talent/article',
	      name: 'talentArticle',
	      component: () => import('./views/talent/Article')
	  },
      {
          path: '/my',
          name: 'my',
          component: () => import('./views/my/My')
      },
      {
          path: '/my/footprint',
          name: 'myFootprint',
          component: () => import('./views/my/Footprint')
      },
      {
          path: '/my/collect',
          name: 'myCollect',
          component: () => import('./views/my/Collect')
      },
      {
          path: '/goods',
          name: 'goods',
          component: () => import('@/views/goods/Index'),
      },
      {
          path: '/article/list',
          name: 'articleList',
          component: () => import('@/views/article/List'),
      },
      {
          path: '/article/main',
          name: 'articleMain',
          component: () => import('@/views/article/Article'),
      },
      {
          path: '/search/main',
          name: 'searchMain',
          component: () => import('@/views/search/Search'),
      },
      {
          path: '/search/goods',
          name: 'searchGoods',
          component: () => import('@/views/search/SearchGoods'),
      },
      {
          path: '/error/404',
          name: '404',
          component: () => import('@/views/error/404'),
      },
      {
          path: "*",
          redirect: "/error/404"
      }
  ]
})
