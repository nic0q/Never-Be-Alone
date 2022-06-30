<template>
<div>
<div>
  <NavBar></NavBar>
</div>
<h5>Usuarios:</h5>
<br>
<div class="row justify-content-center">
         <thead>
    <tr>
      <th scope="col"></th>
    </tr>
  </thead>
  <div v-for= "den in dens" :key="den.id" >
  <CardRol :id = den.id :apellidos = den.apellidos :nombre = den.nombre :rol = den.rol></CardRol>
  </div>

</div>

<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
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
