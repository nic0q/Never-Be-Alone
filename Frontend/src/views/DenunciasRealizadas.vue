<template>
<div>
  <NavBar></NavBar>
  <div class="container">
    <div v-if="this.len===0" class="alert alert-warning" role="alert">
    <h2>Usted no ha realizado denuncias</h2></div>
  <div v-else v-for="den in dens" :key="den.id">
    <CardDenunciaVue :text="'Dirigida a'" :nombre1=den.nombreDenunciante :apellido1=den.apellidosDenunciante :mail1=den.mailDenunciante :nombre2=den.nombreDenunciante :apellido2=den.apellidosDenunciante :mail2=den.mailDenunciante :medidas=den.medidas :estamento=den.estamento :estado=den.estado :descripcion=den.descripcion :fecha=den.fecha></CardDenunciaVue></div>
  </div>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import CardDenunciaVue from '@/components/CardDenuncia.vue'
import axios from 'axios'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardDenunciaVue
  },
  data () {
    return {
      dens: [],
      len: '',
      nombreDenunciado: '',
      apellidosDenunciado: '',
      mailDenunciado: '',
      estamento: '',
      estado: '',
      activesec: localStorage.getItem('token'),
      error: -1
    }
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('/')
    } else {
      axios.get(`http://localhost:8080/denuncia/show-denuncia-realizada/${localStorage.getItem('token')}`).then(response => {
        this.dens = response.data
        this.len = this.dens.length
      })
    }
  }
}
</script>
<style scoped>
  .alert{
    padding: 50px;
    margin-top: 3%;
  }
  .container{
    display: flex;
    justify-content: space-evenly;
    align-items: stretch;
    flex-wrap: wrap;
    margin-top: 50px;
  }
    @media(max-width: 768px){
    .container{
      justify-content: center;
    }
  }
</style>
