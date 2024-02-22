@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.validation.doc

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ValidationOutcome {
  companion object {
    @seskar.js.JsValue("Failed")
    val Failed: ValidationOutcome

    @seskar.js.JsValue("OK")
    val OK: ValidationOutcome

    @seskar.js.JsValue("Warning")
    val Warning: ValidationOutcome
  }
}
