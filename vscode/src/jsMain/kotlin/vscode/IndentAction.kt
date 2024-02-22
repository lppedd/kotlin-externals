@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Describes what to do with the indentation when pressing Enter.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IndentAction {
  companion object {
    /**
     * Insert new line and copy the previous line's indentation.
     */
    @JsIntValue(0)
    val None: IndentAction

    /**
     * Insert new line and indent once (relative to the previous line's indentation).
     */
    @JsIntValue(1)
    val Indent: IndentAction

    /**
     * Insert two new lines:
     *  - the first one indented which will hold the cursor
     *  - the second one at the same indentation level
     */
    @JsIntValue(2)
    val IndentOutdent: IndentAction

    /**
     * Insert new line and outdent once (relative to the previous line's indentation).
     */
    @JsIntValue(3)
    val Outdent: IndentAction
  }
}
