<template>
<div class="card">
  <div class="card-body">
    <div>
    <h5 class="card-title">Dirigida a</h5>
    <div>
      <a href="#" class="btn btn-primary">Actualizar el estado</a>
    </div>
    <p>{{id}}</p>
    <p>{{med}}</p>
    <p>{{desc}}</p>
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
    med: String,
    desc: String
  }
}
</script>
