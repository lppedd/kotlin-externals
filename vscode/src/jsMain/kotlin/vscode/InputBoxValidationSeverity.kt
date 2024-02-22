@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * The severity level for input box validation.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface InputBoxValidationSeverity {
  companion object {
    /**
     * Informational severity level.
     */
    @JsIntValue(1)
    val Info: InputBoxValidationSeverity

    /**
     * Warning severity level.
     */
    @JsIntValue(2)
    val Warning: InputBoxValidationSeverity

    /**
     * Error severity level.
     */
    @JsIntValue(3)
    val Error: InputBoxValidationSeverity
  }
}
