import { DailyTimeSheet } from "@/model/DailyTimeSheet";
import httpClient from "./httpClient";

export const getByDay = (date: Date) => {
  return httpClient.get<never, DailyTimeSheet>(
    `/day/${date.toISOString().substring(0, 10)}`
  );
};

export const evalDay = (date: Date) => {
  return httpClient.post<never, DailyTimeSheet>(
    `/day/eval/${date.toISOString().substring(0, 10)}`
  );
};

export const planDay = (date: Date) => {
  return httpClient.post<never, DailyTimeSheet>(
    `/day/plan/${date.toISOString().substring(0, 10)}`
  );
};
