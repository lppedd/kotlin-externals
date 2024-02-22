@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigSchema {
  var `$schema`: String
  var `$version`: String
  var type: String
  var description: String
  var properties: Record<String, Any>
}
