package zowe.imperative.rest.client.types

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface HttpVerb {
  companion object {
    @seskar.js.JsValue("GET")
    val GET: HttpVerb

    @seskar.js.JsValue("PUT")
    val PUT: HttpVerb

    @seskar.js.JsValue("POST")
    val POST: HttpVerb

    @seskar.js.JsValue("DELETE")
    val DELETE: HttpVerb
  }
}
