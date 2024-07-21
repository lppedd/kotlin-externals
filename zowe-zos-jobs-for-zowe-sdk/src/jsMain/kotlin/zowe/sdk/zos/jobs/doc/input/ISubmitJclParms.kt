package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for submit JCL APIs
 */
external interface ISubmitJclParms : ISubmitParmsCommon {
  /**
   * JCL to submit, for example:
   * ```
   * "//IEFBR14 JOB ()\n" +
   * "//RUN     EXEC PGM=IEFBR14"
   * ```
   */
  var jcl: String
}
