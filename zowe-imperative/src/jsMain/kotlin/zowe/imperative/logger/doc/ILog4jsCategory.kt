package zowe.imperative.logger.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ILog4jsCategory {
  var appenders: Array<String>
  var level: String
}
