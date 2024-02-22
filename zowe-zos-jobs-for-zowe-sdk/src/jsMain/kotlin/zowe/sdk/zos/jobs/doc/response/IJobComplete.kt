package zowe.sdk.zos.jobs.doc.response

/**
 * Completed job interface
 */
external interface IJobComplete {
  /**
   * unique identifier of job (substitute of job name and job id)
   */
  // "job-correlator": string;

  /**
   * job id for a job
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String

  /**
   * Job owner
   */
  var owner: String

  /**
   * Job class
   */
  var `class`: String

  /**
   * return code of the job
   */
  var retcode: String

  /**
   * Completion type
   */
  // "completion-type": number;

  /**
   * Completion code
   */
  // "completion-code": number;

  /**
   * Abend code
   */
  // "abend-code": string;
}

/**
 * unique identifier of job (substitute of job name and job id)
 */
var <T : IJobComplete> T.jobCorrelator: String
  get() = asDynamic()["job-correlator"] as String
  set(value) {
    asDynamic()["job-correlator"] = value
  }

/**
 * Completion type
 */
var <T : IJobComplete> T.completionType: String
  get() = asDynamic()["completion-type"] as String
  set(value) {
    asDynamic()["completion-type"] = value
  }

/**
 * Completion code
 */
var <T : IJobComplete> T.completionCode: String
  get() = asDynamic()["completion-code"] as String
  set(value) {
    asDynamic()["completion-code"] = value
  }

/**
 * Abend code
 */
var <T : IJobComplete> T.abendCode: String
  get() = asDynamic()["abend-code"] as String
  set(value) {
    asDynamic()["abend-code"] = value
  }
