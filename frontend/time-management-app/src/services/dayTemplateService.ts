import { DayTemplate } from "@/model/DayTemplate";
import httpClient from "./httpClient";

export const getAll = () => {
  return httpClient.get<never, DayTemplate[]>(`/day-template/all`);
};

export const createDayTemplate = (dayTemplate: DayTemplate) => {
  return httpClient.post<never, DayTemplate>(`/day-template/new`, dayTemplate);
};
