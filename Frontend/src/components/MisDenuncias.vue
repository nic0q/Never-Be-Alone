<template>
<div>
  <NavBar></NavBar>
  <br><br><br><br> <br><br><br>
  <div class="row justify-content-around">
  <div class="card text-center">
  <div class="card-body">
    <h5 class="text-dark">Denuncias Realizadas</h5>
    <br>
    <div type="button" v-on:click="()=>this.$router.push('denuncias-realizadas')">
      <a class="btn btn-primary">Ver</a>
    </div>
</div>
</div>
<div class="card">
  <div class="card-body">
    <div v-if="this.rol === 'fiscal'" >
    <h5 class="text-dark">Denuncias Asignadas</h5><br>
        <div type="button" v-on:click="()=>this.$router.push('denuncias-fiscal')">
      <a class="btn btn-primary">Ver</a>
    </div>
    </div>
    <div v-else>
      <h5 class="text-dark">Denuncias en Contra</h5><br>
      <div type="button" v-on:click="()=>this.$router.push('denuncias-contra')">
      <a class="btn btn-primary">Ver</a>
    </div>
    </div>
    <br>
  </div>
</div>
</div>
  </div>
</template>
<style scoped>
  .card{
    margin: 5px;
    width: 18rem;
    height: 10rem;
    background-color: #FF9900;
  }
  @media(max-width: 768px){
    .card{
      width: 24rem;
      margin: 10px;
      height: 24rem;
    }
  }
</style>
<script>
import NavBar from '@/components/NavBar'
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:3000'
export default {
  name: 'HomeView',
  components: {
    NavBar
  },
  data () {
    return {
      id: localStorage.getItem('token'),
      rol: ''
    }
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('login')
    } else {
      axios.get(`http://localhost:8080/user/get-by-id/${this.id}`)
        .then(data => {
          this.mail = data.data[0].correo
          axios.get(`http://localhost:8080/rol/get-by-id/${data.data[0].rol}`)
            .then(data => {
              this.rol = data.data[0].nombre
              console.log(this.rol)
            })
        })
    }
  }
}
</script>
