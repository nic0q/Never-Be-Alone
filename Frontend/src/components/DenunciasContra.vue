<template>
<div>
<NavBar></NavBar>
<div class="container">
  <div v-if="this.len===0" class="alert alert-warning" role="alert">
  <h1>Usted no posee denuncias</h1></div>
<div v-else v-for="den in dens" :key="den.id">
  <CardDenunciaVue :nombre1=den.nombreDenunciante :apellido1=den.apellidosDenunciante :mail1=den.mailDenunciantee :nombre2=den.nombreDenunciado :apellido2=den.apellidosDenunciado :mail2=den.mailDenunciado :medidas=den.medidas :estamento=den.estamento :estado=den.estado :descripcion=den.descripcion :fecha=den.fecha></CardDenunciaVue></div>
</div>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import axios from 'axios'
import CardDenunciaVue from './CardDenuncia.vue'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardDenunciaVue
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
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('login')
    } else {
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
