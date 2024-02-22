@file:JsModule("vscode")

package vscode

/**
 * The location of the terminal.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TerminalLocation {
  companion object {
    /**
     * In the terminal view
     */
    val Panel: TerminalLocation

    /**
     * In the editor area
     */
    val Editor: TerminalLocation
  }
}
