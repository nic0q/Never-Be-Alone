<template>
<div>
<div>
  <NavBar></NavBar>
</div>
<br>
<div class="row justify-content-center">
  <table class="table table-striped">
    <thead>
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Apellidos</th>
      <th scope="col">Correo Electrónico</th>
      <th scope="col">Rol Actual</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  <CardRol v-for= "den in dens" :key="den.id" :id = den.id :apellidos = den.apellidos :nombre = den.nombre :rol = den.rol :mail = den.correo></CardRol>
  </tbody>
</table>
</div>
</div>
</template>
<script>
import axios from 'axios'
import NavBar from '@/components/NavBar'
import CardRol from '@/components/CardRol'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    CardRol
  },
  data () {
    return {
      dens: []
    }
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('login')
    } else if (localStorage.getItem('rol') !== '3') { // Si el rol no es 3, no es un usuario, entonces lo redirige a home
      this.$router.push('mis-denuncias')
    } else {
      axios.get('http://localhost:8080/user/getall-no-admin')
        .then(data => {
          console.log(data)
          this.dens = data.data
        })
    }
  },
  methods: {
    sendData () {
      axios.update('http://localhost:8080/user/update-rol/0', {
      })
        .then(data => {
          console.log(data)
          if (data.data === -1) {
            this.error = 1
            console.error('No se actualizo el rol')
          } else {
            this.error = 0
            console.log('Rol actualizado')
          }
        })
    }
  }
}
</script>

<style scoped>
.topBar{
background-color: #00bcd4;
height: 50px;
}
body {
align-items: center;
padding-top: 40px;
padding-bottom: 40px;
background-color: #f5f5f5;
}
.form-control {
width: 100%;
max-width: 500px;
padding: 8px;
margin: auto;
}
.form-signin .checkbox {
font-weight: 400;
}
.form-signin .form-floating:focus-within {
z-index: 2;
}
.contenedor{
  margin-top: 80px;
}
select{
  padding-right: 500px;
}
.container{
    display: flex;
    margin-top: 30px;
}
</style>
