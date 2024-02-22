package zowe.imperative.cmd.doc

import kotlin.js.plain.JsPlainObject

/**
 * "Pass On" allows you to indicate fields in the current command definition node to be passed-on
 * (inherited) by all or select children.
 */
@JsPlainObject
external interface ICommandDefinitionPassOnIgnore {
  var type: ICommandNodeType?
  var name: String?
}
