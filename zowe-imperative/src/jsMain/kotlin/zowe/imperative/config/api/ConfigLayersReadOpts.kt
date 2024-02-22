package zowe.imperative.config.api

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ConfigLayersReadOpts {
  var user: Boolean
  var global: Boolean
}
