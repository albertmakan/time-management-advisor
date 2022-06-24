import errorHandler from "./errorHandler";

import axios, { AxiosRequestTransformer } from "axios";
import moment from "moment";

const dateTransformer: AxiosRequestTransformer = (data) => {
  if (data instanceof Date) {
    return moment(data).format().substring(0, 16);
  }
  if (Array.isArray(data)) {
    return data.map((val) => dateTransformer(val));
  }
  if (typeof data === "object" && data !== null) {
    return Object.fromEntries(
      Object.entries(data).map(([key, val]) => [key, dateTransformer(val)])
    );
  }
  return data;
};

const httpClient = axios.create({
  baseURL: "http://localhost:8098/api",
  headers: {
    Authorization: `Bearer ${localStorage.getItem("token")}`,
  },
  transformRequest: [
    dateTransformer,
    ...(axios.defaults.transformRequest as AxiosRequestTransformer[]),
  ],
});

httpClient.interceptors.response.use(
  (response) => {
    return response.data;
  },
  (error) => {
    errorHandler(error.response);
    return Promise.reject(error);
  }
);

export default httpClient;
