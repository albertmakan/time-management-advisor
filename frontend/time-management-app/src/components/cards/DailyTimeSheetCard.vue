<template>
  <v-card
    width="500"
    :title="moment(timeSheet.day).format('dddd, MMMM Do YYYY')"
  >
    <v-card-text>
      <v-card
        width="350"
        v-for="(activity, i) in timeSheet.activities"
        :title="activity.title"
        :subtitle="`${timeF(activity.start)}-${timeF(activity.end)}`"
        :key="i"
      >
      </v-card>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
export default { name: "DailyTimeSheetCard" };
import { DailyTimeSheet } from "@/model/DailyTimeSheet";
import { defineProps } from "vue";
import moment from "moment";
</script>

<script setup lang="ts">
defineProps<{ timeSheet: DailyTimeSheet }>();
const timeF = (v: string) => {
  if (!v) return "";
  return v.substring(0, 5);
};
</script>
