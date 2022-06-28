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
