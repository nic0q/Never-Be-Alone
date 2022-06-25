import Vue from 'vue'
import VueRouter from 'vue-router'
import UserLogin from '../components/UserLogin'
import DenunciasUsuario from '../components/DenunciasUsuario'
import IngresarDenuncia from '../components/IngresarDenuncia'
import ActualizarDenuncia from '../components/ActualizarDenuncia'
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
    },
    {
      path: '/ingresar-denuncia',
      name: 'ingresar-denuncia',
      component: IngresarDenuncia
    },
    {
      path: '/actualizar-denuncia',
      name: 'actualizar-denuncia',
      component: ActualizarDenuncia

    }
  ]
})
