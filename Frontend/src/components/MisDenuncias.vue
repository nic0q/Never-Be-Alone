<template>
<div v-if="activesec !== null">
  <NavBar></NavBar>
  <br>
<br>
  <br>
<br>
<br>
<br>
  <div class="row justify-content-around">
  <div class="card text-center">
  <div class="card-body">
    <h5 class="text-dark">Denuncias Realizadas</h5>
    <br>
    <div>
      <a href="/denuncias" class="btn btn-primary">Ver</a>
    </div>
</div>
</div>
<div class="card">
  <div class="card-body">
    <h5 class="text-dark">Denuncias en Contra</h5>
    <br>
    <div>
      <a href="#" class="btn btn-primary">Ver</a>
    </div>
  </div>
</div>
</div>
  </div>
<div v-else>
  <ErrorPage></ErrorPage>
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
  mounted () {
    axios.get(`http://localhost:8080/denuncia/show-denuncia/${localStorage.getItem('token')}`)
      .then(response => {
        this.dens = response.data
        this.len = this.dens.length
      })
  }
}
</script>
