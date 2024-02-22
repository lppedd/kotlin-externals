package zowe.sdk.zos.jobs.doc.input

import zowe.sdk.zos.jobs.MonitorJobs
import zowe.sdk.zos.jobs.types.JobStatus

/**
 * Interface for submit job API
 */
external interface ISubmitJobNotifyParm {
  /**
   * z/OS data set which should contain syntactically correct JCL
   * Example value: IBMUSER.PUBLIC.CNTL(IEFBR14)
   * where IEFBR14 contains statements like:
   * ```
   * //IEFBR14 JOB ()
   * //RUN     EXEC PGM=IEFBR14
   * ```
   */
  var jobDataSet: String

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
