package zowe.sdk.zos.files.methods.list.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject
import kotlin.ts.Union

/**
 * This interface defines the options that can be sent into the USS list files function
 */
@JsPlainObject
external interface IUSSListOptions : IZosFilesOptions {
  /**
   * The indicator that we want to show less files
   */
  var maxLength: Int?

  /**
   * The group owner or GID to filter
   */
  var group: (Union<Int, String> /* number | string */)?

  /**
   * The user name or UID to filter
   */
  var user: (Union<Int, String> /* number | string */)?

  /**
   * The modification time to filter, in days
   *
   * Valid values are either an integer, or an integer with leading plus (+) or minus (-)
   */
  var mtime: (Union<Int, String> /* number | string */)?

  /**
   * The size to filter
   *
   * Valid values are either an integer, and integer with a suffix (K, M, G),
   * or an integer with leading plus (+) or minus (-)
   */
  var size: (Union<Int, String> /* number | string */)?

  /**
   * The name of the file or directory to filter
   */
  var name: String?

  /**
   * The permission octal mask to use
   *
   * The type is a string because valid values are either an integer, or an integer with a leading minus (-)
   */
  var perm: String?

  /**
   * The type of file to filter for
   *
   * Allowed values are: c - character special file, d - directory, f - file, l - symbolic link, p - FIFO (named pipe), and s - socket
   */
  var type: String?

  /**
   * The depth of the directory structure to list files and directories for
   */
  var depth: Int?

  /**
   * Whether or not to search all filesystems under the path, or just the same filesystem as the path
   *
   * True means search all
   *
   * False means search same
   */
  var filesys: Boolean?

  /**
   * Whether to follow symlinks, or report them
   *
   * True means to report
   *
   * False means to follow
   */
  var symlinks: Boolean?
}
