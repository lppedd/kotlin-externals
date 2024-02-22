package zowe.imperative.rest.client.doc

external interface IHeaderContent {
  @seskar.js.JsNative
  operator fun get(key: String): String?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: String?,
  )
}
