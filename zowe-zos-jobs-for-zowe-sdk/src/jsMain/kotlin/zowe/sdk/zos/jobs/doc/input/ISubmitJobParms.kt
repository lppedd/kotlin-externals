package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for submit job API
 */
external interface ISubmitJobParms {
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
   * A string for JCL symbolic substitution
   */
  var jclSymbols: String?
}
