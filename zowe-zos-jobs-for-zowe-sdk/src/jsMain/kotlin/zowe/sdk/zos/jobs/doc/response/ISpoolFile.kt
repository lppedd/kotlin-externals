package zowe.sdk.zos.jobs.doc.response

/**
 * Interface of spool file.
 */
external interface ISpoolFile {
  /**
   * Identifier for this spool file.
   */
  var id: Int

  /**
   * DD name of job spool file
   */
  var ddName: String

  /**
   * The name of the job step during which this spool file was produced
   */
  var stepName: String

  /**
   * If this spool file was produced during a job procedure step, the
   * name of the step will be here
   */
  var procName: String

  /**
   * Content of the spool file
   */
  var data: String
}
