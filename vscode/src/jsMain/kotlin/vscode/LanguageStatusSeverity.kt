@file:JsModule("vscode")

package vscode

/**
 * Represents the severity of a language status item.
 */

/**
 * Represents the severity level of a language status.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface LanguageStatusSeverity {
  companion object {
    /**
     * Informational severity level.
     */
    val Information: LanguageStatusSeverity

    /**
     * Warning severity level.
     */
    val Warning: LanguageStatusSeverity

    /**
     * Error severity level.
     */
    val Error: LanguageStatusSeverity
  }
}
