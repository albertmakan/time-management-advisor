import axios from "axios";
import errorHandler from "./errorHandler";

const httpClient = axios.create({
  baseURL: "http://localhost:8098/api",
  headers: {
    Authorization: `Bearer ${localStorage.getItem("token")}`,
  },
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
