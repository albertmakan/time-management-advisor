<template>
  <div>
    <h1>Activities</h1>
    <ActivityCard v-for="a in activities" :activity="a" :key="a.id" />
  </div>
</template>

<script lang="ts">
import { getAll } from "@/services/activityService";
import { Activity } from "@/model/Activity";
import ActivityCard from "@/components/cards/ActivityCard.vue";
import { onMounted, ref } from "vue";
export default { name: "ActivitiesView" };
</script>

<script setup lang="ts">
const activities = ref<Activity[]>([]);
onMounted(() => {
  getAll().then((a) => (activities.value = a));
});
</script>
