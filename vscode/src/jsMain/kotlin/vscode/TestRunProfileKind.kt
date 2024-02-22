@file:JsModule("vscode")

package vscode

/**
 * The kind of executions that [TestRunProfile TestRunProfiles] control.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TestRunProfileKind {
  companion object {
    /**
     * The `Run` test profile kind.
     */
    val Run: TestRunProfileKind

    /**
     * The `Debug` test profile kind.
     */
    val Debug: TestRunProfileKind

    /**
     * The `Coverage` test profile kind.
     */
    val Coverage: TestRunProfileKind
  }
}
