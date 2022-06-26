<template>
  <v-card width="400">
    <v-card-header>
      <v-card-header-text>
        <v-card-title>{{ activity.title }}</v-card-title>
        <v-card-subtitle>{{ activity.description }}</v-card-subtitle>
      </v-card-header-text>
      <v-icon size="small" icon="mdi-twitter" />
      <v-icon size="small" icon="mdi-twitter" />
      <v-menu location="end">
        <template v-slot:activator="{ props }">
          <v-btn
            size="small"
            variant="text"
            icon="mdi-dots-vertical"
            v-bind="props"
          />
        </template>
        <v-list>
          <v-list-item title="Archive" @click="() => archive(activity.id)" />
          <v-list-item title="Done" @click="() => done(activity.id)" />
          <v-list-item title="Edit" @click="() => edit(activity.id)" />
        </v-list>
      </v-menu>
    </v-card-header>
    <v-card-text>
      <div>
        Start: {{ moment(activity.start).format("YYYY MMMM Do, HH:mm") }}
      </div>
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
        For days: {{ activity.forDays.join(", ") }}
      </div>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
export default { name: "ActivityCard" };
import { Activity } from "@/model/Activity";
import { defineProps } from "vue";
import moment from "moment";
import router from "@/router";
</script>

<script setup lang="ts">
defineProps<{ activity: Activity }>();

const archive = (id?: string) => {
  alert("archive: " + id);
};
const done = (id?: string) => {
  alert("done: " + id);
};
const edit = (id?: string) => {
  alert("edit: " + id);
  router.push(`/edit-activity/${id}`);
};
</script>
