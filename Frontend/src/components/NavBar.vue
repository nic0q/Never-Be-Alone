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
<div class="nava">
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">Mis Denuncias</button></div>
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">User@usach</button></div>
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">Rol</button></div>
    <div class="nav-button"><button class="nv-btn"  onclick="location.href='#'" type="button">Cerrar Sesión</button></div>
</div>
<div class="br3"></div>
</div>
</template>
<style scoped>
*{
  font-family: sans-serif;
  overflow-x: hidden;
  max-width: 100%;
  color: hsl(210,8%,35%);
}
body{
  background-color: rgb(233, 221, 221);
  margin: 0px;
}
.img{
  padding-top: 15px;
  width: 300px;
  height: 100px;
  position: absolute;
}
.br {
  position: absolute;
  height: 10px;
  width: 100%;
  background: #FF9900;
}
.nava{
  margin-top: 40px;
  padding: 0;
  font-size: large;
}
.br2 {
  position: absolute;
  height: 10px;
  width: 500px;
  background: blue;
}
.br3{
  position: absolute;
  height: 0.5px;
  width: 100%;
  border: solid rgb(191, 190, 190) 0.5px;
}
.colors{
  display: flex;
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
  background-color: transparent;
  border-radius: 100px;
  width: 150px;
  padding-top: 6px;
  background-color: #f4f5f7;
  padding-bottom: 2px;
  margin-left: 30px;
  margin-right: 30px;
  margin-top: 10px;
}
:hover.nv-btn{
  background-color: #E3E6E8;
  color: rgba(0, 0, 0, 0.961);
}
@media(max-width: 1300px){
  .nava{
    margin-top: 80px;
  }
}
@media(max-width: 435px){
  .nava{
    margin-top: 10px;
  }
  .img{
    visibility: hidden;
  }
  .br2 {
  position: absolute;
  height: 10px;
  width: 100px;
  background: blue;
}
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
