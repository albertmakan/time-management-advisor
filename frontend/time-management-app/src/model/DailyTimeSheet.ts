import { ActivityInstance } from "./ActivityInstance";

export interface DailyTimeSheet {
  id: string;
  day: Date;
  templateId: string;
  activities: ActivityInstance[];
  evaluation: string;
}
