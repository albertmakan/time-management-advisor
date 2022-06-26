<template>
  <h1>Routines</h1>
  <v-row>
    <DayTemplateCard
      v-for="dt in dayTemplates"
      :day-template="dt"
      :key="dt.id"
    />
    <v-btn @click="showForm = true">New day template</v-btn>
  </v-row>
  <DayTemplateForm v-if="showForm" />
</template>

<script lang="ts">
import { getAll } from "@/services/dayTemplateService";
import { onMounted, ref } from "vue";
import { DayTemplate } from "@/model/DayTemplate";
import DayTemplateCard from "@/components/cards/DayTemplateCard.vue";
import DayTemplateForm from "@/components/forms/DayTemplateForm.vue";
export default {
  name: "ActivitiesView",
};
</script>

<script setup lang="ts">
const dayTemplates = ref<DayTemplate[]>([]);
const showForm = ref(false);
onMounted(() => {
  getAll().then((d) => (dayTemplates.value = d));
});
</script>
