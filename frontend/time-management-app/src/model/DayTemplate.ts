import { DayOfWeek } from "./enums/DayOfWeek";
import { Routine } from "./Routine";

export interface DayTemplate {
  id?: string;
  name: string;
  routines: Routine[];
  activeStart: Date;
  activeEnd: Date;
  forDays: DayOfWeek[];
}
