import { CheckListItem } from "./CheckListItem";
import { ActivityType } from "./enums/ActivityType";

export interface ActivityInstance {
  activityId: string;
  title: string;
  description: string;
  checklist: CheckListItem[];
  start: string; //Date;
  end: string; //Date;
  activityType: ActivityType;
}
