<template>
  <v-app>
    <NavigationDrawer />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import NavigationDrawer from "./components/navbar/NavigationDrawer.vue";

export default defineComponent({
  name: "App",
  data() {
    return {
      //
    };
  },
  components: { NavigationDrawer },
});
</script>
