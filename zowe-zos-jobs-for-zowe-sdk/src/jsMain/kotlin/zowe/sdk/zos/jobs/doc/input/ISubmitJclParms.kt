package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for submit JCL APIs
 */
external interface ISubmitJclParms {
  /**
   * JCL to submit, for example:
   * ```
   * "//IEFBR14 JOB ()\n" +
   * "//RUN     EXEC PGM=IEFBR14"
   * ```
   */
  var jcl: String

  /**
   * Specify internal reader RECFM and corresponding http(s) headers
   * will be appended to the request accordingly
   * "F" (fixed) or "V" (variable)
   */
  var internalReaderRecfm: String?

  /**
   * Specify internal reader LRECL and corresponding http(s) headers
   * will be appended to the request accordingly
   */
  var internalReaderLrecl: String?

  /**
   * A string for JCL symbolic substitution
   */
  var jclSymbols: String?
}
