<template>
<div>
  <NavBar></NavBar>
  <div class="container">
    <div v-if="this.len===0" class="alert alert-warning" role="alert">
    <h2>No se le ha sigo asignada ninguna denuncia</h2><div></div></div>
  <div v-else v-for="den in dens" :key="den.id">
    <CardDenunciaVue :id=den.id :nombre1=den.nombreDenunciante :apellido1=den.apellidosDenunciante :mail1=den.mailDenunciante :nombre2=den.nombreDenunciado :apellido2=den.apellidosDenunciado :mail2=den.mailDenunciado :medidas=den.medidas :estamento=den.estamento :estado=den.estado :descripcion=den.descripcion :fecha=den.fecha></CardDenunciaVue></div>
  </div>
</div>
</template>
<script>
import CardDenunciaVue from '@/components/CardDenunciaFiscal.vue'
import NavBar from '@/components/NavBar'
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
      rol: '',
      len: ''
    }
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si hay un token, hay alguien con seccion activa, entonces no se permite el acceso al login
      this.$router.push('/')
    } else if (localStorage.getItem('rol') !== '1') {
      this.$router.push('mis-denuncias')
    } else {
      axios.get(`http://localhost:8080/denuncia/show-denuncia-fiscal/${localStorage.getItem('token')}`).then(response => {
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
