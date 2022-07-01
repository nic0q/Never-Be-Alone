<template>
<div>
<NavBar></NavBar>
<div class="container">
  <div v-if="this.len === 0" class="alert alert-warning" role="alert">
  <h2>Usted no posee denuncias</h2></div>
<div v-else v-for="den in dens" :key='den.id'>
  <CardDenunciaVue :text="'Hecha por'" :nombre1=den.nombreDenunciado :apellido1=den.apellidosDenunciado :mail1=den.mailDenunciado :nombre2=den.nombreDenunciado :apellido2=den.apellidosDenunciado :mail2=den.mailDenunciado :medidas=den.medidas :estamento=den.estamento :estado=den.estado :descripcion=den.descripcion :fecha=den.fecha></CardDenunciaVue></div>
</div>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import axios from 'axios'
import CardDenunciaVue from '@/components/CardDenuncia.vue'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardDenunciaVue
  },
  data () {
    return {
      activesec: localStorage.getItem('token'),
      dens: [],
      len: ''
    }
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('/')
    } else {
      axios.get(`http://localhost:8080/denuncia/show-denuncia-contra/${localStorage.getItem('token')}`).then(response => {
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
