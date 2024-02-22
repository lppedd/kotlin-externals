@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigLayer {
  var path: String
  var exists: Boolean
  var properties: IConfig
  var global: Boolean
  var user: Boolean
}
