import httpClient from "./httpClient";

export const createEvent = () => {
  return httpClient.get<never, string>(`/monitoring/test`);
};
