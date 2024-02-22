@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

/**
 * Constants for various job related info
 */
external class JobsConstants {
  companion object {
    /**
     * Step data query string
     */
    val STEP_DATA: String

    /**
     * Query identifier
     */
    val QUERY_ID: String

    /**
     * Query parm delimiter
     */
    val COMBO_ID: String

    /**
     * Query id for getting job by an owner
     */
    val QUERY_OWNER: String

    /**
     * Query id for getting a job by prefix
     */
    val QUERY_PREFIX: String

    /**
     * Query id for getting a specific job id
     */
    val QUERY_JOBID: String

    /**
     * Query id for getting a specific job id
     */
    val QUERY_STATUS: String

    /**
     * Query id for getting max jobs
     */
    val QUERY_MAX_JOBS: String

    /**
     * Wildcard prefix
     */
    val DEFAULT_PREFIX: String

    /**
     * Maximum number of jobs to obtain
     */
    val DEFAULT_MAX_JOBS: Double

    /**
     * Maximum number of jobs to obtain
     */
    val DEFAULT_STATUS: String

    /**
     * URI base jobs API
     */
    val RESOURCE: String

    /**
     * URI endpoint for getting spool file content
     */
    val RESOURCE_SPOOL_FILES: String

    /**
     * URI endpoint for getting JCL
     */
    val RESOURCE_JCL_CONTENT: String

    /**
     * URI endpoint for getting spool files
     */
    val RESOURCE_SPOOL_CONTENT: String

    /**
     * Cancel request constant
     */
    @JsString("cancel")
    val REQUEST_CANCEL: String

    /**
     * Default version of cancel
     */
    @JsString("2.0")
    val DEFAULT_CANCEL_VERSION: String

    /**
     * Hold a job
     */
    @JsString("hold")
    val REQUEST_HOLD: String

    /**
     * Release a job
     */
    @JsString("release")
    val REQUEST_RELEASE: String

    /**
     * Execution data query string
     */
    val EXEC_DATA: String
  }
}
