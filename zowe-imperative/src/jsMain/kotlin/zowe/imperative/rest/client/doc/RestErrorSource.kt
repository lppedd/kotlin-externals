@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client.doc

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface RestErrorSource {
  companion object {
    @seskar.js.JsValue("client")
    val client: RestErrorSource

    @seskar.js.JsValue("http")
    val http: RestErrorSource
  }
}
