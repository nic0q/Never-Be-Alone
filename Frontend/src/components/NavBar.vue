<template>
<div>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<div class="colors">
  <div class="br"></div>
  <div class="br2"></div>
</div>
<div class="nbb">
<img src="https://direcciondegenero.usach.cl/sites/direccion_genero/files/dg.png">
<div class="nava">
    <div class="nav-button"><button class="nv-btn" onclick="location.href=''" type="button">Mis Denuncias</button></div>
    <div class="nav-button"><button class="nv-btn" onclick="location.href=''" type="button">@usach.cl</button></div>
    <div class="nav-button"><button class="nv-btn" onclick="location.href=''" type="button">Rol</button></div>
    <div class="nav-button"><button class="nv-btn" onclick='(function(){localStorage.removeItem("token");localStorage.removeItem("mail");location.href="/login"})();' type="button">Cerrar Sesión</button></div>
</div>
<div class="br3"></div>
</div>
</div>
</template>
<script>
export default {
  name: 'HomeView',
  data () {
    return {
      mail: ''
    }
  },
  mounted () {
    this.mail = localStorage.getItem('mail')
  }
}
</script>
<style scoped>
*{
  font-family: sans-serif;
  overflow-x: hidden;
  max-width: 100%;
  color: hsl(210,8%,35%);
}
img{
  padding-top: 10px;
  width: 250px;
  height: 70px;
  left: 30px;
  position: absolute;
}
.br {
  position: absolute;
  height: 5px;
  width: 100%;
  background: #FF9900;
}
.nava{
  margin-top: 20px;
  padding: 0;
  font-size: large;
}
.br2 {
  position: absolute;
  height: 5px;
  width: 500px;
  background: blue;
}
.br3{
  position: absolute;
  border-radius: 100px;
  margin-top: 5px;
  height: 1px;
  width: 100%;
  background-color: black;
}
.nav-buttons{
  justify-content: center;
  display: flex;
}
.nav-button{
  display: inline-block;
}
.nv-btn{
  font-weight: bold;
  border: transparent;
  background-color: transparent;
  border-radius: 100px;
  width: 150px;
  padding-top: 6px;
  padding-bottom: 2px;
  margin-left: 30px;
  margin-right: 30px;
  margin-top: 10px;
}
:hover.nv-btn{
  background-color: #E3E6E8;
  color: rgba(0, 0, 0, 0.961);
}
@media(max-width: 1115px){
  .nava{
    margin-top: 58px;
  }
  .br3{
    margin-top: 0;
  }
}
@media(max-width: 435px){
  .nava{
    margin-top: 15px;
  }
  img{
    visibility: hidden;
  }
  .br2 {
  position: absolute;
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
