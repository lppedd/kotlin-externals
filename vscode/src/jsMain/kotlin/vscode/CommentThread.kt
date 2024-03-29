package vscode

import js.array.ReadonlyArray

/**
 * A collection of [Comment]s representing a conversation at a particular range in a document.
 */
external interface CommentThread {
  /**
   * The uri of the document the thread has been created on.
   */
  val uri: Uri

  /**
   * The range the comment thread is located within the document. The thread icon will be shown
   * at the last line of the range.
   */
  var range: Range

  /**
   * The ordered comments of the thread.
   */
  var comments: ReadonlyArray<Comment>

  /**
   * Whether the thread should be collapsed or expanded when opening the document.
   * Defaults to Collapsed.
   */
  var collapsibleState: CommentThreadCollapsibleState

  /**
   * Whether the thread supports reply.
   * Defaults to true.
   */
  var canReply: Boolean

  /**
   * Context value of the comment thread. This can be used to contribute thread specific actions.
   * For example, a comment thread is given a context value as `editable`. When contributing actions to `comments/commentThread/title`
   * using `menus` extension point, you can specify context value for key `commentThread` in `when` expression like `commentThread == editable`.
   * ```json
   * "contributes": {
   *   "menus": {
   *     "comments/commentThread/title": [
   *       {
   *         "command": "extension.deleteCommentThread",
   *         "when": "commentThread == editable"
   *       }
   *     ]
   *   }
   * }
   * ```
   * This will show action `extension.deleteCommentThread` only for comment threads with `contextValue` is `editable`.
   */
  var contextValue: String?

  /**
   * The optional human-readable label describing the [CommentThread]
   */
  var label: String?

  /**
   * The optional state of a comment thread, which may affect how the comment is displayed.
   */
  var state: CommentThreadState?

  /**
   * Dispose this comment thread.
   *
   * Once disposed, this comment thread will be removed from visible editors and Comment Panel when appropriate.
   */
  fun dispose()
}
