<template>
<table class="table">
  <tbody>
    <tr>
      <th scope="row">ID: {{id}}</th>
      <td>{{nombre}}</td>
      <td>{{apellidos}}</td>
      <td> Rol actual:</td>
        <td v-if="rol === 0" > Usuario </td>
        <td v-else-if="rol === 1" > Fiscal </td>
        <td v-else> Funcionario </td>
       <td>Rol: </td>
        <td>
      <select class="form-select" v-model="newRol">
          <option value="0" selected>Usuario</option>
          <option value="1" >Fiscal</option>
          <option value="2">Funcionario DGDE</option>
          <option value="3">Administrador DGDE</option>
        </select>
        </td>
      <td><button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='update' type="submit">Modificar</button></td>
    </tr>
  </tbody>
</table>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      idUser: localStorage.getItem('token'),
      newRol: '',
      state: -1,
      error: -1
    }
  },
  methods: {
    update () {
      const bodyFormData = new FormData()
      bodyFormData.append('id_rol', parseInt(this.newRol))
      axios.put(`http://localhost:8080/user/update-rol/${this.id}`, bodyFormData)
        .then(data => {
          if (data.data === -1) {
            this.error = 1
            window.location.reload()
            console.error('Error')
          } else {
            this.error = 0
            console.log('Exito')
          }
        })
    }
  },
  props: {
    rol: Number,
    nombre: String,
    apellidos: String,
    id: Number
  }
}
</script>
