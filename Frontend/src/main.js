import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import axios from 'axios'

Vue.config.productionTip = false
Vue.use(BootstrapVue)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
export function getUserById (id) {
  return axios.get(`http://localhost:8080/user/get-by-id/${id}`).then(response => response.data[0].rol)
}
