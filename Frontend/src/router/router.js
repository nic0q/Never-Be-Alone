import Vue from 'vue'
import VueRouter from 'vue-router'
import DenunciasRealizadas from '../components/DenunciasRealizadas'
import IngresarDenuncia from '../components/IngresarDenuncia'
import DenunciasContra from '../components/DenunciasContra'
import DenunciasFiscal from '../components/DenunciasFiscal'
import MisDenuncias from '../components/MisDenuncias'
import UserLogin from '../components/UserLogin'
import BloqueoRol from '../components/BloqueoRol'

Vue.use(VueRouter)
export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: UserLogin
    },
    {
      path: '/mis-denuncias',
      name: 'mis-denuncias',
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
    }
  ]
})
