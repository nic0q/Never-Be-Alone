<template>
<div v-if="activesec!==null">
  <NavBar></NavBar>
  <div class="container">
  <div v-for="den in dens" :key="den.idDenuncia">
    <CardDenunciaVue :id=den.idDenuncia :desc=den.descripcion :med=den.medidas></CardDenunciaVue>
  </div>
  </div>
</div>
<div v-else>
  <ErrorPage></ErrorPage>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import CardDenunciaVue from './CardDenuncia.vue'
import ErrorPage from './ErrorPage.vue'
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:3000'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardDenunciaVue,
    ErrorPage
  },
  data () {
    return {
      dens: [],
      nombreDenunciado: '',
      estado: '',
      activesec: localStorage.getItem('token')
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/denuncia/get-denuncias-denunciante/${localStorage.getItem('token')}`)
      .then(response => {
        this.dens = response.data
      })
  }
}
</script>
<style scoped>
  .container{
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    margin-top: 80px;
  }
    @media(max-width: 768px){
    .container{
      justify-content: center;
    }
  }
</style>
