package zowe.imperative.rest.client

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ContentEncoding {
  companion object {
    @seskar.js.JsValue("br")
    val br: ContentEncoding

    @seskar.js.JsValue("deflate")
    val deflate: ContentEncoding

    @seskar.js.JsValue("gzip")
    val gzip: ContentEncoding
  }
}
