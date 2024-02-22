package zowe.sdk.zos.jobs.doc.response

/**
 * Standard job response document
 * Represents the attributes and status of a z/OS batch job
 */
external interface IJob {
  /**
   * job id for a job
   *
   * Uniquely identifies a job on a z/OS system
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String

  /**
   * The primary or secondary JES subsystem.
   *
   * If this value is null, the job was processed by the primary subsystem.
   */
  var subsystem: String

  /**
   * owner of the job
   */
  var owner: String

  /**
   * status of the job
   */
  var status: String

  /**
   * type of job
   */
  var type: String

  /**
   * job class
   */
  var `class`: String

  /**
   * return code of the job
   */
  var retcode: String

  /**
   * detailed job step data
   */
  // "step-data"?: IJobStepData[];

  /**
   * url for direct reference of job info
   */
  var url: String

  /**
   * spool files url for direct reference
   */
  // "files-url": string;

  /**
   * unique identifier of job (substitute of job name and job id)
   *
   * If this value is null, the job was submitted to JES3.
   */
  // "job-correlator": string;

  /**
   * job phase
   */
  var phase: Double

  /**
   * job phase name
   */
  // "phase-name": string;

  /**
   * explaination of error
   */
  // "reason-not-running"?: string;
  // TODO(Edoardo): how to do this? In TS it is possible to have dashes
}
