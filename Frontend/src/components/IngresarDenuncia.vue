<template>
<div>
<div>
  <NavBar></NavBar>
</div>
<div class="f">
  <div class="s">
  <label class="t">Datos de Denunciante</label></div>
  <div class="form1">
<form>
  <div class="row">
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Primer Nombre</label></div>
      <input v-model="nombre1" type="text" class="form-control">
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Primer Apellido</label></div>
      <input v-model="apellido11" type="text" class="form-control">
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Segundo Apellido</label></div>
      <input v-model="apellido12" type="text" class="form-control">
    </div>
  </div>
  <br>
  <div class="row">
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Email</label></div>
      <input v-model="mail1" type="text" class="form-control">
    </div>
    </div>
  </form>
</div>
<br>
<label class="t">Datos de Denunciado</label>
<div class="form2">
  <form>
      <div class="row">
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Primer Nombre</label></div>
      <input v-model="nombre2" type="text" class="form-control">
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Primer Apellido</label></div>
      <input v-model="apellido21" type="text" class="form-control">
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Segundo Apellido</label></div>
      <input v-model="apellido22" type="text" class="form-control">
    </div>
  </div>
</form>
<br>
<form>
  <div class="row">
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Email</label>
      </div>
      <input v-model="mail2" type="text" class="form-control">
    </div>
    <div class="col">
      <div class="s">
      <label for="exampleFormControlTextarea1">Estamento</label></div>
      <input v-model="estamento" type="text" class="form-control">
    </div>
    <br>
  </div>
</form>
</div>
<br>
<div class="t">
<label>Cuerpo Denuncia</label></div>
<div class="texto">
<div class="form-group">
  <div class="s">
  <label for="exampleFormControlTextarea1" >Descripción</label></div>
  <textarea v-model='desc' class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
</div>
<br>
<div class="form-group">
  <div class="s">
  <label for="exampleFormControlTextarea1">Medidas de Protección</label></div>
  <textarea v-model='medidas' class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
</div>
<br><br>
<button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='sendData' type="submit">Crear Denuncia</button>
</div>
</div>
<div class = "alerts">
  <br>
<div class="alert alert-danger" v-if="error === 1">
  Error al crear la denuncia, verifique los datos ingresados
</div>
<div class="alert alert-success" v-if="error === 0">
  Denuncia Creada Satisfactoriamente
</div>
</div>
<br>
<p class="mt-5 mb-3 text-muted">&copy;Never Be Alone</p>
</div>
</template>
<script>
import NavBar from '@/components/NavBar'
import axios from 'axios'
export default {
  name: 'HomeView',
  components: {
    NavBar
  },
  data () {
    return {
      nombre1: '',
      apellido11: '',
      apellido12: '',
      nombre2: '',
      apellido21: '',
      apellido22: '',
      mail1: '',
      mail2: '',
      estamento: '',
      desc: '',
      medidas: '',
      error: -1,
      activesec: localStorage.getItem('token'),
      rol: localStorage.getItem('rol'),
      roleName: ''
    }
  },
  mounted () {
    if (!localStorage.getItem('token')) { // Si no hay un token,no hay alguien con seccion activa, entonces lo redirige al login
      this.$router.push('/')
    } else if (localStorage.getItem('rol') !== '2') { // Si el rol no es 2, no es un usuario, entonces lo redirige a home
      this.$router.push('mis-denuncias')
    }
  },
  methods: {
    sendData () {
      axios.post('http://localhost:8080/denuncia/crear-denuncia', {
        nombre1: this.nombre1,
        apellido11: this.apellido11,
        apellido12: this.apellido12,
        nombre2: this.nombre2,
        apellido21: this.apellido21,
        apellido22: this.apellido22,
        mail1: this.mail1,
        mail2: this.mail2,
        estamento: this.estamento,
        desc: this.desc,
        medidas: this.medidas
      })
        .then(data => {
          console.log(data)
          if (data.data === -1) {
            this.error = 1
            console.error('Error')
          } else {
            this.error = 0
            console.log('Denuncia creada')
          }
        })
    }
  }
}
</script>
<style scooped>
*{color: hsl(210,8%,35%);}
.alerts{
  margin-left: 300px;
  margin-right: 300px;
}
.f{
  margin-top: 50px;
  border: 1px solid rgb(200, 198, 198);
  padding: 30px;
  padding-top: 10px;
  border-radius: 30px;
  margin-left: 300px;
  margin-right: 300px;
}
@media(max-width: 1200px){
  .f{margin-left: 200px;
  margin-right: 200px;}
}
@media(max-width: 900px){
  .f{margin-left: 100px;
  margin-right: 100px;}
}
@media(max-width: 750px){
  .f{margin-left: 40px;
  margin-right: 40px;}
}
@media(max-width: 400px){
  .f{margin-left: 5px;
  margin-right: 5px;}
}
.texto{
  border: 1px solid rgb(133, 133, 130);
  padding: 30px;
  border-radius: 30px;
}
.t{
  margin-left: 30px;
  display: flex;
  font-size:larger;
  font-weight: bold;
  position: relative;
  justify-content: flex-start;
}
.s{
  display: flex;
  justify-content: flex-start;
}
.form1{
  border: 1px solid rgb(82, 82, 173);
  padding: 30px;
  border-radius: 30px;
}
.form2{
  border: 1px solid rgb(215, 149, 33);
  padding: 30px;
  border-radius: 30px;
}
.container{
  display: flex;
  margin-top: 100px;
}
</style>
