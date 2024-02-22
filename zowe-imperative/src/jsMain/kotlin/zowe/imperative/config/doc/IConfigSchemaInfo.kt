package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigSchemaInfo {
  var original: String
  var resolved: String
  var local: Boolean
}
