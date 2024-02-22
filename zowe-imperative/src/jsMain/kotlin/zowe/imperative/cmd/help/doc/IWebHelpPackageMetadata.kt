package zowe.imperative.cmd.help.doc

import kotlin.js.plain.JsPlainObject

/**
 * Object containing metadata about a CLI package or plugin
 */
@JsPlainObject
external interface IWebHelpPackageMetadata {
  /**
   * Name of package
   */
  var name: String

  /**
   * Version string of package
   */
  var version: String
}
