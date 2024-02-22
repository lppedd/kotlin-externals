/**
 * Interface for change job z/OSMF API
 * @export
 * @interface IModifyJobOptions
 */
export interface IModifyJobOptions {
    /**
     * new job class to change job to
     * @type {string}
     * @memberof IModifyJobOptions
     */
    jobclass?: string;
    /**
     * specify this option as `true` when wanting to hold your job
     * @type {boolean}
     * @memberof IModifyJobOptions
     */
    hold?: boolean;
    /**
     * specify this option as `true` when wanting to release your job
     * @type {boolean}
     * @memberof IModifyJobOptions
     */
    release?: boolean;
}
