<template>
  <div>
    <v-row v-if="activity?.id" justify="center">
      <ActivityForm :activity-prop="activity" />
    </v-row>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from "vue";
import ActivityForm from "@/components/forms/ActivityForm.vue";
import { useRoute } from "vue-router";
import { Activity } from "@/model/Activity";
import { getById } from "@/services/activityService";

export default defineComponent({
  name: "NewActivityView",
  components: { ActivityForm },
});
</script>

<script setup lang="ts">
const route = useRoute();
const activity = ref<Activity>();
onMounted(() => {
  getById(route.params.id as string).then((a) => (activity.value = a));
});
</script>
