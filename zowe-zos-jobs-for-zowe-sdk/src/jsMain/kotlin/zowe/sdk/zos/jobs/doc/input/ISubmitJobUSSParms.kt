package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for submit job API
 */
external interface ISubmitJobUSSParms {
  /**
   * USS File which should contain syntactically correct JCL
   * Example value: /u/users/ibmuser/iefbr14.jcl
   * where the file contains statements like:
   * ```
   * //IEFBR14 JOB ()
   * //RUN     EXEC PGM=IEFBR14
   * ```
   */
  var jobUSSFile: String

  /**
   * A string for JCL symbolic substitution
   */
  var jclSymbols: String?
}
