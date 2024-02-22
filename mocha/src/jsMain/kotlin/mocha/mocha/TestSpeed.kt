package mocha.mocha

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TestSpeed {
  companion object {
    @seskar.js.JsValue("slow")
    val slow: TestSpeed

    @seskar.js.JsValue("medium")
    val medium: TestSpeed

    @seskar.js.JsValue("fast")
    val fast: TestSpeed
  }
}
