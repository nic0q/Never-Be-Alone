<template>
<div class="">
<div>
  <NavBar></NavBar>
</div>
<div class="contenedor">
    <pr>Seleccione el correo a bloquear</pr>
    <br>
<select name="codigo">
</select>
<div class = "row justify-content-center">
    <div class=" m-2">
    <label for="floatingUsername">Nombres</label>
   <input type="text" class="form-control" id="name" name="name">
   <br>
   <div>
    <label for="floatingUsername">Rol</label>
    <input type="text" class="form-control px-5 " id="rol" name="rol">
    </div>
  <br>
</div>
<div class="m-2">
  <label for="floatingUsername">Apellido Paterno</label>
  <input type="text" class="form-control " id="last_name_one" name="last_name_one">
</div>
<div class=" m-2">
<label for="floatingUsername">Apellido Materno</label>
<input type="text" class="form-control" id="last_name_two" name="last_name_two">
<br>
<br>
<div>
</div>
</div>
</div>
</div>
<div class="container">
  <select v-for= "den in dens" :key="den.id" class="form-select" aria-label="Default select example">
   <option value="den.id">{{den.apellidos}}</option>
  </select>
<button class="w-90 s-30 btn btn-lg btn-primary" type="submit">Bloquear</button>
<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</div>
</div>
</template>
<script>
// @ is an alias to /src
import axios from 'axios'
import NavBar from '@/components/NavBar'
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
      estado: '',
      rol: '',
      len: ''
    }
  },
  mounted () {
    axios.get('http://localhost:8080/user/getall-no-admin')
      .then(data => {
        console.log(data)
        this.dens = data.data
        this.len = this.dens.length
        this.apellidos = data.data[0].apellidos
        this.nombre = data.data[5].nombre
      })
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
