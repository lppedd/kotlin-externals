package zowe.sdk.zos.jobs.doc.response

/**
 * Step info on a job interface
 */
external interface IJobStepData {
  /**
   * smfid
   */
  var smfid: String

  /**
   * ACtive
   */
  var active: String

  /**
   * Job relevant step
   */
  // "step-number": number;
  // TODO(Edoardo): how to do this? In TS it is possible to have dashes

  /**
   * Job relevant proc
   */
  // "proc-step-name": string;

  /**
   * Step for which job dd exists
   */
  // "step-name": string;

  /**
   * Program EXEC=
   */
  // "program-name": string;
}
