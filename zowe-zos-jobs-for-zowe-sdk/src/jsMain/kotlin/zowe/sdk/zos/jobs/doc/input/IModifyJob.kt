package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for change job z/OSMF API
 */
external interface IModifyJob {
  /**
   * updated class for job
   */
  var `class`: String?
  var request: String?
}
