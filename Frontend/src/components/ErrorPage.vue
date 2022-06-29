<template>
<div class="err">
  <div>
  <h1>401</h1></div>
  <div><h2> Unauthorized Page</h2></div>
  <br>
  <div><button type="button" v-on:click="()=>this.$router.push(url)" class="btn btn-warning">{{name}}</button></div>
</div>
</template>
<script>
export default {
  props: {
    url: String,
    name: String
  }
}
</script>
<style scoped>
.err{
  display: flex;
  text-align: center;
  justify-content: center;
  flex-direction: column;
}
h1{
  font-size: 300px;
}
h2{
  font-size: 50px;
}
button{
  width: 200px;
  height: 50px;
  font-size: 20px;
  border-radius: 10px;
}
</style>
