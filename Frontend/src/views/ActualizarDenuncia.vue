<template>
<div>
<div>
  <NavBar></NavBar>
</div>
<div class="contenedor">
    <p>Seleccione el codigo de la denuncia</p>
    <br>
    <div class="s">
      <label for="exampleFormControlTextarea1">Seleccione Denuncia</label></div>
        <select v-for= "den in dens" :key="den.idDenuncia" v-model="estamento" class="form-select" aria-label="Default select example">
          <option value="0" selected>Profesor</option>
          <option value="1">Estudiante</option>
          <option value="2">Funcionario</option>
        </select>
<br>
<p>Seleccione el nuevo estado de la denuncia</p>
<br>
<div class="s">
<label for="exampleFormControlTextarea1">Estado</label></div>
  <select required v-model="estamento" class="form-select" aria-label="Default select example">
    <option value="0" selected>Ingresada</option>
    <option value="1">Asignada a Fiscal</option>
    <option value="2">Investigando</option>
    <option value="3">Finalizada</option>
  </select>
<br>
</div>
<br>
<button class="w-90 s-30 btn btn-lg btn-primary" type="submit">Actualizar</button>
</div>

</template>
<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar'
export default {
  name: 'HomeView',
  components: {
    NavBar
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('/')
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
  margin-left: 400px;
  margin-right: 400px;
}
select{
  padding-right: 500px;
}
</style>
