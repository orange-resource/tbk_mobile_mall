import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },

  {
    path: '/interface',
    component: Layout,
    alwaysShow: true,
    name: 'Interface',
    redirect: 'noredirect',
    meta: { title: '接口管理', icon: '接口变更动态' },
    children: [
      {
        path: 'interface_list',
        name: 'InterfaceList',
        component: () => import('@/views/interface/interface_list'),
        meta: { title: '接口列表', icon: '列表' }
      },
    ]
  },

  {
    path: '/systemMessage',
    component: Layout,
    alwaysShow: true,
    name: 'SystemMessage',
    redirect: 'noredirect',
    meta: { title: '系统消息', icon: '消息' },
    children: [
      {
        path: 'list',
        name: 'SystemMessageList',
        component: () => import('@/views/system-message/List'),
        meta: { title: '消息列表', icon: '列表' }
      },
      {
        path: 'form',
        name: 'SystemMessageForm',
        component: () => import('@/views/system-message/Form'),
        meta: { title: '消息操作', icon: 'eye' },
        hidden: true,
      },
    ]
  },

  {
    path: '/course',
    component: Layout,
    alwaysShow: true,
    name: 'Course',
    redirect: 'noredirect',
    meta: { title: '新手教程', icon: '教程' },
    children: [
      {
        path: 'list',
        name: 'CourseList',
        component: () => import('@/views/course/List'),
        meta: { title: '教程列表', icon: '列表' }
      },
      {
        path: 'form',
        name: 'CourseForm',
        component: () => import('@/views/course/Form'),
        meta: { title: '新手教程操作', icon: 'eye' },
        hidden: true,
      },
    ]
  },

  {
    path: '/carousel',
    component: Layout,
    alwaysShow: true,
    name: 'Carousel',
    redirect: 'noredirect',
    meta: { title: '首页轮播', icon: '轮播效果' },
    children: [
      {
        path: 'list',
        name: 'CarouselList',
        component: () => import('@/views/carousel/List'),
        meta: { title: '轮播列表', icon: '列表' }
      },
      {
        path: 'form',
        name: 'CarouselForm',
        component: () => import('@/views/carousel/Form'),
        meta: { title: '轮播操作', icon: 'eye' },
        hidden: true,
      },
    ]
  },

  {
    path: '/hdkConfig',
    component: Layout,
    alwaysShow: true,
    name: 'HdkConfig',
    redirect: 'noredirect',
    meta: { title: '好单库配置', icon: '配置' },
    children: [
      {
        path: 'form',
        name: 'HdkConfigForm',
        component: () => import('@/views/hdk-config/Form'),
        meta: { title: '配置操作', icon: '列表' }
      },
    ]
  },

  {
    path: '/systemConfig',
    component: Layout,
    alwaysShow: true,
    name: 'SystemConfig',
    redirect: 'noredirect',
    meta: { title: '系统配置', icon: '配置' },
    children: [
      {
        path: 'form',
        name: 'SystemConfigForm',
        component: () => import('@/views/system-config/Form'),
        meta: { title: '配置操作', icon: '列表' }
      },
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
