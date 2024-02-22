package zowe.sdk.zos.jobs.doc.response

/**
 * Interface for a job dd
 * Represents the name and details of an output (spool) DD for a z/OS batch job
 */
external interface IJobFile {
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
   * Record format of the spool file (DD)
   */
  var recfm: String

  /**
   * Total bytes in the spool file
   */
  // "byte-count": number;

  /**
   * Total records (roughly equivalent to lines) in the spool file
   */
  // "record-count": number;

  /**
   * unique identifier of job (substitute of job name and job id)
   */
  // "job-correlator": string;

  /**
   * Job class for which job ran
   */
  var `class`: String

  /**
   * Identifier for this spool file.
   *
   * each IJobFile for a single batch job will have a unique ID
   */
  var id: Int

  /**
   * DD name of job spool file
   */
  var ddname: String

  /**
   * Direct access to job record content
   */
  // "records-url": string;
  // TODO(Edoardo): how to do this? In TS it is possible to have dashes

  /**
   * Job DD lrecl (logical record length - how many bytes each record is)
   */
  var lrecl: Int

  /**
   * The primary or secondary JES subsystem.
   *
   * If this value is null, the job was processed by the primary subsystem.
   */
  var subsystem: String

  /**
   * The name of the job step during which this spool file was produced
   */
  var stepname: String

  /**
   * If this spool file was produced during a job procedure step, the
   * name of the step will be here.
   */
  var procstep: String
}
