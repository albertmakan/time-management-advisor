import { ReportRequest } from "@/model/ReportRequest";
import httpClient from "./httpClient";

export const getReport = (request: ReportRequest) => {
  return httpClient.post<never, any[]>(`/report`, {});
};
