<template>
  <v-card width="400" :title="activity.title" :subtitle="activity.description">
    <v-card-text>
      <div>Start: {{ activity.start }}</div>
      <div v-if="activity.end">
        End: {{ moment(activity.end).format("YYYY MMMM Do, HH:mm") }}
      </div>
      <div v-if="activity.estimatedTimeMinutes">
        Estimated time: {{ activity.estimatedTimeMinutes }}minutes
      </div>
      <div>Type: {{ activity.activityType }}</div>
      <div>Continuity: {{ activity.continuityType }}</div>
      <div v-if="activity.checklist">
        Checklist: {{ activity.checklist.length }} elements
      </div>
      <div v-if="activity.forDays">
        For days: {{ activity.forDays.join(", ") }} elements
      </div>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
export default { name: "ActivityCard" };
import { Activity } from "@/model/Activity";
import { defineProps } from "vue";
import moment from "moment";
</script>

<script setup lang="ts">
defineProps<{ activity: Activity }>();
</script>
