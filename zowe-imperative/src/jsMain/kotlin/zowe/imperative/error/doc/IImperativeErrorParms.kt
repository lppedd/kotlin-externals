package zowe.imperative.error.doc

import zowe.imperative.logger.Logger
import kotlin.js.plain.JsPlainObject

/**
 * Imperative Standard Error - All Imperative services/utils must thrown an Imperative Error (not a
 * generic Error). The Imperative Error collects additional diagnostics and most (if not all)
 * Imperative Promises
 */
@JsPlainObject
external interface IImperativeErrorParms {
  /**
   * Logger for the Imperative Error (logs messages and the node report that is generated upon request)
   */
  var logger: Logger?

  /**
   * Message tag - prepended to the error message specified. Useful for categorizing error messages
   * (e.g. "Profile IO Error"). A ": " is appended automatically (e.g. "Profile IO Error: ")
   */
  var tag: String?
}
