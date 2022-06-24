<template>
  <v-card
    width="400"
    :title="dayTemplate.name"
    :subtitle="dayTemplate.forDays.join(', ')"
  >
    <v-card-text>
      <div>
        Active: {{ timeF(dayTemplate.activeStart) }} -
        {{ timeF(dayTemplate.activeEnd) }}
      </div>
      <v-card
        v-for="routine in dayTemplate.routines"
        :title="routine.name"
        :key="routine.name"
      >
        <v-card-text>
          <div>
            Start: {{ timeF(routine.earliestStart) }} -
            {{ timeF(routine.latestStart) }}
          </div>

          <div>Type: {{ routine.type }}</div>
          <div>Duration: {{ routine.durationMinutes }} minutes</div>
        </v-card-text>
      </v-card>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
import { DayTemplate } from "@/model/DayTemplate";
import { defineProps } from "vue";
export default { name: "DayTemplateCard" };
</script>

<script setup lang="ts">
defineProps<{ dayTemplate: DayTemplate }>();
const timeF = (v: string) => {
  if (!v) return "";
  return v.substring(0, 5);
};
</script>
