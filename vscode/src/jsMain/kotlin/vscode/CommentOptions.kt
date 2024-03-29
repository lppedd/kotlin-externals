package vscode

/**
 * Represents a [CommentController]'s [CommentController.options].
 */
external interface CommentOptions {
  /**
   * An optional string to show on the comment input box when it's collapsed.
   */
  var prompt: String?

  /**
   * An optional string to show as placeholder in the comment input box when it's focused.
   */
  var placeHolder: String?
}
