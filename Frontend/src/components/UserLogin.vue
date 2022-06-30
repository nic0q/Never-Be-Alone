<template>
<div class="centere">
  <div>
<main class="form-signin">
<form>
  <img src="https://direcciondegenero.usach.cl/sites/direccion_genero/files/dg.png">
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
<button class="w-100 btn btn-lg btn-primary" v-on:click='submit' type="submit" >Sign in</button>
<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</main>
</div></div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'HomeView',
  data () {
    return {
      mail: '',
      pass: '',
      rol: '',
      id: '',
      error: -1
    }
  },
  mounted () {
    if (localStorage.getItem('token')) { // Si hay un token, hay alguien con seccion activa, entonces no se permite el acceso al login
      this.$router.push('mis-denuncias')
    }
  },
  methods: {
    submit () {
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
                localStorage.setItem('token', this.id)
                localStorage.setItem('rol', this.rol)
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
img {
  width: 300px;
  height: 70px;
}
.centere{

  margin-top: 8%;
}
@media (min-width: 768px) {
  .bd-placeholder-img-lg {
  font-size: 3.5rem;
  }
}
select{
  color: hsl(210,8%,35%);
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
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 15px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
img {
  width: 300px;
  height: 77px;
}
</style>
