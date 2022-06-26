<template>
  <div>
    <h1>Reports</h1>
    <ReportForm @report="handleReport" />
    <v-table>
      <thead>
        <tr>
          <th>Day</th>
          <th>Titles</th>
          <th>Duration in mins</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, i) in result" :key="i">
          <td>{{ item.day }}</td>
          <td>{{ item.titles }}</td>
          <td>{{ item.duration }}</td>
        </tr>
      </tbody>
    </v-table>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import ReportForm from "@/components/forms/ReportForm.vue";
import { ReportRequest } from "@/model/ReportRequest";
import { getReport } from "@/services/reportService";
import { Report } from "@/model/Report";
export default defineComponent({
  name: "ReportsView",
});
</script>

<script setup lang="ts">
const result = ref<Report[]>([]);
const handleReport = (request: ReportRequest) => {
  getReport(request).then((r) => (result.value = r));
};
</script>
