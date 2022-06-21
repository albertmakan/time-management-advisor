<template>
  <v-card width="400" :title="activity.title" :subtitle="activity.description">
    <v-card-text>
      <div>Start: {{ activity.start }}</div>
      <div>End: {{ activity.end }}</div>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
export default { name: "ActivityCard" };
</script>

<script setup lang="ts">
import { Activity } from "@/model/Activity";
import { defineProps } from "vue";
defineProps<{ activity: Activity }>();
</script>
