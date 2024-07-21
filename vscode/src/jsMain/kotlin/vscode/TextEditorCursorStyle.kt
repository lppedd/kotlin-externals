package vscode

import seskar.js.JsIntValue

/**
 * Rendering style of the cursor.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TextEditorCursorStyle {
  companion object {
    /**
     * Render the cursor as a vertical thick line.
     */
    @JsIntValue(1)
    val Line: TextEditorCursorStyle

    /**
     * Render the cursor as a block filled.
     */
    @JsIntValue(2)
    val Block: TextEditorCursorStyle

    /**
     * Render the cursor as a thick horizontal line.
     */
    @JsIntValue(3)
    val Underline: TextEditorCursorStyle

    /**
     * Render the cursor as a vertical thin line.
     */
    @JsIntValue(4)
    val LineThin: TextEditorCursorStyle

    /**
     * Render the cursor as a block outlined.
     */
    @JsIntValue(5)
    val BlockOutline: TextEditorCursorStyle

    /**
     * Render the cursor as a thin horizontal line.
     */
    @JsIntValue(6)
    val UnderlineThin: TextEditorCursorStyle
  }
}
