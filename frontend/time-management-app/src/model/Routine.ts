import { RoutineType } from "./enums/RoutineType";

export interface Routine {
  name: string;
  type: RoutineType;
  earliestStart: Date;
  latestStart: Date;
  durationMinutes: number;
}
