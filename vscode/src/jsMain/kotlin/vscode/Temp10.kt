package vscode

external interface Temp10 {
  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
