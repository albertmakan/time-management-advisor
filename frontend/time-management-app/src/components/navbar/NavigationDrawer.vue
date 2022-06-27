<template>
  <v-navigation-drawer theme="dark" width="250" permanent>
    <template v-slot:prepend>
      <v-list-item><h2>time management app</h2></v-list-item>
    </template>
    <v-list nav>
      <v-list-item
        density="comfortable"
        v-for="item in items"
        :key="item.title"
        :prepend-icon="item.icon"
        :title="item.title"
        :to="item.to"
      ></v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "NavigationDrawer",
  data: () => ({
    items: [
      { title: "Activities", icon: "mdi-view-dashboard", to: "/activities" },
      { title: "Routines", icon: "mdi-clock", to: "/routines" },
      { title: "Calendar", icon: "mdi-calendar", to: "/calendar" },
      { title: "New activity", icon: "mdi-calendar-plus", to: "/new-activity" },
      { title: "Reports", icon: "mdi-chart-bar", to: "/reports" },
      { title: "My profile", icon: "mdi-account", to: "/profile" },
      { title: "Monitoring", icon: "mdi-clock", to: "/monitoring" },
    ],
  }),
});
</script>
