<template>
  <v-card title="User" maxWidth="700">
    <v-card-content>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field label="Name" v-model="user.name" :rules="rules.name" />
        <v-text-field
          label="E-mail"
          v-model="user.email"
          :rules="rules.email"
        />
        <label>Birth date:</label>
        <v-date-picker v-model="user.birthDate" />
      </v-form>
    </v-card-content>
    <v-card-actions>
      <v-btn :disabled="!valid" color="secondary" size="large" @click="submit">
        Save
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
import { ref } from "vue";
import { useToast } from "vue-toastification";
import { User } from "@/model/User";
import { createUser } from "@/services/userService";
export default { name: "UserForm" };
</script>

<script setup lang="ts">
const toast = useToast();
const user = ref<User>({ name: "", email: "", birthDate: new Date() });
const valid = ref(true);
const submit = () => {
  createUser(user.value).then(() => toast.success("Added"));
};

const rules = {
  name: [(v: string) => !!v || "Name is required"],
  email: [
    (v: string) => !!v || "E-mail is required",
    (v: string) => /.+@.+\..+/.test(v) || "E-mail must be valid",
  ],
};
</script>
