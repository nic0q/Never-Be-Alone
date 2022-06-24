import Vue from 'vue'
import VueRouter from 'vue-router'
import UserLogin from '../components/UserLogin'
import DenunciasUsuario from '../components/DenunciasUsuario'
Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'login',
      component: UserLogin
    },
    {
      path: '/denuncias',
      name: 'denuncias',
      component: DenunciasUsuario
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    }
  ]
})
