<style>@import '../assets/ingresarDenunciaStyles.css';</style>
<template>
<div class="">
<div>
  <NavBar></NavBar>
</div>
<div class="f mx-5">
<form>
  <div class="row">
    <div class="col">
      <label for="exampleFormControlTextarea1">Primer Nombre</label>
      <input v-model="nombres" type="text" class="form-control">
    </div>
    <div class="col">
      <label for="exampleFormControlTextarea1">Apellidos</label>
      <input v-model="apellidos" type="text" class="form-control">
    </div>
  </div>
</form>
<br>
<form>
  <div class="row">
    <div class="col">
      <label for="exampleFormControlTextarea1">Correo Denunciado</label>
      <input v-model="mailDenunciado" type="text" class="form-control">
    </div>
    <div class="col">
      <label for="exampleFormControlTextarea1">Correo Denunciante</label>
      <input v-model="mailDenunciante" type="text" class="form-control">
    </div>
  </div>
</form>
<br>
<div class="form-group">
  <label for="exampleFormControlTextarea1" >Descripción</label>
  <textarea v-model='descripcion' class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
</div>
<br>
<div class="form-group">
  <label for="exampleFormControlTextarea1">Medidas de Protección</label>
  <textarea v-model='medidas' class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
</div>
<br><br>
<button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='sendData' type="submit">Guardar y enviar</button>
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
      mail_denunciante: '',
      mail_denunciado: '',
      estamento_denunciado: '',
      descripcion: '',
      medidas: '',
      id_estado: ''
    }
  },
  methods: {
    sendData () {
      axios.post('http://localhost:8080/denuncia/post-denuncia', {
        id_denunciante: this.id_denunciante,
        id_denunciado: this.id_denunciado,
        id_estamento_denunciado: this.id_estamento_denunciado,
        descripcion: this.descripcion,
        medidas: this.medidas,
        id_estado: this.id_estado
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
