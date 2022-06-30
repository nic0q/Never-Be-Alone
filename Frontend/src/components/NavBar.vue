<template>
<div>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<div class="colors">
  <div class="br"></div>
  <div class="br2"></div>
</div>
<div class="nbb">
<div class="nava">
  <div type="button" v-on:click="()=>this.$router.push('mis-denuncias')">
  <img src="https://direcciondegenero.usach.cl/sites/direccion_genero/files/dg.png">
  </div>
      <div class="nav-button"> <button  v-if= "this.rol === 'dgde'" class="nv-btn" v-on:click="()=>this.$router.push('ingresar-denuncia')" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
  <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
</svg> Ingresar Denuncia</button>
</div>
<div class="nav-button"> <button  v-if= "this.rol === 'admin'" class="nv-btn" v-on:click="()=>this.$router.push('bloqueo-rol')" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
</svg> Modificar rol </button>
</div>
    <div class="nav-button"><button class="nv-btn" v-on:click="()=>this.$router.push('mis-denuncias')" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-envelope-paper" viewBox="0 0 16 16">
  <path d="M4 0a2 2 0 0 0-2 2v1.133l-.941.502A2 2 0 0 0 0 5.4V14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V5.4a2 2 0 0 0-1.059-1.765L14 3.133V2a2 2 0 0 0-2-2H4Zm10 4.267.47.25A1 1 0 0 1 15 5.4v.817l-1 .6v-2.55Zm-1 3.15-3.75 2.25L8 8.917l-1.25.75L3 7.417V2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v5.417Zm-11-.6-1-.6V5.4a1 1 0 0 1 .53-.882L2 4.267v2.55Zm13 .566v5.734l-4.778-2.867L15 7.383Zm-.035 6.88A1 1 0 0 1 14 15H2a1 1 0 0 1-.965-.738L8 10.083l6.965 4.18ZM1 13.116V7.383l4.778 2.867L1 13.117Z"/>
</svg> Mis Denuncias</button></div>
    <div class="nav-button nv-btn"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
</svg>  {{mail}}</div>
    <div class="nav-button nv-btn"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-incognito" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="m4.736 1.968-.892 3.269-.014.058C2.113 5.568 1 6.006 1 6.5 1 7.328 4.134 8 8 8s7-.672 7-1.5c0-.494-1.113-.932-2.83-1.205a1.032 1.032 0 0 0-.014-.058l-.892-3.27c-.146-.533-.698-.849-1.239-.734C9.411 1.363 8.62 1.5 8 1.5c-.62 0-1.411-.136-2.025-.267-.541-.115-1.093.2-1.239.735Zm.015 3.867a.25.25 0 0 1 .274-.224c.9.092 1.91.143 2.975.143a29.58 29.58 0 0 0 2.975-.143.25.25 0 0 1 .05.498c-.918.093-1.944.145-3.025.145s-2.107-.052-3.025-.145a.25.25 0 0 1-.224-.274ZM3.5 10h2a.5.5 0 0 1 .5.5v1a1.5 1.5 0 0 1-3 0v-1a.5.5 0 0 1 .5-.5Zm-1.5.5c0-.175.03-.344.085-.5H2a.5.5 0 0 1 0-1h3.5a1.5 1.5 0 0 1 1.488 1.312 3.5 3.5 0 0 1 2.024 0A1.5 1.5 0 0 1 10.5 9H14a.5.5 0 0 1 0 1h-.085c.055.156.085.325.085.5v1a2.5 2.5 0 0 1-5 0v-.14l-.21-.07a2.5 2.5 0 0 0-1.58 0l-.21.07v.14a2.5 2.5 0 0 1-5 0v-1Zm8.5-.5h2a.5.5 0 0 1 .5.5v1a1.5 1.5 0 0 1-3 0v-1a.5.5 0 0 1 .5-.5Z"/>
</svg> {{rol}}</div>
    <div class="nav-button"><button class="nv-btn" v-on:click='logout' type="button"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-reply-fill" viewBox="0 0 16 16">
  <path d="M5.921 11.9 1.353 8.62a.719.719 0 0 1 0-1.238L5.921 4.1A.716.716 0 0 1 7 4.719V6c1.5 0 6 0 7 8-2.5-4.5-7-4-7-4v1.281c0 .56-.606.898-1.079.62z"/>
</svg>Cerrar Sesión</button></div>
</div>
</div>
</div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'HomeView',
  data () {
    return {
      id: localStorage.getItem('token'),
      mail: '',
      rol: ''
    }
  },
  mounted () {
    axios.get(`http://localhost:8080/user/get-by-id/${this.id}`)
      .then(data => {
        this.mail = data.data[0].correo
        axios.get(`http://localhost:8080/rol/get-by-id/${data.data[0].rol}`)
          .then(data => {
            this.rol = data.data[0].nombre
          })
      })
  },
  methods: {
    logout () {
      localStorage.removeItem('token')
      localStorage.removeItem('rol')
      this.$router.push('/')
    }
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
  width: 170px;
  height: 40px;
  left: 18px;
  position: absolute;
}
.br {
  position: absolute;
  height: 5px;
  width: 100%;
  background: #FF9900;
}
.nava{
  border: 2px solid #8d8eaf;
  margin-top: 10px;
  border-radius: 100px;
  margin-left: 3px;
  margin-right: 3px;
  padding: 4px;
  font-size: medium;
  background-color: rgb(244, 245, 247);
}
.br2 {
  position: absolute;
  height: 5px;
  width: 500px;
  background: blue;
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
  padding: 2px;
  border: transparent;
  background-color: transparent;
  border-radius: 100px;
  width: 240px;
  padding-top: 6px;
  padding-bottom: 2px;
  margin-left: 2px;
  margin-right: 2px;
}
:hover.nv-btn{
  color: rgba(0, 0, 0, 0.961);
}
@media(max-width: 1300px){
  img{
    visibility: hidden;
  }
  .br3{
    margin-top: 0;
  }
  .nava{
    border-radius: 10px;
  }
}
@media(max-width: 435px){
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
