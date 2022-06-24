<template>
  <v-card title="Day template" maxWidth="700">
    <v-card-content>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          label="Name"
          v-model="dayTemplate.name"
          :rules="rules.name"
        />
        <v-combobox
          v-model="dayTemplate.forDays"
          :items="Object.keys(DayOfWeek)"
          label="For days"
          multiple
          chips
        />
        <v-row>
          <v-col lg="6">
            <v-text-field
              label="Active start"
              v-model="dayTemplate.activeStart"
              type="time"
            />
          </v-col>
          <v-col lg="6">
            <v-text-field
              label="Active end"
              v-model="dayTemplate.activeEnd"
              type="time"
            />
          </v-col>
        </v-row>

        <v-card
          v-for="(routine, i) in dayTemplate.routines"
          :key="i"
          :title="`Routine #${i + 1}`"
        >
          <v-text-field
            label="Name"
            v-model="routine.name"
            :rules="rules.name"
          />
          <v-row>
            <v-col lg="6">
              <v-text-field
                label="Earliest start"
                v-model="routine.earliestStart"
                type="time"
              />
            </v-col>
            <v-col lg="6">
              <v-text-field
                label="Latest start"
                v-model="routine.latestStart"
                type="time"
              />
            </v-col>
          </v-row>
          <v-row>
            <v-col lg="6">
              <v-text-field
                label="Duration"
                v-model="routine.durationMinutes"
                suffix="minutes"
                type="number"
              />
            </v-col>
            <v-col lg="6">
              <v-select
                v-model="routine.type"
                :items="Object.keys(RoutineType)"
                label="Type"
              />
            </v-col>
          </v-row>

          <v-card-actions>
            <v-btn
              variant="text"
              icon="mdi-close"
              @click="() => removeRoutine(i)"
            />
          </v-card-actions>
        </v-card>
        <v-btn variant="text" icon="mdi-plus" @click="addRoutine" />
      </v-form>
    </v-card-content>
    <v-card-actions>
      <v-btn :disabled="!valid" color="secondary" size="large" @click="submit">
        Save
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
import { ref } from "vue";
import { RoutineType } from "@/model/enums/RoutineType";
import { DayOfWeek } from "@/model/enums/DayOfWeek";
import { useToast } from "vue-toastification";
import { DayTemplate } from "@/model/DayTemplate";
import { createDayTemplate } from "@/services/dayTemplateService";
export default { name: "ActivityForm" };
</script>

<script setup lang="ts">
const toast = useToast();
const dayTemplate = ref<DayTemplate>({
  routines: [],
  name: "",
  forDays: [],
  activeEnd: "00:00",
  activeStart: "00:00",
});
const valid = ref(true);
const submit = () => {
  toast(JSON.stringify(dayTemplate.value));
  createDayTemplate(dayTemplate.value).then(() => toast.success("Added"));
};

const addRoutine = () => {
  dayTemplate.value.routines.push({
    earliestStart: "00:00",
    latestStart: "00:00",
    name: "",
    type: RoutineType.OTHER,
    durationMinutes: 20,
  });
};

const removeRoutine = (i: number) => {
  dayTemplate.value.routines.splice(i, 1);
};

const rules = {
  name: [(v: string) => !!v || "Name is required"],
};
</script>

<style>
.vc-time-date {
  display: none !important;
}
</style>
