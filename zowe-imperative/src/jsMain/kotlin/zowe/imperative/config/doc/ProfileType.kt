package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ProfileType {
  var from: Array<String>
  var version: String?
  var latestFrom: String?
}
