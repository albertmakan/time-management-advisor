import { Activity } from "@/model/Activity";
import httpClient from "./httpClient";

export const getAll = () => {
  return httpClient.get<never, Activity[]>(`/activity/all`);
};
