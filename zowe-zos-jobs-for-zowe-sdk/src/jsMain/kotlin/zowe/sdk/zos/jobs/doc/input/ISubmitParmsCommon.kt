package zowe.sdk.zos.jobs.doc.input

/**
 * Common interface for submit job API
 */
external interface ISubmitParmsCommon {
  /**
   * A string for JCL symbolic substitution
   */
  var jclSymbols: String?

  /**
   * Specify internal reader file encoding and corresponding http(s) headers
   * will be appended to the request accordingly
   */
  var internalReaderFileEncoding: String?

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
}
