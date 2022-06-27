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
<div class = "container">
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
<button class="w-90 s-30 btn btn-lg btn-primary" type="submit">Bloquear</button>
<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</div>

</template>
<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar'
export default {
  name: 'HomeView',
  components: {
    NavBar
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
