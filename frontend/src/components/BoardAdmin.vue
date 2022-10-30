<template>
  <Register />
  <div id="app">
    <div class="container" style="width: 450px">
      <div style="margin: 5px"></div>
      <h1 class="text-center">Lista de Usuarios</h1>
      <table class="table">
        <thead class="text-center">
          <th>Id</th>
          <th>Correo</th>
          <th>Nombre</th>
          <th>Documento</th>
        </thead>
        <tbody>
          <tr
            v-for="estudiante in user"
            :key="estudiante.id"
            class="text-center"
          >
            <td>{{ estudiante.id }}</td>
            <td>{{ estudiante.title }}</td>
            <td>{{ estudiante.nombre }}</td>
            <td>{{ estudiante.documento }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import UserService from "../services/user.service";

export default {
  name: "user",
  data() {
    return{
      user:[]
    }
    
  },
  mounted() {
    UserService.getAdminBoard().then(
      (response) => {
        this.user = response.data;
      });
    
  }
    
}

</script>
