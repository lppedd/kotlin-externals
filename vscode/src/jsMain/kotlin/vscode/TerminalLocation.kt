@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * The location of the terminal.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TerminalLocation {
  companion object {
    /**
     * In the terminal view
     */
    @JsIntValue(1)
    val Panel: TerminalLocation

    /**
     * In the editor area
     */
    @JsIntValue(2)
    val Editor: TerminalLocation
  }
}
