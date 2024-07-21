package zowe.imperative.rest.client.doc

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface RestErrorSource {
  companion object {
    @seskar.js.JsValue("client")
    val client: RestErrorSource

    @seskar.js.JsValue("http")
    val http: RestErrorSource
  }
}
