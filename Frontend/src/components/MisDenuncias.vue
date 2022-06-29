<template>
<div v-if="activesec !== null">
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
    <h5 class="text-dark">Denuncias en Contra</h5>
    <br>
    <div type="button" v-on:click="()=>this.$router.push('denuncias-contra')">
      <a class="btn btn-primary">Ver</a>
    </div>
  </div>
</div>
</div>
  </div>
<div v-else>
  <ErrorPage :url='"/login"'></ErrorPage>
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
import ErrorPage from '@/components/ErrorPage'
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:3000'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    ErrorPage
  },
  data () {
    return {
      activesec: localStorage.getItem('token')
    }
  }
}
</script>
