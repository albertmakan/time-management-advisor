<template>
  <v-app>
    <NavigationDrawer />
    <v-main>
      <div class="main">
        <router-view />
      </div>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import NavigationDrawer from "./components/navbar/NavigationDrawer.vue";

export default defineComponent({
  name: "App",
  components: { NavigationDrawer },
});
</script>

<style scoped>
div.main {
  padding: 50px;
}
</style>
