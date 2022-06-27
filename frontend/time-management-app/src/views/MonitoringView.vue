<template>
  <h1>Monitoring</h1>
  <v-btn @click="startStop">Start/stop</v-btn>
</template>

<script lang="ts">
import { createEvent } from "@/services/monitoringService";
import { useToast } from "vue-toastification";
export default {
  name: "MonitoringView",
};
</script>

<script setup lang="ts">
const toast = useToast();
const startStop = () => {
  createEvent().then((s) => toast(s));
};
</script>
