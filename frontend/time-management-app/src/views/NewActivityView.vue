<template>
  <div>
    <v-row justify="center"><ActivityForm :activity-prop="undefined" /></v-row>
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
