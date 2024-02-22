/**
 * Job error interface
 * @export
 * @interface IJobError
 */
export interface IJobError {
    /**
     * Return code number
     * @type {number}
     * @memberof IJobError
     */
    rc: number;
    /**
     * Reason code number
     * @type {number}
     * @memberof IJobError
     */
    reason: number;
    /**
     * Stack info
     * @type {string}
     * @memberof IJobError
     */
    stack: string;
    /**
     * Category error number
     * @type {number}
     * @memberof IJobError
     */
    category: number;
    /**
     * z/OSMF error message
     * @type {string}
     * @memberof IJobError
     */
    message: string;
}
