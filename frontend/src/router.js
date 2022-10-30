import { createWebHistory, createRouter } from "vue-router";
import Home from "./components/Home.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";
import Photo from "./components/Photo.vue";
import Upload from "./components/UploadFiles.vue";
import Noticias from "./components/Noticias.vue";

//Lida Agrego
/* eslint-disable */
// lazy-loaded
const Profile = () => import("./components/Profile.vue");
const BoardAdmin = () => import("./components/BoardAdmin.vue");
const BoardModerator = () => import("./components/BoardModerator.vue");
const BoardUser = () => import("./components/BoardUser.vue");
const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/photo/:id",
    name: "photo",
    component: Photo,
  },
  {
    path: "/login",
    component: Login,
  },
  {
    path: "/register",
    component: Register,
  },
  {
    path: "/news",
    component: Noticias,
  },
  {
    path: "/profile",
    name: "profile",
    // lazy-loaded
    component: Profile,
  },
  {
    path: "/admin",
    name: "admin",
    // lazy-loaded
    component: BoardAdmin,
  },
  {
    path: "/upload",
    name: "Add",
    component: Upload,
  },
  {
    path: "/cordinador",
    name: "cordinador",
    // lazy-loaded
    component: BoardModerator,
  },
  {
    path: "/estudiante",
    name: "estudiante",
    // lazy-loaded
    component: BoardUser,
  }, //-------------------------------------------------------Lida paths--------------------------------------------------------------------------
]
const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;
