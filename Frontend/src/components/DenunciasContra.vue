<template>
<div v-if="activesec !== null">
  <NavBar></NavBar>
  <div class="container">
    <div v-if="this.len===0" class="alert alert-warning" role="alert">
    <h1>Usted no posee denuncias</h1></div>
  <div v-else v-for="den in dens" :key="den.id">
    <CardDenunciaVue :nombre1=den.nombreDenunciante :apellido1=den.apellidosDenunciante :mail1=den.mailDenunciantee :nombre2=den.nombreDenunciado :apellido2=den.apellidosDenunciado :mail2=den.mailDenunciado :medidas=den.medidas :estamento=den.estamento :estado=den.estado :descripcion=den.descripcion :fecha=den.fecha></CardDenunciaVue></div>
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
      activesec: localStorage.getItem('token'),
      apellidosDenunciado: '',
      nombreDenunciado: '',
      mailDenunciado: '',
      estamento: '',
      dens: [],
      estado: '',
      rol: '',
      len: ''
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/user/get-by-id/${this.activesec}`)
      .then(data => {
        this.mail = data.data[0].correo
        axios.get(`http://localhost:8080/rol/get-by-id/${data.data[0].rol}`)
          .then(data => {
            this.rol = data.data[0].nombre
            console.log('soi user normal')
            axios.get(`http://localhost:8080/denuncia/show-denuncia-contra/${localStorage.getItem('token')}`).then(response => {
              this.dens = response.data
              this.len = this.dens.length
            })
          }
          )
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
