<template>
<div>
  <NavBar></NavBar>
  <div class="container">
    <CardDenunciaVue></CardDenunciaVue>
    <CardDenunciaVue></CardDenunciaVue>
    <CardDenunciaVue></CardDenunciaVue>
    <button v-on:click='getDenuncias'>a</button>
  </div>
</div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar'
import CardDenunciaVue from './CardDenuncia.vue'
import axios from 'axios'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardDenunciaVue
  },
  data () {
    return {
      denuncias: []
    }
  },
  methods: {
    getDenuncias () {
      axios.get('http://localhost:8080/denuncia/getall').then(response => {
        this.denuncias = response.data
        console.log(response.data[0].idDenunciado)
      })
    }
  }
}
</script>
<style scoped>
  .container{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 80px;
  }
</style>
