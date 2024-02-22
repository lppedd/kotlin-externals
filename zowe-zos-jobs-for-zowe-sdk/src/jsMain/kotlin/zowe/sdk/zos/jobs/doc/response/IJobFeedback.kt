package zowe.sdk.zos.jobs.doc.response

/**
 * Job feedback interface
 */
external interface IJobFeedback {
  /**
   * job id for a job
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String

  /**
   * Original job id
   */
  // "original-jobid": string;

  /**
   * Job owner
   */
  var owner: String

  /**
   * Member
   */
  var member: String

  /**
   * System name
   */
  var sysname: String

  /**
   * unique identifier of job (substitute of job name and job id)
   */
  // "job-correlator": string;

  /**
   * status of the job
   */
  var status: String

  /**
   * Internal code
   */
  // "internal-code": string;

  /**
   * Message
   */
  var message: String
}

/**
 * Original job id
 */
var <T : IJobFeedback> T.originalJobid: String
  get() = asDynamic()["original-jobid"] as String
  set(value) {
    asDynamic()["original-jobid"] = value
  }

/**
 * unique identifier of job (substitute of job name and job id)
 */
var <T : IJobFeedback> T.jobCorrelator: String
  get() = asDynamic()["job-correlator"] as String
  set(value) {
    asDynamic()["job-correlator"] = value
  }

/**
 * Internal code
 */
var <T : IJobFeedback> T.internalCode: String
  get() = asDynamic()["internal-code"] as String
  set(value) {
    asDynamic()["internal-code"] = value
  }
