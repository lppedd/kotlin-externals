package mocha.mocha

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface RunnableState {
  companion object {
    @seskar.js.JsValue("failed")
    val failed: RunnableState

    @seskar.js.JsValue("passed")
    val passed: RunnableState

    @seskar.js.JsValue("pending")
    val pending: RunnableState
  }
}
