<template>
  <v-card :title="activity.id ? 'Edit activity' : 'New activity'" width="700">
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
              is24hr
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
              is24hr
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
            v-for="(li, i) in activity.checklist"
            :key="i"
            prepend-icon="mdi-checkbox-blank"
            :title="li.name"
            :subtitle="li.duration + 'min'"
          >
            <template v-slot:append>
              <v-btn
                variant="text"
                icon="mdi-close"
                @click="() => removeItem(i)"
              />
            </template>
          </v-list-item>
          <v-list-item v-if="showinput">
            <template v-slot:append>
              <v-row>
                <v-col lg="8">
                  <v-text-field label="name" v-model="newitem.name" />
                </v-col>
                <v-col lg="3">
                  <v-text-field
                    label="duration"
                    suffix="min"
                    type="number"
                    v-model="newitem.duration"
                  />
                </v-col>
                <v-col lg="1">
                  <v-btn
                    variant="text"
                    icon="mdi-check"
                    @click="addItem"
                    :disabled="!newitem.name || !newitem.duration"
                  />
                </v-col>
              </v-row>
            </template>
          </v-list-item>
        </v-list>
      </v-form>
    </v-card-content>
    <v-card-actions>
      <v-btn
        :disabled="!valid"
        color="secondary"
        variant="flat"
        size="large"
        @click="submit"
      >
        Save
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
import { Activity } from "@/model/Activity";
import { ref, defineProps, toRefs } from "vue";
import { ActivityType } from "@/model/enums/ActivityType";
import { ActivityContinuityType } from "@/model/enums/ActivityContinuityType";
import { DayOfWeek } from "@/model/enums/DayOfWeek";
import { createActivity, editActivity } from "@/services/activityService";
import { useToast } from "vue-toastification";
import { CheckListItem } from "@/model/CheckListItem";
export default { name: "ActivityForm" };
</script>

<script setup lang="ts">
const props = defineProps<{ activityProp: Activity | undefined }>();
const toast = useToast();
const activity = ref<Activity>({ start: new Date() } as Activity);
const { activityProp } = toRefs(props);
if (activityProp.value) activity.value = activityProp.value;

const valid = ref(true);
const submit = () => {
  console.log(JSON.stringify(activity.value));
  if (activity.value.id)
    editActivity(activity.value).then(() => toast.success("Updated"));
  else createActivity(activity.value).then(() => toast.success("Added"));
};

const showinput = ref(false);
const newitem = ref<CheckListItem>({} as CheckListItem);
const addItem = () => {
  activity.value.checklist ??= [];
  activity.value.checklist.push(newitem.value);
  newitem.value = {} as CheckListItem;
  showinput.value = false;
};
const removeItem = (i: number) => {
  activity.value.checklist.splice(i, 1);
};

const rules = {
  title: [(v: string) => !!v || "Title is required"],
};
</script>
