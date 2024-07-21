package vscode

import seskar.js.JsIntValue

/**
 * Comment mode of a [Comment]
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CommentMode {
  companion object {
    /**
     * Displays the comment editor
     */
    @JsIntValue(0)
    val Editing: CommentMode

    /**
     * Displays the preview of the comment
     */
    @JsIntValue(1)
    val Preview: CommentMode
  }
}
