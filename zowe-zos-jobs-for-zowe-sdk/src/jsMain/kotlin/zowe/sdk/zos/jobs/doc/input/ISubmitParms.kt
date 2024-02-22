@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs.doc.input

import zowe.imperative.operations.doc.ITaskWithStatus

// unhandled import: ITaskWithStatus from "@zowe/imperative"

/**
 * Interface for submit job API
 */
external interface ISubmitParms {
  /**
   * USS file which should contain syntactically correct JCL
   * Example value: IBMUSER.PUBLIC.CNTL(IEFBR14)
   * where IEFBR14 contains statements like:
   * ```
   * //IEFBR14 JOB ()
   * //RUN     EXEC PGM=IEFBR14
   * ```
   */
  var jclSource: String

  /**
   * Returns spool content if this option used
   */
  var viewAllSpoolContent: Boolean?

  /**
   * Wait for the job to reach output status
   */
  var waitForActive: Boolean?

  /**
   * Wait for the job to reach output status
   */
  var waitForOutput: Boolean?

  /**
   * Local directory path to download output of the job
   */
  var directory: String?

  /**
   * A file extension to save the job output with
   */
  var extension: String?

  /**
   * The volume on which the data set is stored
   */
  var volume: String?

  /**
   * Task status object used by CLI handlers to create progress bars
   * for certain job submit requests
   *
   * Optional
   */
  var task: ITaskWithStatus?

  /**
   * A string for JCL symbolic substitution
   */
  var jclSymbols: String?
}
