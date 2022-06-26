import { ActivityType } from "./enums/ActivityType";

export interface ReportRequest {
  range: { start: Date; end: Date };
  activityIds: string[];
  activityTypes: ActivityType[];
}
