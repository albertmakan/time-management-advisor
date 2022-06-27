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
      Evaluation:
      {{ timeSheet.evaluation }}
    </v-card-text>
    <v-card-actions>
      <v-btn
        v-if="timeSheet.id && !timeSheet.evaluation"
        color="secondary"
        variant="flat"
        @click="() => handleEval(timeSheet.day)"
      >
        Eval
      </v-btn>
      <v-btn
        v-if="!timeSheet.evaluation && notInPast(timeSheet.day)"
        color="secondary"
        variant="flat"
        @click="() => handlePlan(timeSheet.day)"
      >
        Plan
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
export default { name: "DailyTimeSheetCard" };
import { DailyTimeSheet } from "@/model/DailyTimeSheet";
import { defineProps } from "vue";
import moment from "moment";
import { evalDay, planDay } from "@/services/dailyTimeSheetService";
import { useToast } from "vue-toastification";
</script>

<script setup lang="ts">
const toast = useToast();
defineProps<{ timeSheet: DailyTimeSheet }>();
const timeF = (v: string) => {
  if (!v) return "";
  return v.substring(0, 5);
};

const handleEval = (day: Date) => {
  evalDay(day).then(() => toast.success("Evaluated"));
};

const handlePlan = (day: Date) => {
  planDay(day).then(() => toast.success("Planned"));
};

const notInPast = (day: Date) => !moment(day).isBefore(moment().startOf("day"));
</script>
