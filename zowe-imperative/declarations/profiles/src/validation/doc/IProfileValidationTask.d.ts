import { IProfileValidationTaskResult } from "./IProfileValidationTaskResult";
export declare type VALIDATION_OUTCOME = "Failed" | "OK" | "Warning";
/**
 * A function that takes a profile and calls a done callback with the result of the
 * profile validation
 */
export declare type IProfileValidationTaskFunction = (profile: any, done: (result: IProfileValidationTaskResult) => void) => void;
/**
 * Criterion/task used for testing the validity of a profile
 * You can use any number of these criteria to test different
 * aspects of the profile
 */
export interface IProfileValidationTask {
    /**
     * Long form description of the task you'll  take using the
     * specified profile to test its validity
     */
    description: string;
    /**
     * The short name of a task e.g. "Submitting a job"
     */
    name: string;
    /**
     *  The REST endpoints associated with this task if any,
     *  e.g. ["PUT /zosmf/restjobs/jobs", "GET /zosmf/restjobs/jobs"]
     */
    associatedEndpoints?: string[];
    /**
     * A function which tests the profile with your tasks
     * Ultimately the result of this function is what determines whether
     * the profile is valid or not for this task
     */
    taskFunction: IProfileValidationTaskFunction;
    /**
     * Any tasks you would like to only run if the current task succeeds
     * (skipped on warning or failure of this, the parent task)
     */
    dependentTasks?: IProfileValidationTask[];
}
