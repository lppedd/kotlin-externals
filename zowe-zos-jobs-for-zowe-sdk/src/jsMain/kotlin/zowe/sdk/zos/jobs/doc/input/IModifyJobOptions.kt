package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for change job z/OSMF API
 */
external interface IModifyJobOptions {
  /**
   * new job class to change job to
   */
  var jobclass: String?

  /**
   * specify this option as `true` when wanting to hold your job
   */
  var hold: Boolean?

  /**
   * specify this option as `true` when wanting to release your job
   */
  var release: Boolean?
}
