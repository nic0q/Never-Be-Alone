<style>@import '../assets/ingresarDenunciaStyles.css';</style>
<template>
<div class="">
<div>
  <NavBar></NavBar>
</div>
<div class="f mx-5">
<label>Denunciante</label>
<form>
  <div class="row">
    <div class="col">
      <label for="exampleFormControlTextarea1">Primer Nombre</label>
      <input v-model="nombre1" type="text" class="form-control">
    </div>
    <div class="col">
      <label for="exampleFormControlTextarea1">Apellidos</label>
      <input v-model="apellido1" type="text" class="form-control">
    </div>
  </div>
  <br>
    <div class="row">
    <div class="col">
      <label for="exampleFormControlTextarea1">Correo Denunciado</label>
      <input v-model="mail1" type="text" class="form-control">
    </div>
    <div class="col">
      <label for="exampleFormControlTextarea1">Estamento</label>
      <input v-model="estamento" type="text" class="form-control">
    </div>
    </div>
    <br>
      <div class="row">
    <div class="col">
      <label for="exampleFormControlTextarea1">Primer Nombre</label>
      <input v-model="nombres2" type="text" class="form-control">
    </div>
    <div class="col">
      <label for="exampleFormControlTextarea1">Apellidos</label>
      <input v-model="apellido2" type="text" class="form-control">
    </div>
  </div>
</form>
<br>
<form>
  <div class="row">
    <div class="col">
      <label for="exampleFormControlTextarea1">Correo Denunciante</label>
      <input v-model="mail2" type="text" class="form-control">
    </div>
    <br>
  </div>
</form>
<br>
<div class="form-group">
  <label for="exampleFormControlTextarea1" >Descripción</label>
  <textarea v-model='desc' class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
</div>
<br>
<div class="form-group">
  <label for="exampleFormControlTextarea1">Medidas de Protección</label>
  <textarea v-model='medidas' class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
</div>
<br><br>
<button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='sendData' type="submit">Crear Denuncia</button>
</div>
<br>
<p class="mt-5 mb-3 text-muted">&copy;Never Be Alone</p>
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
      nombre1: '',
      apellido1: '',
      nombre2: '',
      apellido2: '',
      mail1: '',
      mail2: '',
      estamento: '',
      desc: '',
      medidas: ''
    }
  },
  methods: {
    sendData () {
      axios.post('http://localhost:8080/denuncia/crear-denuncia', {
        nombre1: this.nombre1,
        apellido1: this.apellido1,
        nombre2: this.nombre2,
        apellido2: this.apellido2,
        mail1: this.mail1,
        mail2: this.mail2,
        estamento: this.estamento,
        desc: this.desc,
        medidas: this.medidas
      })
        .then(data => {
          console.log(data)
        })
    }
  }
}
</script>
<style scooped>
.f{
  margin-top: 110px;
  border: 1px solid rgb(200, 198, 198);
  padding: 30px;
  border-radius: 30px;
}
.container{
  display: flex;
  margin-top: 100px;
}
</style>
