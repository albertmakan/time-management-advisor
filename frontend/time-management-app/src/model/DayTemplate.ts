import { DayOfWeek } from "./enums/DayOfWeek";
import { Routine } from "./Routine";

export interface DayTemplate {
  id?: string;
  name: string;
  routines: Routine[];
  activeStart: string; //Date;
  activeEnd: string; //Date;
  forDays: DayOfWeek[];
}
