import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LogView from '../views/LogView.vue'

const routes = [
  {
    path: '/',
    name: 'log',
    component: LogView
  },
  {
    path: 'dist - 副本/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }, {
    path: 'dist - 副本/help',
    name: 'help',
    component: () => import('../views/HelpView.vue')
  }, {
    path: 'dist - 副本/home',
    name: 'home',
    component: HomeView
  }, {
    path: 'dist - 副本/sign',
    name: 'sign',
    component: () => import('../views/SignView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router