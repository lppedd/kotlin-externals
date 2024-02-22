package zowe.imperative.imperative.api.doc

import zowe.imperative.logger.Logger

external interface IImperativeApi {
  var imperativeLogger: Logger
  var appLogger: Logger

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
