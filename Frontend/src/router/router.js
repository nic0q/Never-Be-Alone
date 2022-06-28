import Vue from 'vue'
import VueRouter from 'vue-router'
import UserLogin from '../components/UserLogin'
import DenunciasUsuario from '../components/DenunciasUsuario'
import IngresarDenuncia from '../components/IngresarDenuncia'
import ActualizarDenuncia from '../components/ActualizarDenuncia'
import HomeUser from '../components/HomeUser'
import BloqueoRol from '../components/BloqueoRol'
import NavBar from '../components/NavBar'
Vue.use(VueRouter)
export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/nv',
      name: 'nv',
      component: NavBar
    },
    {
      path: '/login',
      name: 'login',
      component: UserLogin
    },
    {
      path: '/home',
      name: 'home',
      component: HomeUser
    },
    {
      path: '/denuncias',
      name: 'denuncias',
      component: DenunciasUsuario
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

    },
    {
      path: '/bloqueo-rol',
      name: 'bloqueo-rol',
      component: BloqueoRol
    }
  ]
})
