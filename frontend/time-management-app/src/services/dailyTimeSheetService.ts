import { DailyTimeSheet } from "@/model/DailyTimeSheet";
import moment from "moment";
import httpClient from "./httpClient";

export const getByDay = (date: Date) => {
  return httpClient.get<never, DailyTimeSheet>(
    `/day/${moment(date).format("YYYY-MM-DD")}`
  );
};

export const evalDay = (date: Date) => {
  return httpClient.post<never, DailyTimeSheet>(
    `/day/eval/${moment(date).format("YYYY-MM-DD")}`
  );
};

export const planDay = (date: Date) => {
  return httpClient.post<never, DailyTimeSheet>(
    `/day/plan/${moment(date).format("YYYY-MM-DD")}`
  );
};
