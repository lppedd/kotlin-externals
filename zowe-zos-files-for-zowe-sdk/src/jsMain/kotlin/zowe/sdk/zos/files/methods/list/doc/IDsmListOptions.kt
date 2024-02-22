package zowe.sdk.zos.files.methods.list.doc

import zowe.imperative.operations.doc.ITaskWithStatus
import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the list data sets matching function
 */
@JsPlainObject
external interface IDsmListOptions : IZosFilesOptions {
  /**
   * Exclude data sets that match these DSLEVEL patterns. Any data sets that match
   * this pattern will not be listed
   *
   * Example: "ibmuser.**.jcl, ibmuser.rexa.*"
   */
  var excludePatterns: Array<String>?

  /**
   * The maximum REST requests to perform at once
   * Increasing this value results in faster requests but increases resource consumption
   * on z/OS and risks encountering an error caused
   * by making too many requests at once.
   *
   * Default: 1
   */
  var maxConcurrentRequests: Int?

  /**
   * Task status object used by CLI handlers to create progress bars
   *
   * Optional
   */
  var task: ITaskWithStatus?
}
