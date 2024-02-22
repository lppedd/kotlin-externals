@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents the severity of diagnostics.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DiagnosticSeverity {
  companion object {
    /**
     * Something not allowed by the rules of a language or other means.
     */
    @JsIntValue(0)
    val Error: DiagnosticSeverity

    /**
     * Something suspicious but allowed.
     */
    @JsIntValue(1)
    val Warning: DiagnosticSeverity

    /**
     * Something to inform about but not a problem.
     */
    @JsIntValue(2)
    val Information: DiagnosticSeverity

    /**
     * Something to hint to a better way of doing it, like proposing
     * a refactoring.
     */
    @JsIntValue(3)
    val Hint: DiagnosticSeverity
  }
}
