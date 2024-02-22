@file:JsModule("vscode")

package vscode

/**
 * Terminal exit reason kind.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TerminalExitReason {
  companion object {
    /**
     * Unknown reason.
     */
    val Unknown: TerminalExitReason

    /**
     * The window closed/reloaded.
     */
    val Shutdown: TerminalExitReason

    /**
     * The shell process exited.
     */
    val Process: TerminalExitReason

    /**
     * The user closed the terminal.
     */
    val User: TerminalExitReason

    /**
     * An extension disposed the terminal.
     */
    val Extension: TerminalExitReason
  }
}
