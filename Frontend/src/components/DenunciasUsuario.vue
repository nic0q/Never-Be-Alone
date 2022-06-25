<style>@import '../assets/denunciasStyles.css';</style>
<template>
<div>
  <ImagenLogo></ImagenLogo>
  <NavBar></NavBar>
  <button v-on:click="countUsers">Presioname</button>
  {{ users }}
</div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar'
import ImagenLogo from '../components/ImagenLogo'
import axios from 'axios'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    ImagenLogo
  },
  methods: {
    countUsers () {
      axios.get('http://localhost:8080/user/count')
        .then(response => {
          this.users = response.data
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
}
</script>
