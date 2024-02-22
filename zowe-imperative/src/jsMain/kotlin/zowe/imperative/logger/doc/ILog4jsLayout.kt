package zowe.imperative.logger.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ILog4jsLayout {
  var type: String
  var pattern: String
}
