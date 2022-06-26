import { Activity } from "@/model/Activity";
import httpClient from "./httpClient";

export const getAll = () => {
  return httpClient.get<never, Activity[]>(`/activity/all`);
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
