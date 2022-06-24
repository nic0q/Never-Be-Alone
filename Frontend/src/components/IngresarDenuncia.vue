<style>@import '../assets/ingresarDenunciaStyles.css';</style>
<template>
<div class="mt-5">
<div>
  <ImagenLogo></ImagenLogo>
  <NavBar></NavBar>
</div>

<div class = "container">
    <div class=" m-2">
    <label for="floatingUsername">Nombres</label>
   <input type="text" class="form-control" id="name" name="name">
   <br>
   <div>
    <label for="floatingUsername">Correo Electronico</label>
    <input type="text" class="form-control px-5 " id="email" name="email">
    </div>
  <br>
</div>
<div class="m-2">
  <label for="floatingUsername">Apellido Paterno</label>
  <input type="text" class="form-control " id="last_name_one" name="last_name_one">
  </div>
<div class=" m-2">
  <label for="floatingUsername">Apellido Materno</label>
  <input type="text" class="form-control" id="last_name_two" name="last_name_two">
</div>
</div>
<button class="w-90 s-30 btn btn-lg btn-primary" type="submit">Guardar y enviar</button>
<p class="mt-5 mb-3 text-muted">&copy;  Never Be Alone</p>
</div>
</template>
<script>
// @ is an alias to /src
import ImagenLogo from '../components/ImagenLogo'
import NavBar from '@/components/NavBar'
export default {
  name: 'HomeView',
  components: {
    NavBar,
    ImagenLogo
  }
}
</script>
<style scooped>
.container{
  display: flex;
}

</style>
