package zowe.sdk.zos.jobs.doc.response

/**
 * Job error interface
 */
external interface IJobError {
  /**
   * Return code number
   */
  var rc: Int

  /**
   * Reason code number
   */
  var reason: Int

  /**
   * Stack info
   */
  var stack: String

  /**
   * Category error number
   */
  var category: Int

  /**
   * z/OSMF error message
   */
  var message: String
}
