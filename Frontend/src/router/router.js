import Vue from 'vue'
import VueRouter from 'vue-router'
import UserLogin from '../components/UserLogin'
import IngresarDenuncia from '../components/IngresarDenuncia'
import MisDenuncias from '../components/MisDenuncias'
import DenunciasRealizadas from '../components/DenunciasRealizadas'
import DenunciasContra from '../components/DenunciasContra'
import DenunciasFiscal from '../components/DenunciasFiscal'
import VerDenuncia from '../components/VerDenuncia'
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
      path: '/mis-denuncias',
      name: '/mis-denuncias',
      component: MisDenuncias
    },
    {
      path: '/ingresar-denuncia',
      name: 'ingresar-denuncia',
      component: IngresarDenuncia
    },
    {
      path: '/bloqueo-rol',
      name: 'bloqueo-rol',
      component: BloqueoRol
    },
    {
      path: '/denuncias-realizadas',
      name: 'denuncias-realizadas',
      component: DenunciasRealizadas
    },
    {
      path: '/denuncias-contra',
      name: 'denuncias-contra',
      component: DenunciasContra
    },
    {
      path: '/denuncias-fiscal',
      name: 'denuncias-fiscal',
      component: DenunciasFiscal
    },
    {
      path: '/denuncia/:id',
      name: 'ver-denuncia',
      component: VerDenuncia
    }
  ]
})
