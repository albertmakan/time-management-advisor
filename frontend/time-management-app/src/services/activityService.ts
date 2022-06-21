import { Activity } from "@/model/Activity";
import httpClient from "./httpClient";

export const getAll = () => {
  return httpClient.get<never, Activity[]>(`/activity/all`);
};

export const createActivity = (activity: Activity) => {
  return httpClient.post<never, Activity>(`/activity/new`, activity);
};
