package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for various GetJobs APIs
 */
external interface IGetJobsParms {
  /**
   * Owner for which to obtain jobs for.
   *
   * Default: current user
   */
  var owner: String?

  /**
   * Prefix to filter when obtaining jobs.
   *
   * Default: *
   */
  var prefix: String?

  /**
   * Optional parameter to limit the returned data to only jobs that are currently active. This parameter is case-insensitive
   *
   * Default: *
   */
  var status: String?

  /**
   * Max jobs to return in a list
   *
   * Default: JobsConstants.DEFAULT_MAX_JOBS
   */
  var maxJobs: Int?

  /**
   * job id for a job
   */
  var jobid: String?

  /**
   * Return execution data about jobs
   */
  var execData: Boolean?
}
