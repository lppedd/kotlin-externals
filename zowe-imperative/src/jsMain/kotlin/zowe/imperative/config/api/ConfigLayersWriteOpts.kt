package zowe.imperative.config.api

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ConfigLayersWriteOpts {
  var user: Boolean
  var global: Boolean
}
