/**
 * Describes the current stage/status of a task in your CLI
 * Used in operation infrastructure and for progress bars
 */
export declare enum TaskStage {
    IN_PROGRESS = 0,
    COMPLETE = 1,
    NOT_STARTED = 2,
    FAILED = 3
}
