<template>
  <div>
    <h1>Reports</h1>
    <ReportForm />
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";
import ReportForm from "@/components/forms/ReportForm.vue";
export default defineComponent({
  name: "ReportsView",
});
</script>

<script setup lang="ts">
onMounted(() => {
  const a = 1;
});
</script>
