<template>
  <div>
    <v-row justify="center"><h1>My profile</h1></v-row>
    <v-row justify="center">
      <v-card v-if="user.id" :title="user.name" :subtitle="user.email">
        <v-card-text>
          {{ user.birthDate }}
        </v-card-text>
      </v-card>
      <UserForm v-else />
    </v-row>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from "vue";
import UserForm from "@/components/forms/UserForm.vue";
import { User } from "@/model/User";
import { getUser } from "@/services/userService";
export default defineComponent({
  name: "ProfileView",
});
</script>

<script setup lang="ts">
const user = ref<User>({} as User);
onMounted(() => {
  getUser().then((u) => (user.value = u));
});
</script>
