<template>
  <div>
    <h1>{{ a }} Activities</h1>
    <v-row>
      <v-btn @click="() => fetchActivities('active')">Active</v-btn>
      <v-btn @click="() => fetchActivities('archived')">Archived</v-btn>
      <v-btn @click="() => fetchActivities('done')">Done</v-btn>
    </v-row>
    <v-row>
      <ActivityCard v-for="a in activities" :activity="a" :key="a.id" />
    </v-row>
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
const a = ref("active");
onMounted(() => {
  fetchActivities("active");
});

const fetchActivities = (s: "active" | "done" | "archived") => {
  getAll(s).then((a) => (activities.value = a));
  a.value = s;
};
</script>
