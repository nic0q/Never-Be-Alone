<style>@import '../assets/ingresarDenunciaStyles.css';</style>
<template>
<div class="">
<div>
  <NavBar></NavBar>
</div>
<div class = "container">
  <div class=" m-2">
    <label for="floatingUsername">Nombres</label>
    <input type="text" class="form-control" id="name" name="name" v-model="id_denunciante">
    <br>
    <div>
      <label for="floatingUsername">Correo Electronico</label>
      <input type="text" class="form-control px-5 " id="email" name="email" v-model="id_denunciado">
      </div>
    <br>
  </div>
  <div class="m-2">
    <label for="floatingUsername">Apellido Paterno</label>
    <input type="text" class="form-control " id="last_name_one" name="last_name_one" v-model="id_estamento_denunciado">
  </div>
  <div class=" m-2">
    <label for="floatingUsername">Apellido Materno</label>
    <input type="text" class="form-control" id="last_name_two" name="last_name_two" v-model="descripcion">
  </div>
  <div class=" m-2">
    <label for="floatingUsername">Correo Denunciado</label>
    <input type="text" class="form-control" id="last_name_two" name="last_name_two" v-model="medidas">
  </div>
  <div class=" m-2">
    <label for="floatingUsername">Correo Denunciadsssssso</label>
    <input type="text" class="form-control" id="last_name_two" name="last_name_two" v-model="id_estado">
  </div>
</div>
<button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='sendData' type="submit">Guardar y enviar</button>
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
      id_denunciante: '',
      id_denunciado: '',
      id_estamento_denunciado: '',
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
.container{
  display: flex;
  margin-top: 100px;
}
</style>
