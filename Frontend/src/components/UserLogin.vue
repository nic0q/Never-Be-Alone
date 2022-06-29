<style>@import '../assets/loginStyles.css';</style>
<template>
<div v-if="activesec === null">
<main class="form-signin">
<form v-on:submit.prevent="login">
  <ImagenLogo></ImagenLogo>
<h1 class="h3 mt-4 mb-3 fw-normal">Iniciar Sesión</h1>
<div class="form-floating">
  <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" v-model="mail">
  <label for="floatingUsername">Correo Electrónico</label>
</div>
<div class="form-floating">
  <input type="password" class="form-control" id="password" name="password" placeholder="name@example.com" v-model="pass">
  <label for="floatingUsername">Contraseña</label>
</div>
<div class="alert alert-danger" v-if="error === 1">
  Credenciales Inválidas
</div>
<div class="alert alert-success" v-if="error === 0">
  Ingreso Exitoso
</div>
</form>
<button class="w-100 btn btn-lg btn-primary" v-on:click='sendData' type="submit" >Sign in</button>
<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</main>
</div>
<AlreadyLogedVue v-else></AlreadyLogedVue>
</template>
<script>
// @ is an alias to /src
import ImagenLogo from '../components/ImagenLogo'
import axios from 'axios'
import AlreadyLogedVue from './AlreadyLoged.vue'
export default {
  name: 'HomeView',
  components: {
    ImagenLogo,
    AlreadyLogedVue
  },
  data () {
    return {
      mail: '',
      pass: '',
      rol: '',
      id: '',
      error: -1,
      activesec: localStorage.getItem('token')
    }
  },
  methods: {
    sendData () {
      const bodyFormData = new FormData()
      bodyFormData.append('mail', this.mail.trim().toLowerCase())
      bodyFormData.append('pass', this.pass.trim().toLowerCase())
      axios.post('http://localhost:8080/user/auth', bodyFormData)
        .then(data => {
          if (data.data === -1) {
            this.error = 1
            console.error('Error login')
          } else {
            this.error = 0
            axios.get(`http://localhost:8080/user/get-by-email/${this.mail}`)
              .then(data => {
                this.id = data.data[0].id
                this.rol = data.data[0].rol
                window.localStorage.setItem('token', this.id)
                window.localStorage.setItem('rol', this.rol)
                console.log(this.rol)
                this.$router.push('mis-denuncias')
                console.log('Login Exitoso')
              })
          }
        })
    }
  }
}
</script>
<style scoped>
.rol{
  display: flex;
  justify-content: start;
}
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}
@media (min-width: 768px) {
  .bd-placeholder-img-lg {
  font-size: 3.5rem;
  }
}
select{
  color: hsl(210,8%,35%);
}
body {
  display: inline;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-floating:focus-within {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
img {
  width: 300px;
  height: 80px;
}
</style>
