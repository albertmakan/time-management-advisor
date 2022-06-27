import { Activity } from "@/model/Activity";
import httpClient from "./httpClient";

export const getAll = (s: "active" | "done" | "archived") => {
  return httpClient.get<never, Activity[]>(`/activity/all/${s}`);
};

export const getById = (id: string) => {
  return httpClient.get<never, Activity>(`/activity/${id}`);
};

export const createActivity = (activity: Activity) => {
  return httpClient.post<never, Activity>(`/activity/new`, activity);
};

export const editActivity = (activity: Activity) => {
  return httpClient.put<never, Activity>(`/activity/edit`, activity);
};

export const archiveActivity = (id?: string) => {
  return httpClient.put<never, Activity>(`/activity/archive/${id}`);
};

export const markActivityDone = (id?: string) => {
  return httpClient.put<never, Activity>(`/activity/mark-done/${id}`);
};
