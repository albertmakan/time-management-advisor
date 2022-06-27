import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import ActivitiesView from "../views/ActivitiesView.vue";
import RoutinesView from "../views/RoutinesView.vue";
import NewActivityView from "../views/NewActivityView.vue";
import EditActivityView from "../views/EditActivityView.vue";
import CalendarView from "../views/CalendarView.vue";
import ReportsView from "../views/ReportsView.vue";
import ProfileView from "../views/ProfileView.vue";
import MonitoringView from "../views/MonitoringView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/activities",
    name: "activities",
    component: ActivitiesView,
  },
  {
    path: "/routines",
    name: "routines",
    component: RoutinesView,
  },
  {
    path: "/new-activity",
    name: "new-activity",
    component: NewActivityView,
  },
  {
    path: "/calendar",
    name: "calendar",
    component: CalendarView,
  },
  {
    path: "/reports",
    name: "reports",
    component: ReportsView,
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
  },
  {
    path: "/edit-activity/:id",
    name: "edit-activity",
    component: EditActivityView,
  },
  {
    path: "/monitoring",
    name: "monitoring",
    component: MonitoringView,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
