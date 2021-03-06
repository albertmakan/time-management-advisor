/* eslint-disable @typescript-eslint/no-explicit-any */
import { useToast } from "vue-toastification";

const toast = useToast();

const errorHandler = (errorResponse: any) => {
  if (!errorResponse) {
    toast.error("The server is unavailable.");
    return;
  }
  let message = errorResponse.data;
  if (errorResponse.data?.message) {
    message = errorResponse.data?.message;
  }
  message = JSON.stringify(message);
  switch (errorResponse.status) {
    case 400:
      toast.error("Bad request - " + message);
      break;

    case 401:
      toast.error("Unauthorized - " + message);
      break;

    case 403:
      toast.error(
        "Forbidden - The client did not have permission to access the requested resource."
      );
      break;

    case 404:
      toast.error("Not found - " + message);
      break;

    case 409:
      toast.error("Conflict - " + message);
      break;

    case 500:
      toast.error("Internal server error.");
      break;

    case 503:
      toast.error("The server was unavailable.");
      break;

    default:
      toast.error("Something wrong");
      break;
  }
};

export default errorHandler;
