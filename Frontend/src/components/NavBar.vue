<template>
<div>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<div class="colors">
  <div class="br"></div>
  <div class="br2"></div>
</div>
<div class="img">
  <ImagenLogo></ImagenLogo>
</div>
<div class="nav-container">
  <div class="nav-buttons">
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">Mis Denuncias</button></div>
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">User@usach</button></div>
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">Cerrar Sesión</button></div>
  </div>
</div>
<div class="br3"></div>
</div>
</template>
<style scoped>
*{
  font-family: sans-serif;
}

body{
  background-color: grey;
  margin: 0px;
}
.img{
  padding-top: 10px;
  left: 0;
  position: absolute;
}
.br {
  position: absolute;
    height: 10px;
    width: 2000px;
    background: blue;
}
.br2 {
  position: absolute;
    height: 10px;
    width: 1000px;
    background: #FF9900;
}
.br3{
  position: absolute;
    margin-top: 60px;
    height: 1px;
    width: 2000px;
    background: rgb(87, 87, 87);
}
.colors{
  display: flex;
}
.nav-container{
  padding-top: 80px;
  width: 100%;
  height: 75px;
  background-color: #ffffff;
}
.nav-buttons{
  justify-content: center;
  display: flex;
}
.nav-button{
  display: inline-block;
}
.nv-btn{
  border: transparent;
  border-radius: 5px;
  height: 30px;
  width: 150px;
  margin-left: 30px;
  margin-right: 30px;
  margin-top: 18.75px;
}
</style>
<script>
// @ is an alias to /src
import ImagenLogo from '../components/ImagenLogo'
export default {
  name: 'HomeView',
  components: {
    ImagenLogo
  }
}
</script>
