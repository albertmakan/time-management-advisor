import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";
import { loadFonts } from "./plugins/webfontloader";
import Toast from "vue-toastification";

loadFonts();

createApp(App).use(router).use(vuetify).use(Toast).mount("#app");
