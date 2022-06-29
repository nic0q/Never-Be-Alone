<template>
<div class="card">
  <div class="card-body">
    <div>
    <h5 class="card-title">Dirigida a {{nombre}} {{apellido}}</h5>
        <div type="button" class="update" v-if="this.rol === 'fiscal'">
        <select required v-model="estado" class="form-select update" aria-label="Default select example">
          <option class="update" value="0" selected>Ingresada</option>
          <option value="1">Asignada a Fiscal</option>
          <option value="2">Investigando</option>
          <option value="3">Finalizada</option>
        </select>
    </div>
    <h6>Correo {{mail}}</h6>
    <p>Medidas de Proteccion {{med}}</p>
    <h6>Fecha de Ingreso {{fecha}}</h6>
    <p>{{desc}}</p>
    <p>Estamento {{estamento}}</p>
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
      this.estado = 1
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
    nombre: String,
    apellido: String,
    med: String,
    mail: String,
    estamento: String,
    desc: String,
    fecha: String
  }
}
</script>
