<template>
<div class="">
<div>
  <NavBar></NavBar>
</div>
<div class="contenedor">
    <pr>Seleccione el codigo de la denuncia</pr>
    <br>
<select name="codigo">
</select>
<br>
<pr>Seleccione el nuevo estado de la denuncia</pr>
<br>
<select name="estado">
</select>
<br>
</div>
<br>
<button class="w-90 s-30 btn btn-lg btn-primary" type="submit">Actualizar</button>
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
padding: 15px;
margin: auto;
}
.form-signin .checkbox {
font-weight: 400;
}
.form-signin .form-floating:focus-within {
z-index: 2;
}
.contenedor{
  margin-top: 100px;
}
select{
  padding-right: 500px;
}
</style>
