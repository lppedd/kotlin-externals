package zowe.imperative.config

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ConfigBuilderBuildDefaultProfileResult {
  var type: String
  var properties: Record<String, Any>
  var secure: Array<String>
}
