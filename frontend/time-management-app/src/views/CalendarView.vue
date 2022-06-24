<template>
  <div>
    <h1>Calendar</h1>
    <v-row>
      <DailyTimeSheetCard v-if="timeSheet.day" :time-sheet="timeSheet" />
      <div v-else>NOT FOUND</div>
      <v-date-picker v-model="date" />
    </v-row>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted, watch } from "vue";
import DailyTimeSheetCard from "@/components/cards/DailyTimeSheetCard.vue";
import { DailyTimeSheet } from "@/model/DailyTimeSheet";
import { getByDay } from "@/services/dailyTimeSheetService";

export default defineComponent({
  name: "CalendarView",
  components: { DailyTimeSheetCard },
});
</script>

<script setup lang="ts">
const timeSheet = ref<DailyTimeSheet>({} as DailyTimeSheet);
const date = ref<Date>(new Date());
onMounted(() => {
  getByDay(new Date()).then((ts) => (timeSheet.value = ts));
});
watch(
  () => date.value,
  (newDate) => {
    getByDay(newDate).then((ts) => (timeSheet.value = ts));
  }
);
</script>
