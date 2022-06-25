<style>@import '../assets/loginStyles.css';</style>
<template>
<div class="container mt-5">

<main class="form-signin">
<form method="POST" action="">
  <ImagenLogo></ImagenLogo>
<h1 class="h3 mt-4 mb-3 fw-normal">Iniciar Sesión</h1>
<div class="form-floating">
<input type="text" class="form-control" id="email" name="email" placeholder="name@example.com">
<label for="floatingUsername">Correo Electrónico</label>
</div>
<div class="form-floating">
<input type="text" class="form-control" id="password" name="password" placeholder="name@example.com">
<label for="floatingUsername">Contraseña</label>
</div>
<div class="checkbox mb-3">
  <label>
    <input type="checkbox" value="remember-me"> Recuerdame
  </label>
</div>
<button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
</form>
<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</main>
<button v-on:click='countUsers'>a</button>
<p>
  {{users}}
</p>
</div>
</template>
<script>
// @ is an alias to /src
import ImagenLogo from '../components/ImagenLogo'
import axios from 'axios'

export default {
  name: 'HomeView',
  components: {
    ImagenLogo
  },
  data () {
    return {
      users: ''
    }
  },
  methods: {
    countUsers () {
      axios.get('http://localhost:8080/user/count').then(response => {
        this.users = response.data
        console.log(response)
      })
    }
  }
}
</script>
