@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents an end of line character sequence in a [TextDocument].
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface EndOfLine {
  companion object {
    /**
     * The line feed `\n` character.
     */
    @JsIntValue(1)
    val LF: EndOfLine

    /**
     * The carriage return line feed `\r\n` sequence.
     */
    @JsIntValue(2)
    val CRLF: EndOfLine
  }
}
