package zowe.imperative.logger.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigLogging {
  var log4jsConfig: ILog4jsConfig?
}
