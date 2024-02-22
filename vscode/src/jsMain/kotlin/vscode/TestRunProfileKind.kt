@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * The kind of executions that [TestRunProfile]s control.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TestRunProfileKind {
  companion object {
    /**
     * The `Run` test profile kind.
     */
    @JsIntValue(1)
    val Run: TestRunProfileKind

    /**
     * The `Debug` test profile kind.
     */
    @JsIntValue(2)
    val Debug: TestRunProfileKind

    /**
     * The `Coverage` test profile kind.
     */
    @JsIntValue(3)
    val Coverage: TestRunProfileKind
  }
}
