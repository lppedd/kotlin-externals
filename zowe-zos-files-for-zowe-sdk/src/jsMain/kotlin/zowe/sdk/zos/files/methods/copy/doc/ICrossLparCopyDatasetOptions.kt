package zowe.sdk.zos.files.methods.copy.doc

import js.promise.Promise
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the copy cross lpar data set function.
 */
@JsPlainObject
external interface ICrossLparCopyDatasetOptions : ICopyDatasetOptions {
  /**
   * Target volser
   */
  var targetVolser: String?

  /**
   * Target management class
   */
  var targetManagementClass: String?

  /**
   * Target storage class
   */
  var targetStorageClass: String?

  /**
   * Target data class
   */
  var targetDataClass: String?

  /**
   * Overwrite option
   */
  var overwrite: Boolean?

  /**
   * Prompt callback that will be invoked before overwiting a data set.
   * @param targetDSN Name of data set that already exists
   * @return True if target data set should be overwritten
   */
  var promptFn: ((targetDSN: String) -> Promise<Boolean>)?
}
