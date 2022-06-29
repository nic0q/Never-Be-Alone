<template>
<div class="err">
  <div>
  <h1>401</h1></div>
  <div><h2>Ya Logeado</h2></div>
  <br>
  <div><button type="button" onclick='(function(){location.href="/home"})();' class="btn btn-warning">Home</button></div>
</div>
</template>
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
