package vscode

import seskar.js.JsIntValue

/**
 * Collapsible state of a [CommentThread]
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CommentThreadCollapsibleState {
  companion object {
    /**
     * Determines an item is collapsed
     */
    @JsIntValue(0)
    val Collapsed: CommentThreadCollapsibleState

    /**
     * Determines an item is expanded
     */
    @JsIntValue(1)
    val Expanded: CommentThreadCollapsibleState
  }
}
