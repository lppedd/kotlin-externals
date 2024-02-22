package zowe.sdk.zos.jobs.doc.input

import zowe.sdk.zos.jobs.MonitorJobs
import zowe.sdk.zos.jobs.types.JobStatus

/**
 * Interface for submiting jobs API
 */
external interface ISubmitJclNotifyParm {
  /**
   * JCL to submit, for example:
   * ```
   * "//IEFBR14 JOB ()\n" +
   * "//RUN     EXEC PGM=IEFBR14"
   * ```
   */
  var jcl: String

  /**
   * Specify internal reader RECFM and corresponding http(s) headers
   * will be appended to the request accordingly
   * "F" (fixed) or "V" (variable)
   */
  var internalReaderRecfm: String?

  /**
   * Specify internal reader LRECL and corresponding http(s) headers
   * will be appended to the request accordingly
   */
  var internalReaderLrecl: String?

  /**
   * Watch delay (polling delay) that the underlying services will use
   * to report whenever a job is complete in milliseconds.
   *
   * Default: [MonitorJobs.DEFAULT_WATCH_DELAY]
   */
  var watchDelay: Int?

  /**
   * Status for which you'd like to be notified of a completed job.
   *
   * Default: [MonitorJobs.DEFAULT_STATUS].
   */
  var status: JobStatus?

  /**
   * Number of attempts for which will poll before ending.
   *
   * Default: [MonitorJobs.DEFAULT_ATTEMPTS].
   */
  var attempts: Int?

  /**
   * A string for JCL symbolic substitution
   */
  var jclSymbols: String?
}
