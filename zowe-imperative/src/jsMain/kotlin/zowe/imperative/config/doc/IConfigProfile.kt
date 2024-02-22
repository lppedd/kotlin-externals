package zowe.imperative.config.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigProfile {
  var properties: Record<String, Any>
  var type: String?
  var profiles: Record<String, IConfigProfile>?
  var secure: Array<String>?
}
