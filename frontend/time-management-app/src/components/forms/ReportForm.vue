<template>
  <v-card maxWidth="700">
    <v-card-content>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-combobox
          v-model="request.activityTypes"
          :items="Object.keys(ActivityType)"
          label="Types"
          multiple
          chips
        />
        <v-date-picker v-model="request.range" is-range />
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
import { ref } from "vue";
import { useToast } from "vue-toastification";
import { ReportRequest } from "@/model/ReportRequest";
import { ActivityType } from "@/model/enums/ActivityType";
export default { name: "ReportForm" };
</script>

<script setup lang="ts">
const toast = useToast();
const request = ref<ReportRequest>({
  range: { start: new Date(), end: new Date() },
  activityIds: [],
  activityTypes: [],
});
const valid = ref(true);
const submit = () => {
  toast(JSON.stringify(request.value));
};
</script>
