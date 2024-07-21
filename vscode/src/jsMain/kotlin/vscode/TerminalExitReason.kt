package vscode

import seskar.js.JsIntValue

/**
 * Terminal exit reason kind.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TerminalExitReason {
  companion object {
    /**
     * Unknown reason.
     */
    @JsIntValue(0)
    val Unknown: TerminalExitReason

    /**
     * The window closed/reloaded.
     */
    @JsIntValue(1)
    val Shutdown: TerminalExitReason

    /**
     * The shell process exited.
     */
    @JsIntValue(2)
    val Process: TerminalExitReason

    /**
     * The user closed the terminal.
     */
    @JsIntValue(3)
    val User: TerminalExitReason

    /**
     * An extension disposed the terminal.
     */
    @JsIntValue(4)
    val Extension: TerminalExitReason
  }
}
