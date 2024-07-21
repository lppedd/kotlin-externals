package zowe.imperative.utilities.diff.doc

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface OutputFormat {
  companion object {
    @seskar.js.JsValue("html")
    val html: OutputFormat

    @seskar.js.JsValue("unifiedstring")
    val unifiedstring: OutputFormat

    @seskar.js.JsValue("terminal")
    val terminal: OutputFormat
  }
}
