<template>
<div>
  <NavBar></NavBar>
  <div class="cardss row justify-content-around">
  <div class="card text-center">
  <div class="card-body">
    <div>
    <h5 class="text-dark " >Denuncias Realizadas </h5>
    <p>Ingrese aquí para ver las denuncias que usted ha realizado</p>
    <br>
    <div type="button" v-on:click="()=>this.$router.push('denuncias-realizadas')">
      <a class="btn btn-dark">Ver</a>
    </div></div>
</div>
</div>
<div class="card">
  <div class="card-body">
    <div v-if="this.rol === 'fiscal'" >
    <h5 class="text-dark">Denuncias Asignadas</h5>
      <p>Ingrese aquí para ver las denuncias que le han sido asignadas</p>
      <br>
      <div type="button" v-on:click="()=>this.$router.push('denuncias-fiscal')">
      <a class="btn btn-dark">Ver</a>
    </div>
    </div>
    <div v-else>
      <h5 class="text-dark">Denuncias en Contra</h5><br>
      <p>Ingrese aquí para ver las denuncias que se le han presentado en su contra</p>
      <br>
      <div type="button" v-on:click="()=>this.$router.push('denuncias-contra')">
      <a class="btn btn-dark">Ver</a>
    </div>
    </div>
    <br>
  </div>
</div>
</div>
<br><br>
  </div>
</template>
<style scoped>
  *{
    overflow-x: hidden;
  }
  .btn{
    width: 200px;
  }
  h5{
    font-weight: bolder;
    font-size: x-large;
  }
  .cardss{
    margin-top: 11%;
    margin-left: 200px;
    margin-right: 200px;
  }
  .card{
    overflow-x: hidden;
    margin-top: 10px;
    width: 25rem;
    height: 15rem;
    background-color: #fbe4bf;
    border-radius: 10px;
  }
  .card-body{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }
  @media(max-width: 768px){
    .cardss{
      margin-top: 13%;
      margin-left: 0px;
      margin-right: 0px;
  }
  }
</style>
<script>
import NavBar from '@/components/NavBar.vue'
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
      this.$router.push('/')
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
