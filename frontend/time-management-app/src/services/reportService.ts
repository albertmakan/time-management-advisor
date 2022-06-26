import { Report } from "@/model/Report";
import { ReportRequest } from "@/model/ReportRequest";
import httpClient from "./httpClient";

export const getReport = (request: ReportRequest) => {
  return httpClient.post<never, Report[]>(`/report`, {
    start: request.range.start,
    end: request.range.end,
    ...request,
  });
};
