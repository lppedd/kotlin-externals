package vscode

external interface ProcessExecutionOptionsEnv {
  @seskar.js.JsNative
  operator fun get(key: String): String?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: String?,
  )
}
