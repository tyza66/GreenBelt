import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LogView from '../views/LogView.vue'

const routes = [
  {
    path: '/',
    name: 'log',
    component: LogView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }, {
    path: '/help',
    name: 'help',
    component: () => import('../views/HelpView.vue')
  }, {
    path: '/home',
    name: 'home',
    component: HomeView
  }, {
    path: '/sign',
    name: 'sign',
    component: () => import('../views/SignView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router