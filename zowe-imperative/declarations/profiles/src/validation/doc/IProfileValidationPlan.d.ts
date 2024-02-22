import { IProfileValidationTask } from "./IProfileValidationTask";
/**
 * An overall plan for validating a profile, composed of multiple tasks
 */
export interface IProfileValidationPlan {
    /**
     * The tasks to run to validate the profile.
     * They will be run sequentially in the order specified.
     */
    tasks: IProfileValidationTask[];
    /**
     * Suggestions to the user that will be displayed in the validation
     * report in the event profile validation is not successful.
     */
    failureSuggestions?: string;
}
