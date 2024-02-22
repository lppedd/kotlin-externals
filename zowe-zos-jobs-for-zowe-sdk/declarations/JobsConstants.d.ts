/**
 * Constants for various job related info
 * @export
 * @class JobsConstants
 */
export declare class JobsConstants {
    /**
     * Step data query string
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly STEP_DATA: string;
    /**
     * Query identifier
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly QUERY_ID: string;
    /**
     * Query parm delimiter
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly COMBO_ID: string;
    /**
     * Query id for getting job by an owner
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly QUERY_OWNER: string;
    /**
     * Query id for getting a job by prefix
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly QUERY_PREFIX: string;
    /**
     * Query id for getting a specific job id
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly QUERY_JOBID: string;
    /**
     * Query id for getting a specific job id
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly QUERY_STATUS: string;
    /**
     * Query id for getting max jobs
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly QUERY_MAX_JOBS: string;
    /**
     * Wildcard prefix
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly DEFAULT_PREFIX: string;
    /**
     * Maximum number of jobs to obtain
     * @static
     * @type {number}
     * @memberof JobsConstants
     */
    static readonly DEFAULT_MAX_JOBS: number;
    /**
     * Maximum number of jobs to obtain
     * @static
     * @type {number}
     * @memberof JobsConstants
     */
    static readonly DEFAULT_STATUS: string;
    /**
     * URI base jobs API
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly RESOURCE: string;
    /**
     * URI endpoint for getting spool file content
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly RESOURCE_SPOOL_FILES: string;
    /**
     * URI endpoint for getting JCL
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly RESOURCE_JCL_CONTENT: string;
    /**
     * URI endpoint for getting spool files
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly RESOURCE_SPOOL_CONTENT: string;
    /**
     * Cancel request constant
     * @static
     * @memberof JobsConstants
     */
    static readonly REQUEST_CANCEL = "cancel";
    /**
     * Default version of cancel
     * @static
     * @memberof JobsConstants
     */
    static readonly DEFAULT_CANCEL_VERSION = "2.0";
    /**
     * Hold a job
     * @static
     * @memberof JobsConstants
     */
    static readonly REQUEST_HOLD = "hold";
    /**
     * Release a job
     * @static
     * @memberof JobsConstants
     */
    static readonly REQUEST_RELEASE = "release";
    /**
     * Execution data query string
     * @static
     * @type {string}
     * @memberof JobsConstants
     */
    static readonly EXEC_DATA: string;
}
