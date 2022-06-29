<template>
<div class="card">
  <div class="card-body">
    <div>
    <h5 class="card-title">Dirigida a {{nombre}} {{apellido}}</h5>
    <h6>Correo {{mail}}</h6>
    <p>Medidas de Proteccion {{med}}</p>
    <h6>Fecha de Ingreso {{fecha}}</h6>
    <p>{{desc}}</p>
    <p>Estamento {{estamento}}</p>
    </div>
    <div v-if="this.rol === 'fiscal'">
      <a href="#" class="btn btn-primary">Actualizar el estado</a>
    </div>
  </div>
</div>
</template>
<style scoped>
  .card{
    margin: 5px;
    width: 18rem;
    height: 18rem;
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
      idUsr: localStorage.getItem('token'),
      rol: ''
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/rol/get-by-id/${this.idUsr}`)
      .then(data => {
        this.rol = data.data[0].nombre
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
