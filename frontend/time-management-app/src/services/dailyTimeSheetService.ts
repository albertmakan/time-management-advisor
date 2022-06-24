import { DailyTimeSheet } from "@/model/DailyTimeSheet";
import httpClient from "./httpClient";

export const getByDay = (date: Date) => {
  return httpClient.get<never, DailyTimeSheet>(
    `/day/${date.toISOString().substring(0, 10)}`
  );
};
