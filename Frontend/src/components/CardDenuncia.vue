<template>
<div class="card">
  <div class="card-body">
    <div>
    <h5 class="card-title">Dirigida a {{nombre}} {{apellido}}</h5>
    <h6>Correo {{mail}}</h6>
    <div>
      <a href="#" class="btn btn-primary">Actualizar el estado</a>
    </div>
    <p>{{id}}</p>
    <p>Medidas de Proteccion {{med}}</p>
    <h6>Fecha de Ingreso {{fecha}}</h6>
    <p>{{desc}}</p>
    <p>Estamento {{estamento}}</p>
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
export default {
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
