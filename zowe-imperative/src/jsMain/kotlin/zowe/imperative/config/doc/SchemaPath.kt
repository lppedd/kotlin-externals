package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface SchemaPath {
  var schema: String
  var updated: Boolean
}
