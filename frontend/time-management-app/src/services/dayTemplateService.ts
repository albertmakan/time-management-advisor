import { DayTemplate } from "@/model/DayTemplate";
import httpClient from "./httpClient";

export const getAll = () => {
  return httpClient.get<never, DayTemplate[]>(`/day-template/all`);
};
