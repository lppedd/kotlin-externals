import { TaskStage } from "../TaskStage";
/**
 * Implement this interface to be able to be tracked by the CLI progress bar or
 * GUIs
 */
export interface ITaskWithStatus {
    /**
     * What percentage complete is your task right now?
     */
    percentComplete: number;
    /**
     * A very short message describing what is being worked on
     */
    statusMessage: string;
    /**
     * Describe the overall status of the task. If the task fails while
     * in progress, you can set this to TaskStage.FAILED
     */
    stageName: TaskStage;
}
/**
 * A promise object that also can be tracked for progress bars/ GUIS
 */
export interface IPromiseWithProgress<T> extends Promise<T> {
    progress: ITaskWithStatus;
}
