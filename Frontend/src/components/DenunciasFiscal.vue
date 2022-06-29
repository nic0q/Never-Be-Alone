<template>
<div v-if="activesec !== null">
  <NavBar></NavBar>
  <div class="container">
    <div v-if="this.len===0" class="alert alert-warning" role="alert">
    <h1>No se encontraron denuncias</h1><br><div><button type="button" v-on:click="()=>this.$router.push('/mis-denuncias')" class="btn btn-warning">Regresar</button></div></div>
  <div v-else v-for="den in dens" :key="den.id">
    <CardDenunciaVue :id=den.id :nombre1=den.nombreDenunciante :apellido1=den.apellidosDenunciante :mail1=den.mailDenunciantee :nombre2=den.nombreDenunciado :apellido2=den.apellidosDenunciado :mail2=den.mailDenunciado :medidas=den.medidas :estamento=den.estamento :estado=den.estado :descripcion=den.descripcion :fecha=den.fecha></CardDenunciaVue></div>
  </div>
</div>
<div v-else>
  <ErrorPage :name='"Login"' :url='"/login"'></ErrorPage>
</div>
</template>
<script>
import CardDenunciaVue from './CardDenuncia.vue'
import NavBar from '@/components/NavBar'
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
      nombre: '',
      id: '',
      apellidos: '',
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
                console.log(this.dens)
                this.len = this.dens.length
              })
            } else {
              console.log('no soi fiscal')
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
