@file:JsModule("vscode")

package vscode

/**
 * Impacts the behavior and appearance of the validation message.
 */

/**
 * The severity level for input box validation.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface InputBoxValidationSeverity {
  companion object {
/**
     * Informational severity level.
     */
    val Info: InputBoxValidationSeverity

/**
     * Warning severity level.
     */
    val Warning: InputBoxValidationSeverity

/**
     * Error severity level.
     */
    val Error: InputBoxValidationSeverity
  }
}
