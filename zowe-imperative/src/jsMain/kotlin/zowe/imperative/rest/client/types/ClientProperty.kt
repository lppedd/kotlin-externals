package zowe.imperative.rest.client.types

/**
 * String type definition for properties of abstractRestClient that has a getter set. This can be
 * safely used in a getter call as a variable for the abstractRestClient object.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ClientProperty {
  companion object {
    @seskar.js.JsValue("requestSuccess")
    val requestSuccess: ClientProperty

    @seskar.js.JsValue("requestFailure")
    val requestFailure: ClientProperty

    @seskar.js.JsValue("data")
    val data: ClientProperty

    @seskar.js.JsValue("dataString")
    val dataString: ClientProperty

    @seskar.js.JsValue("response")
    val response: ClientProperty

    @seskar.js.JsValue("session")
    val session: ClientProperty

    @seskar.js.JsValue("log")
    val log: ClientProperty
  }
}
