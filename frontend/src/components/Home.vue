<template>
  <div>
    <!--<header class="jumbotron">
      <h3>{{ content }}</h3>
    </header>-->
    <Gallery />
    <Car/>
  </div>
</template>
<script>
/* eslint-disable */
import Gallery from '@/components/Gallery.vue';
import Photo from '@/components/Photo.vue';
import UserService from "../services/user.service";

export default {
  name: 'photo',
  components: {
    Photo
},
};
  /*data() {
    return {
      content: "",
    };
  },
  mounted() {
    UserService.getPublicContent().then(
      (response) => {
        this.content = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
  },
};*/
</script>
