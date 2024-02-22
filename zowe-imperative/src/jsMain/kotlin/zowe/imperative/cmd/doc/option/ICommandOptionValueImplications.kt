package zowe.imperative.cmd.doc.option

import kotlin.js.plain.JsPlainObject

/**
 * Interface describing syntax validation rule where specifying a certain value means that the user
 * must also specify other options
 */
@JsPlainObject
external interface ICommandOptionValueImplications {
  /**
   * What option names are implied if the value in question is specified
   */
  var impliedOptionNames: Array<String>

  /**
   * Is the value case sensitive? If yes, the strings will be compared with "===". Otherwise they
   * will be uppercased before comparing
   */
  var isCaseSensitive: Boolean?
}
