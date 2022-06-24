<template>
  <div>
    <h1>My profile</h1>
    <UserForm />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import UserForm from "@/components/forms/UserForm.vue";

export default defineComponent({
  name: "ProfileView",
  components: { UserForm },
});
</script>
