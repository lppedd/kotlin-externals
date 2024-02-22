package zowe.imperative.config

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ConfigSearchOpts {
  var ignoreDirs: Array<String>?
  var startDir: String?
}
