<template>
<div class="card">
  <div class="card-body">
    <div>
    <h5 class="text-dark"><p class="font-weight-bold"><strong>Denuncia hecha por</strong></p>{{nombre2}} {{apellido2}}</h5>
    <h6 class="text-dark">{{mail2}} </h6>
    <h5 class="text-dark" ><p><strong>Dirigida a</strong></p>{{nombre1}} {{apellido1}}</h5>
    <h6 class="text-dark">{{mail1}} </h6>
    <h5 class="text-dark" ><p><strong>Estamento</strong></p></h5>
    <h6 class="text-dark">{{estamento}}</h6>
    <h5 class="text-dark"><p class="font-weight-bold"><strong>Fecha de Ingreso</strong></p></h5>
    <h6 class="text-dark">{{fecha}}</h6>
    <div type="button" v-if="this.rol === 'fiscal'">
      <h5 class="text-dark" ><p><strong>Actualizar estado</strong></p></h5>
        <select required v-model="state" class="form-select updateS" aria-label="Default select example">
          <option class="updateS" value=0 selected>Ingresada</option>
          <option value=1>Asignada a Fiscal</option>
          <option value=2>Investigando</option>
          <option value=3>Finalizada</option>
        </select>
    </div>
    <div class="alert alert-danger" v-if="error === 1">
      Ingrese un estado válido
    </div>
    <div class="alert alert-success" v-if="error === 0">
      Estado de denuncia actualizado
  </div>
    <h5 class="text-dark"><p><strong>Descripcion:</strong></p></h5>
    <h6 class="text-dark">{{descripcion}}</h6>
    <h5 class="text-dark"><p><strong>Medidas de Protección:</strong></p></h5>
    <h6 class="text-dark">{{medidas}}</h6>
    <div class="btn btn-dark text-light">{{estado}}</div>
    <div><br><button v-if= "this.rol === 'fiscal'" type="button" class="btn btn-light" v-on:click='update' >Actualizar Estado</button></div>
    </div>
  </div>
</div>
</template>
<style scoped>
* {
    color: black
  }
  .card{
    margin-bottom: 30px;
    width: 18rem;
    background-color: #fce6c6;
    z-index: 1;
  }
  .updateS{
    z-index: 100;
    background-color: rgb(243, 238, 238);
  }
  @media(max-width: 768px){
    .card{
      width: 30rem;
      margin: 10px;
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
      state: -1,
      error: -1
    }
  },
  methods: {
    update () {
      const bodyFormData = new FormData()
      bodyFormData.append('id_estado', parseInt(this.state))
      axios.put(`http://localhost:8080/denuncia/update-denuncia/${this.id}`, bodyFormData)
        .then(data => {
          if (data.data === -1) {
            this.error = 1
            console.error('Error')
          } else {
            this.error = 0
            window.location.reload()
            console.log('Exito')
          }
        })
    }
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
  },
  mounted () {
    axios.get(`http://localhost:8080/user/get-by-id/${this.idUser}`)
      .then(data => {
        axios.get(`http://localhost:8080/rol/get-by-id/${data.data[0].rol}`)
          .then(data => {
            this.rol = data.data[0].nombre
          })
      })
  }
}
</script>
