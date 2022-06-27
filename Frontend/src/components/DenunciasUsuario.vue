<template>
<div>
  <NavBar></NavBar>
  <div class="container">
    <CardDenunciaVue></CardDenunciaVue>
    <CardDenunciaVue></CardDenunciaVue>
    <CardDenunciaVue></CardDenunciaVue>
  </div>
</div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar'
import CardDenunciaVue from './CardDenuncia.vue'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardDenunciaVue
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
