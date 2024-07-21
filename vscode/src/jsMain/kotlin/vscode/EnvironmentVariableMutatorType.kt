package vscode

import seskar.js.JsIntValue

/**
 * A type of mutation that can be applied to an environment variable.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface EnvironmentVariableMutatorType {
  companion object {
    /**
     * Replace the variable's existing value.
     */
    @JsIntValue(1)
    val Replace: EnvironmentVariableMutatorType

    /**
     * Append to the end of the variable's existing value.
     */
    @JsIntValue(2)
    val Append: EnvironmentVariableMutatorType

    /**
     * Prepend to the start of the variable's existing value.
     */
    @JsIntValue(3)
    val Prepend: EnvironmentVariableMutatorType
  }
}
