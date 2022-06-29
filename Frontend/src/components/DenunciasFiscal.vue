<template>
<div v-if="activesec !== null">
  <NavBar></NavBar>
  <div class="container">
    <div v-if="this.len===0" class="alert alert-warning" role="alert">
    <h1>Usted no posee denuncias</h1></div>
  <div v-else v-for="den in dens" :key="den.idDenuncia">
    <CardDenunciaVue :mail=den.mailDenunciado :id=den.idDenuncia :apellido=den.apellidosDenunciado :estamento=den.estamento :nombre=den.nombreDenunciado :desc=den.descripcion :med=den.medidas :fecha=den.fecha></CardDenunciaVue></div>
  </div>
</div>
<div v-else>
  <ErrorPage :url='"/login"'></ErrorPage>
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
      rol: '',
      len: '',
      nombreDenunciado: '',
      apellidosDenunciado: '',
      mailDenunciado: '',
      estamento: '',
      estado: '',
      activesec: localStorage.getItem('token')
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/user/get-by-id/${this.activesec}`)
      .then(data => {
        this.mail = data.data[0].correo
        axios.get(`http://localhost:8080/rol/get-by-id/${data.data[0].rol}`)
          .then(data => {
            this.rol = data.data[0].nombre
            if (this.rol === 'fiscal') {
              console.log('soi fiscal')
              axios.get(`http://localhost:8080/denuncia/show-denuncia-fiscal/${localStorage.getItem('token')}`).then(response => {
                this.dens = response.data
                this.len = this.dens.length
              })
            } else {
              this.error = 0
            }
          })
      })
  }
}
</script>
<style scoped>
  .alert{
    padding: 50px;
  }
  .container{
    display: flex;
    justify-content: space-around;
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
