<template>
<div>
<div>
  <NavBar></NavBar>
</div>
<div class="row justify-content-center">
       <thead>
    <tr>
      <th scope="col">#</th>
    </tr>
  </thead>
  <div v-for= "den in dens" :key="den.id" >
  <tr>
     <th scope="row">1</th>
     <td>Nombre: </td>
      <td>{{den.nombre}}</td>
      <td>{{den.apellidos}}</td>
      <td>Rol actual: </td>
      <td>{{den.rol}}</td>
     <td>Rol: </td>
     <td>
      <select class="form-select" aria-label="newRol">
          <option value="0" selected>Usuario</option>
          <option value="1" >Fiscal</option>
          <option value="2">Funcionario DGDE</option>
          <option value="3">Administrador DGDE</option>
        </select>
        </td>
      <td><button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='sendData' type="submit">Modificar</button></td>
      <br>
      <br>
      <div>
    </div>
      </tr>
  </div>

</div>

<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import axios from 'axios'
export default {
  name: 'HomeView',
  components: {
    NavBar
  },
  data () {
    return {
      apellidos: '',
      nombre: '',
      mail: '',
      estamento: '',
      dens: [],
      rol: '',
      len: '',
      newRol: ''
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
          this.len = this.dens.length
          this.apellidos = data.data[0].apellidos
          this.mail = data.data[2].mail
          this.nombre = data.data[5].nombre
          this.rol = data.data[6].rol
        })
      this.$router.push('/')
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
            console.error('Error')
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
