package zowe.explorer.api.utils

import js.promise.Promise

external interface PollRequest {
  var msInterval: Int
  var dispose: Boolean?
  var resolve: ((uniqueId: String, data: Any?) -> Any?)?
  var request: () -> Promise<Any?>

  fun <T /* default is Nothing */> reject(reason: Any? = definedExternally): Promise<T>

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
