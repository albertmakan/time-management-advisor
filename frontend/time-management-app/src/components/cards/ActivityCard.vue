<template>
  <v-card width="400">
    <v-card-header>
      <v-card-header-text>
        <v-card-title>{{ activity.title }}</v-card-title>
        <v-card-subtitle>{{ activity.description }}</v-card-subtitle>
      </v-card-header-text>
      <v-chip class="ma-2" color="secondary" size="small">
        {{ activity.activityType }}
      </v-chip>
      <v-chip class="ma-2" color="secondary" size="small">
        {{ activity.continuityType }}
      </v-chip>
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
          <v-list-item
            v-if="!activity.isArchived"
            title="Archive"
            @click="() => archive(activity.id)"
          />
          <v-list-item
            v-if="!activity.isDone"
            title="Done"
            @click="() => done(activity.id)"
          />
          <v-list-item title="Edit" @click="() => edit(activity.id)" />
        </v-list>
      </v-menu>
    </v-card-header>
    <v-card-text>
      <div>
        Start: <i>{{ moment(activity.start).format("YYYY MMMM Do, HH:mm") }}</i>
      </div>
      <div v-if="activity.end">
        End: <i>{{ moment(activity.end).format("YYYY MMMM Do, HH:mm") }}</i>
      </div>
      <div v-if="activity.estimatedTimeMinutes">
        Estimated time: {{ activity.estimatedTimeMinutes }} minutes
      </div>
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
import { archiveActivity, markActivityDone } from "@/services/activityService";
</script>

<script setup lang="ts">
defineProps<{ activity: Activity }>();

const archive = (id?: string) => {
  if (confirm("Do you want to archive this activity?"))
    archiveActivity(id).then(() => console.log("archived"));
};
const done = (id?: string) => {
  if (confirm("Do you want to mark this activity as done?"))
    markActivityDone(id).then(() => console.log("done"));
};
const edit = (id?: string) => {
  router.push(`/edit-activity/${id}`);
};
</script>
