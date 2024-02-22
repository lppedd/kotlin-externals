package zowe.imperative.logger.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ILog4jsAppender {
  var type: String
  var layout: ILog4jsLayout

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
