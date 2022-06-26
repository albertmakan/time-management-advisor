<template>
  <v-card maxWidth="700">
    <v-card-content>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-row>
          <v-combobox
            class="md-4"
            v-model="request.activityTypes"
            :items="Object.keys(ActivityType)"
            label="Types"
            multiple
            chips
          />
          <v-date-picker v-model="request.range" is-range />
        </v-row>
      </v-form>
    </v-card-content>
    <v-card-actions>
      <v-btn :disabled="!valid" color="secondary" size="large" @click="submit">
        Find
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
import { ref, defineEmits } from "vue";
import { ReportRequest } from "@/model/ReportRequest";
import { ActivityType } from "@/model/enums/ActivityType";
export default { name: "ReportForm" };
</script>

<script setup lang="ts">
const request = ref<ReportRequest>({
  range: { start: new Date(), end: new Date() },
  activityIds: [],
  activityTypes: [],
  byIds: false,
});
const emit = defineEmits(["report"]);
const valid = ref(true);
const submit = () => {
  emit("report", request.value);
};
</script>
