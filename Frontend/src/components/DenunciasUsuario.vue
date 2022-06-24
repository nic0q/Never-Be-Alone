<style>@import '../assets/denunciasStyles.css';</style>
<template>
<div>
  <ImagenLogo></ImagenLogo>
  <NavBar></NavBar>
</div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar'
import ImagenLogo from '../components/ImagenLogo'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    ImagenLogo
  }
}
</script>
