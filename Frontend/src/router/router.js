import Vue from 'vue'
import VueRouter from 'vue-router'
import DenunciasRealizadas from '../views/DenunciasRealizadas'
import IngresarDenuncia from '../views/IngresarDenuncia'
import DenunciasContra from '../views/DenunciasContra'
import DenunciasFiscal from '@/views/DenunciasFiscal'
import MisDenuncias from '../views/MisDenuncias'
import UserLogin from '../views/UserLogin'
import BloqueoRol from '../views/BloqueoRol'

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
