@file:JsModule("vscode")

package vscode

/**
 * Describes what to do with the indentation when pressing Enter.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IndentAction {
  companion object {
    /**
     * Insert new line and copy the previous line's indentation.
     */
    val None: IndentAction

    /**
     * Insert new line and indent once (relative to the previous line's indentation).
     */
    val Indent: IndentAction

    /**
     * Insert two new lines:
     *  - the first one indented which will hold the cursor
     *  - the second one at the same indentation level
     */
    val IndentOutdent: IndentAction

    /**
     * Insert new line and outdent once (relative to the previous line's indentation).
     */
    val Outdent: IndentAction
  }
}
