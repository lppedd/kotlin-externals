package zowe.imperative.logger.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ILog4jsConfig {
  var appenders: Record<String, ILog4jsAppender>
  var categories: Record<String, ILog4jsCategory>
}
