<template>
  <div id="app" v-if="navs">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <a href="/" class="navbar-brand">EL TIEMPO  </a>
      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <!--Aca para usuarios no registrados-->
        <!-- <li class="nav-item">
          <router-link to="/register" class="nav-link">
            <font-awesome-icon icon="user-plus" /> Sign Up
          </router-link>
        </li>-->
        <!--<li v-if="showNews" class="nav-item">
          <router-link to="/news" class="nav-link">
            <font-awesome-icon icon="newspaper" /> Noticias
          </router-link>
        </li>-->

        <li v-if="showLogs" class="nav-item">
          <router-link to="/login" class="nav-link">
            <font-awesome-icon icon="sign-in-alt" /> Login
          </router-link>
        </li>
      </div>

      <div v-if="currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/profile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" /> LogOut
          </a>
        </li>
      </div>
    </nav>
  </div>
  <nav
    class="navbar navbar-expand-lg navbar-light bg-light"
    v-if="navProfilees"
  >
    <a class="navbar-brand" href="#">EL TIEMPO</a>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav" v-if="navProfiles">
      <ul class="navbar-nav">
        <div v-if="currentUser" class="navbar-nav ml-auto">
          <li class="nav-item">
            <router-link to="/profile" class="nav-link">
              <font-awesome-icon icon="user" />
              {{ currentUser.username.split("@")[0] }}
            </router-link>
          </li>
        </div>
        <li v-if="showAdminBoard" class="nav-item">
          <router-link to="/admin" class="nav-link">
            Usuarios Registrados
          </router-link>
        </li>
        <li v-if="showUpload" class="nav-item">
          <router-link to="/upload" class="nav-link"
            >Agregar estudiantes</router-link
          >
        </li>
        <li v-if="showModeratorBoard" class="nav-item">
          <router-link to="/cordinador" class="nav-link"
            >Cordinador Board</router-link
          >
        </li>
        <li v-if="showUserBoard" class="nav-item">
          <router-link to="/estudiante" class="nav-link"
            >Estudiante</router-link
          >
        </li>
        <li class="nav-item">
          <a class="nav-link" @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" /> LogOut
          </a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container">
    <router-view />
  </div>
  <!---->
</template>

<script>
/* eslint-disable vue/no-unused-components */

export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser["roles"]) {
        return this.currentUser["roles"].includes("ROLE_ADMIN");
      }
      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser["roles"]) {
        return this.currentUser["roles"].includes("ROLE_CORDINADOR");
      }
      return false;
    },
    showUserBoard() {
      if (this.currentUser && this.currentUser["roles"]) {
        return this.currentUser["roles"].includes("ROLE_ESTUDIANTE");
      }
      return false;
    },
    showUpload() {
      if (this.currentUser && this.currentUser["roles"]) {
        return this.currentUser["roles"].includes("ROLE_ADMIN");
      }
      return false;
    },
    navProfilees() {
      return (
        this.$route.path == "/profile" ||
        this.$route.path == "/admin" ||
        this.$route.path == "/estudiante" ||
        this.$route.path == "/cordinador" ||
        this.$route.path == "/photo/:id" ||
        this.$route.path == "/upload"
      );
    },
    navProfiles() {
      return (
        this.$route.path == "/profile" ||
        this.$route.path == "/admin" ||
        this.$route.path == "/estudiante" ||
        this.$route.path == "/cordinador" ||
        this.$route.path == "/photo/:id" ||
        this.$route.path == "/upload"
      );
    },
    navs() {
      return (
        this.$route.path == "/" ||
        this.$route.path == "/login" ||
        this.$route.path == "/news"
      );
    },
    showLogs() {
      return this.$route.path == "/" || this.$route.path == "/news";
    },
    showNews() {
      return this.$route.path == "/";
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/login");
    },
  },
};
</script>
