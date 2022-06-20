<template>
  <div>
    <h1>Activities</h1>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { getAll } from "@/services/activityService";
import { Activity } from "@/model/Activity";

export default defineComponent({
  name: "ActivitiesView",
  data() {
    return {
      activities: [] as Activity[],
    };
  },
  mounted() {
    alert("AAAAAAAAAAAAAAAAAAAAA");
    getAll().then((a) => (this.activities = a));
  },
  methods: {},
});
</script>
