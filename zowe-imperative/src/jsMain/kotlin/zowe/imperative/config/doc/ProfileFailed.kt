package zowe.imperative.config.doc

import js.errors.JsError
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ProfileFailed {
  var name: String?
  var type: String
  var error: JsError
}
