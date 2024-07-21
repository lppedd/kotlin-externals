package vscode

import seskar.js.JsIntValue

/**
 * The state of a comment thread.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CommentThreadState {
  companion object {
    /**
     * Unresolved thread state
     */
    @JsIntValue(0)
    val Unresolved: CommentThreadState

    /**
     * Resolved thread state
     */
    @JsIntValue(1)
    val Resolved: CommentThreadState
  }
}
