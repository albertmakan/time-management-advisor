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
        <v-btn
          size="x-small"
          variant="text"
          :icon="activity.show ? 'mdi-chevron-up' : 'mdi-chevron-down'"
          @click="activity.show = !activity.show"
        ></v-btn>

        <v-expand-transition>
          <div v-show="activity.show">
            <v-divider></v-divider>
            <v-card-text>
              {{ activity.description }}
            </v-card-text>
            <v-card-actions>
              <v-btn color="secondary" size="small">save</v-btn>
              <v-btn v-if="activity.activityId" color="error" size="small">
                postpone
              </v-btn>
            </v-card-actions>
          </div>
        </v-expand-transition>
      </v-card>
    </v-card-text>
    <v-card-actions>
      <v-btn color="secondary" variant="flat">EVAL</v-btn>
    </v-card-actions>
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
