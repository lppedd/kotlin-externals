@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents the severity level of a language status.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface LanguageStatusSeverity {
  companion object {
    /**
     * Informational severity level.
     */
    @JsIntValue(0)
    val Information: LanguageStatusSeverity

    /**
     * Warning severity level.
     */
    @JsIntValue(1)
    val Warning: LanguageStatusSeverity

    /**
     * Error severity level.
     */
    @JsIntValue(2)
    val Error: LanguageStatusSeverity
  }
}
