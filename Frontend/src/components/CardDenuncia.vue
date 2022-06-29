<template>
<div class="card">
  <div class="card-body">
    <div>
    <h5>Denuncia hecha por {{nombre2}} {{apellido2}}</h5>
    <h6>{{mail2}} </h6>
    <h5>Fecha de Ingreso </h5>
    <h6>{{fecha}}</h6>
    <h5>Dirigida a {{nombre1}} {{apellido1}}</h5>
    <h6>{{estamento}}</h6>
    <h6>{{mail1}} </h6>
        <div type="button" class="update" v-if="this.rol === 'fiscal'">
        <select required v-model="state" class="form-select update" aria-label="Default select example">
          <option class="update" value="0" selected>Ingresada</option>
          <option value="1">Asignada a Fiscal</option>
          <option value="2">Investigando</option>
          <option value="3">Finalizada</option>
        </select>
    </div>
    <h5>Descripcion</h5>
    <h6>{{descripcion}}</h6>
    <h5>Medidas de Protección</h5>
    <h6>{{medidas}}</h6>
    <div><button type="button" v-on:click="()=>this.$router.push(`denuncia/`+id)" class="btn btn-primary">Desplegar</button></div>
    </div>
  </div>
</div>
</template>
<style scoped>
  .card{
    margin: 5px;
    width: 18rem;
    height: 18rem;
    z-index: 1;
  }
  .update{
    z-index: 100;
    background-color: rgb(243, 238, 238);
  }
  @media(max-width: 768px){
    .card{
      width: 24rem;
      margin: 10px;
      height: 24rem;
    }
  }
</style>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      idUser: localStorage.getItem('token'),
      rol: '',
      state: -1
    }
  },
  methods: {
    enable () {
      this.state = 1
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/user/get-by-id/${this.idUser}`)
      .then(data => {
        axios.get(`http://localhost:8080/rol/get-by-id/${data.data[0].rol}`)
          .then(data => {
            this.rol = data.data[0].nombre
          })
      })
  },
  props: {
    id: Number,
    nombre1: String,
    apellido1: String,
    mail1: String,
    nombre2: String,
    apellido2: String,
    mail2: String,
    medidas: String,
    estamento: String,
    estado: String,
    descripcion: String,
    fecha: String
  }
}
</script>
