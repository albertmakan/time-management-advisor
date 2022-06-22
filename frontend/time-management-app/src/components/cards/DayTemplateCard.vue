<template>
  <v-card
    width="400"
    :title="dayTemplate.name"
    :subtitle="dayTemplate.forDays.join(', ')"
  >
    <v-card-text>
      <v-card
        width="350"
        v-for="routine in dayTemplate.routines"
        :title="routine.name"
        :key="routine.name"
      >
      </v-card>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
export default { name: "DayTemplateCard" };
</script>

<script setup lang="ts">
import { DayTemplate } from "@/model/DayTemplate";
import { defineProps } from "vue";
defineProps<{ dayTemplate: DayTemplate }>();
</script>
