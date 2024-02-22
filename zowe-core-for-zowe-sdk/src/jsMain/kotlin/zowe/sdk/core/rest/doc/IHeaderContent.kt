package zowe.sdk.core.rest.doc

/**
 * Interface to add index signature to http headers
 */
// TODO(Edoardo): is this one right? How do I instantiate it?
external interface IHeaderContent {
  @seskar.js.JsNative
  operator fun get(key: String): String?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: String?,
  )
}
