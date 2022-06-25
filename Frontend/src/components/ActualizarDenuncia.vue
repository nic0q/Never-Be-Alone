<style>@import '../assets/actualizarDenuncia.css';</style>
<template>
<div class="mt-5">
<div>
  <ImagenLogo></ImagenLogo>
  <NavBar></NavBar>
</div>
<div class=" m-2">
    <pr>Seleccione el codigo de la denuncia</pr>
    <br>
<select name="codigo">
</select>
<br>
<pr>Seleccione el nuevo estado de la denuncia</pr>
<br>
<select name="estado">
</select>
<br>
</div>
<button class="w-90 s-30 btn btn-lg btn-primary" type="submit">Actualizar</button>
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
