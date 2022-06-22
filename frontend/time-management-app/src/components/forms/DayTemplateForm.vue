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
            <label>Active start</label>
            <v-date-picker
              v-model="dayTemplate.activeStart"
              mode="time"
              is24hr
            />
          </v-col>
          <v-col lg="6">
            <label>Active end</label>
            <v-date-picker v-model="dayTemplate.activeEnd" mode="time" is24hr />
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
              <label>Earliest start</label>
              <v-date-picker
                v-model="routine.earliestStart"
                mode="time"
                is24hr
              />
            </v-col>
            <v-col lg="6">
              <label>Latest start</label>
              <v-date-picker v-model="routine.latestStart" mode="time" is24hr />
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
export default { name: "ActivityForm" };
</script>

<script setup lang="ts">
const toast = useToast();
const dayTemplate = ref<DayTemplate>({
  routines: [],
  name: "",
  forDays: [],
  activeEnd: new Date(),
  activeStart: new Date(),
});
const valid = ref(true);
const submit = () => {
  toast(JSON.stringify(dayTemplate.value));
  // createActivity(dayTemplate.value).then(() => toast.success("Added"));
};

const addRoutine = () => {
  dayTemplate.value.routines.push({
    earliestStart: new Date(),
    latestStart: new Date(),
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
