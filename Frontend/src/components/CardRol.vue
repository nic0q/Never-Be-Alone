<template>
  <tr>
    <td>{{nombre}}</td>
    <td>{{apellidos}}</td>
    <td>{{mail}}</td>
    <td v-if="this.rol === 0" >Usuario</td>
    <td v-else-if="this.rol === 1" >Fiscal</td>
    <td v-else-if="this.rol === 2" >Funcionario DGDE</td>
    <td v-else>Admin DGDE</td>
    <td>
      <select class="form-select" v-model="newRol">
        <option value="0" selected>Usuario</option>
        <option value="1" >Fiscal</option>
        <option value="2">Funcionario DGDE</option>
        <option value="3">Administrador DGDE</option>
      </select>
    </td>
    <td>
      <button class="w-90 s-30 btn btn-lg btn-primary" v-on:click='update' type="submit">Modificar</button>
    </td>
  </tr>
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
            console.error('Error')
          } else {
            window.location.reload()
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
    mail: String,
    id: Number,
    i: Number
  }
}
</script>
