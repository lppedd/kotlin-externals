package vscode

external interface TerminalOptionsEnv {
  @seskar.js.JsNative
  operator fun get(key: String): String?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: String?,
  )
}
