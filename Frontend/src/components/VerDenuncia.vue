<style>@import '../assets/ingresarDenunciaStyles.css';</style>
<template>
<div v-if="rol === ''">
<div>
  <NavBar></NavBar>
</div>
<div class="f">
  <div class="s">
  <label class="t">Datos Denuncia</label></div>
  <div class="form1">
<form>
  <div class="row">
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Denunciante</label></div>
      <p>{{this.nombre1}} {{this.apellido11}}</p>
      <p></p>
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Primer Apellido</label></div>
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Segundo Apellido</label></div>
    </div>
  </div>
  <br>
  </form>
</div>
<br>
<label class="t">Datos de Denunciado</label>
<br>
<h1>{{this.id}}</h1>
</div>
<br>
<p class="mt-5 mb-3 text-muted">&copy;Never Be Alone</p>
</div>
<div v-else>
  <ErrorPage :url='"/home"'></ErrorPage>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import axios from 'axios'
import ErrorPage from './ErrorPage.vue'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    ErrorPage
  },
  data () {
    return {
      id: this.$route.params.id,
      nombre1: '',
      apellido11: '',
      apellido12: '',
      nombre2: '',
      apellido21: '',
      apellido22: '',
      mail1: '',
      mail2: '',
      estamento: '',
      desc: '',
      medidas: '',
      error: -1,
      rol: '',
      activesec: localStorage.getItem('token')
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/denuncia/show-denuncia/${this.id}`)
      .then(data => {
        const datos = data.data[0]
        this.nombre1 = datos.nombreDenunciado
        this.apellido11 = datos.apellidosDenunciado
        this.apellido12 = datos.apellidosDenunciado2
        this.nombre2 = datos.nombreDenunciado2
        this.apellido21 = datos.apellidosDenunciado3
        this.apellido22 = datos.apellidosDenunciado4
        this.mail1 = datos.mailDenunciado
        this.mail2 = datos.mailDenunciado2
        this.estamento = datos.estamento
        this.desc = datos.descripcion
        this.medidas = datos.medidasProteccion
      })
  }
}
</script>
<style scooped>
*{color: hsl(210,8%,35%);}
.alerts{
  margin-left: 300px;
  margin-right: 300px;
}
.f{
  margin-top: 50px;
  border: 1px solid rgb(200, 198, 198);
  padding: 30px;
  padding-top: 10px;
  border-radius: 30px;
  margin-left: 300px;
  margin-right: 300px;
}
@media(max-width: 1200px){
  .f{margin-left: 200px;
  margin-right: 200px;}
}
@media(max-width: 900px){
  .f{margin-left: 100px;
  margin-right: 100px;}
}
@media(max-width: 750px){
  .f{margin-left: 40px;
  margin-right: 40px;}
}
@media(max-width: 400px){
  .f{margin-left: 5px;
  margin-right: 5px;}
}
.texto{
  border: 1px solid rgb(133, 133, 130);
  padding: 30px;
  border-radius: 30px;
}
.t{
  margin-left: 30px;
  display: flex;
  font-size:larger;
  font-weight: bold;
  position: relative;
  justify-content: flex-start;
}
.s{
  display: flex;
  justify-content: flex-start;
}
.form1{
  border: 1px solid rgb(82, 82, 173);
  padding: 30px;
  border-radius: 30px;
}
.form2{
  border: 1px solid rgb(215, 149, 33);
  padding: 30px;
  border-radius: 30px;
}
.container{
  display: flex;
  margin-top: 100px;
}
</style>
