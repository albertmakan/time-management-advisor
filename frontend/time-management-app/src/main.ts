import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";
import { loadFonts } from "./plugins/webfontloader";
import Toast from "vue-toastification";
import VCalendar from "v-calendar";
import "vue-toastification/dist/index.css";
import "v-calendar/dist/style.css";

loadFonts();

createApp(App)
  .use(router)
  .use(vuetify)
  .use(Toast)
  .use(VCalendar, {})
  .mount("#app");
