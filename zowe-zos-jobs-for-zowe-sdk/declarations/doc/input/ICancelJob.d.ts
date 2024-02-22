/**
 * Interface for payload to cancel a job.
 * @export
 * @interface ICancelJob
 */
export interface ICancelJob {
    /**
     * "cancel" is currently the only valid value
     * @type {string}
     * @memberof ICancelJob
     */
    request: string;
    /**
     * Version, at the time of writing, 1.0 or 2.0 are accepted.
     * @type {string}
     * @memberof ICancelJob
     */
    version: string;
}
