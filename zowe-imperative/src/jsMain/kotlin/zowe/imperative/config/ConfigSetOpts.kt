package zowe.imperative.config

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ConfigSetOpts {
  var parseString: Boolean?
  var secure: Boolean?
}
