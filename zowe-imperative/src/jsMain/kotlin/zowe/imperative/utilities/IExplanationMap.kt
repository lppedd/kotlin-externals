package zowe.imperative.utilities

import kotlin.ts.Union

/**
 * Interface of an explanation map object
 */
external interface IExplanationMap {
  var explainedParentKey: String
  var ignoredKeys: String

  @seskar.js.JsNative
  operator fun get(key: String): Union<String, IExplanationMap>?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Union<String, IExplanationMap>?,
  )
}
