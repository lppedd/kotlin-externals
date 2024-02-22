@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfig {
  var `$schema`: String?
  var defaults: Record<String, String>
  var profiles: Record<String, IConfigProfile>
  var autoStore: Boolean?
  var plugins: Array<String>?
}
