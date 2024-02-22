package zowe.sdk.zos.files.methods.create.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * Interface for the options to the create zos-file-system API.
 */
@JsPlainObject
external interface ICreateZfsOptions : IZosFilesOptions {
  /**
   * The user ID for owner of the root directory
   */
  var owner: String?

  /**
   * The group ID for the root directory
   */
  var group: String?

  /**
   * The permissions code for the root directory
   */
  var perms: Int?

  /**
   * The primary space allocation
   */
  var cylsPri: Int

  /**
   * The secondary space allocation
   */
  var cylsSec: Int?

  /**
   * The storage class
   */
  var storclass: String?

  /**
   * The management class
   */
  var mgntclass: String?

  /**
   * The data class
   */
  var dataclass: String?

  /**
   * The volumes on which to allocate space
   */
  var volumes: Array<String>?

  /**
   * The number of seconds to wait for command to complete
   */
  var timeout: Int?
}
