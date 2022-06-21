<template>
  <v-card title="New activity" maxWidth="700">
    <v-card-content>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          label="Title"
          v-model="activity.title"
          :rules="rules.title"
        />
        <v-textarea
          rows="2"
          label="Description"
          v-model="activity.description"
        />
        <v-row>
          <v-col lg="6">
            <label>Start</label>
            <v-date-picker
              v-model="activity.start"
              :update-on-input="false"
              mode="datetime"
            >
              <template v-slot="{ inputValue, inputEvents }">
                <v-text-field :value="inputValue" v-on="inputEvents" />
              </template>
            </v-date-picker>
          </v-col>
          <v-col lg="6">
            <label>End</label>
            <v-date-picker
              v-model="activity.end"
              :update-on-input="false"
              mode="datetime"
            >
              <template v-slot="{ inputValue, inputEvents }">
                <v-text-field :value="inputValue" v-on="inputEvents" />
              </template>
            </v-date-picker>
          </v-col>
        </v-row>
        <v-text-field
          label="Estimated time"
          v-model="activity.estimatedTimeMinutes"
          suffix="minutes"
          type="number"
        />
        <v-row>
          <v-col lg="6">
            <v-select
              v-model="activity.activityType"
              :items="Object.keys(ActivityType)"
              label="Type"
            />
          </v-col>
          <v-col lg="6">
            <v-select
              v-model="activity.continuityType"
              :items="Object.keys(ActivityContinuityType)"
              label="Continuity type"
            />
          </v-col>
        </v-row>
        <v-combobox
          v-if="activity.continuityType === ActivityContinuityType.PERIODIC"
          v-model="activity.forDays"
          :items="Object.keys(DayOfWeek)"
          label="For days"
          multiple
          chips
        />
        <v-list
          v-if="activity.continuityType === ActivityContinuityType.CONTINUAL"
          density="compact"
        >
          <v-list-item title="Checklist">
            <template v-slot:append>
              <v-btn
                variant="text"
                icon="mdi-plus-circle"
                @click="showinput = true"
              />
            </template>
          </v-list-item>
          <v-list-item
            v-for="li in activity.checklist"
            :key="li.name"
            prepend-icon="mdi-checkbox-blank"
            :title="li.name"
            :subtitle="li.duration + 'min'"
          >
            <template v-slot:append>
              <v-btn
                variant="text"
                icon="mdi-close"
                @click="() => removeItem(li.name)"
              />
            </template>
          </v-list-item>
          <v-list-item v-if="showinput">
            <template v-slot:append>
              <v-row>
                <v-col lg="8">
                  <v-text-field label="name" v-model="newitem.name" />
                </v-col>
                <v-col lg="4">
                  <v-text-field
                    label="duration"
                    suffix="min"
                    type="number"
                    v-model="newitem.duration"
                  />
                </v-col>
              </v-row>
              <v-btn variant="text" icon="mdi-check" @click="addItem" />
            </template>
          </v-list-item>
        </v-list>
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
import { Activity } from "@/model/Activity";
import { ref } from "vue";
import { ActivityType } from "@/model/enums/ActivityType";
import { ActivityContinuityType } from "@/model/enums/ActivityContinuityType";
import { DayOfWeek } from "@/model/enums/DayOfWeek";
import { createActivity } from "@/services/activityService";
import { useToast } from "vue-toastification";
import { CheckListItem } from "@/model/CheckListItem";
export default { name: "ActivityForm" };
</script>

<script setup lang="ts">
const toast = useToast();
const activity = ref<Activity>({} as Activity);
const valid = ref(true);
const submit = () => {
  console.log(JSON.stringify(activity.value));
  createActivity(activity.value).then(() => toast.success("Added"));
};

const showinput = ref(false);
const newitem = ref<CheckListItem>({} as CheckListItem);
const addItem = () => {
  activity.value.checklist ??= [];
  activity.value.checklist.push(newitem.value);
  newitem.value = {} as CheckListItem;
  showinput.value = false;
};
const removeItem = (name: string) => {
  activity.value.checklist = activity.value.checklist?.filter(
    (li) => li.name !== name
  );
};

const rules = {
  title: [(v: string) => !!v || "Title is required"],
};
</script>
