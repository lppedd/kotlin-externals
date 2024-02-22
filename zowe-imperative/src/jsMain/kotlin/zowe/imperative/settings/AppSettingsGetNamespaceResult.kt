package zowe.imperative.settings

import kotlin.ts.Union

external interface AppSettingsGetNamespaceResult {
  var CredentialManager: Union<String, `false`>

  @seskar.js.JsNative
  operator fun get(key: String): Union<String, `false`>?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Union<String, `false`>?,
  )
}
