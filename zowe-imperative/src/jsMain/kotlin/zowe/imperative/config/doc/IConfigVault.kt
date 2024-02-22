package zowe.imperative.config.doc

import js.promise.Promise
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigVault {
  var load: (key: String) -> Promise<Any?>
  var save: (key: String, value: Any?) -> Promise<Unit>
}
