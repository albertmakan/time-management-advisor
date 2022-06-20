import { CheckListItem } from "./CheckListItem";
import { ActivityContinuityType } from "./enums/ActivityContinuityType";
import { ActivityType } from "./enums/ActivityType";
import { DayOfWeek } from "./enums/DayOfWeek";

export interface Activity {
  id: string;
  title: string;
  description: string;
  checklist: CheckListItem[];
  start: Date;
  end: Date;
  estimatedTimeMinutes: number;
  priority: number;
  continuityType: ActivityContinuityType;
  activityType: ActivityType;
  isArchived: boolean;
  isDone: boolean;
  forDays: DayOfWeek[];
}
