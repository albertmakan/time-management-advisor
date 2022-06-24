import { RoutineType } from "./enums/RoutineType";

export interface Routine {
  name: string;
  type: RoutineType;
  earliestStart: string; //Date;
  latestStart: string; //Date;
  durationMinutes: number;
}
