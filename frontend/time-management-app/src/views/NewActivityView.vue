<template>
  <div>
    <h1>New activity</h1>
    <ActivityForm />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import ActivityForm from "@/components/forms/ActivityForm.vue";

export default defineComponent({
  name: "NewActivityView",
  components: { ActivityForm },
});
</script>
