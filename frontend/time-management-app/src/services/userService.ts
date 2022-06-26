import { User } from "@/model/User";
import httpClient from "./httpClient";

export const createUser = (user: User) => {
  return httpClient.post<never, User>(`/user/new`, user);
};
