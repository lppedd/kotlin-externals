package zowe.sdk.zos.jobs.doc.input

import zowe.sdk.zos.jobs.MonitorJobs
import zowe.sdk.zos.jobs.types.JobStatus

/**
 * MonitorJobs "waitFor..." APIs parameters interface
 */
external interface IMonitorJobWaitForParms {
  /**
   * The z/OS JOBID for the job to monitor. No pre-validation of the JOBID (other than its presence) is performed.
   * Any errors that you receive regarding invalid JOBID/JOBNAME will be surfaced by z/OSMF. Ensure that your
   * JOBID specification adheres to the z/OS standards.
   */
  var jobid: String

  /**
   * The z/OS JOBNAME for the job to monitor. No pre-validation of the JOBNAME (other than its presence) is performed.
   * Any errors that you receive regarding invalid JOBID/JOBNAME will be surfaced by z/OSMF. Ensure that your
   * JOBNAME specification adheres to the z/OS standards.
   */
  var jobname: String

  /**
   * Watch delay is the polling delay in milliseconds. MonitorJobs will poll every "watchDelay" milliseconds for the
   * status of the job that is being monitored. Use in conjunction with "attempts" to specify your maximum wait
   * for the expected status.
   *
   * Default: [MonitorJobs.DEFAULT_WATCH_DELAY]
   */
  var watchDelay: Int?

  /**
   * The job status (see z/OSMF Jobs REST APIs documentation - and the JOB_STATUS type for possible options) to
   * wait for. Note that if the job's status is "further" along in the logical progression (see the JOB_STATUS
   * documentation for full details) the "waitFor..." API methods will return immediately with the current status.
   *
   * Default: [MonitorJobs.DEFAULT_STATUS].
   */
  var status: JobStatus?

  /**
   * Maximum number of poll attempts. Use in conjunction with "watchDelay" to specify your maximum wait
   * for the expected status.
   *
   * Default: [MonitorJobs.DEFAULT_ATTEMPTS].
   */
  var attempts: Int?

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
