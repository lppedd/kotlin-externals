package vscode

import js.array.ReadonlyArray

/**
 * A comment controller is able to provide [CommentThread]s support to the editor and
 * provide users various ways to interact with comments.
 */
external interface CommentController {
  /**
   * The id of this comment controller.
   */
  val id: String

  /**
   * The human-readable label of this comment controller.
   */
  val label: String

  /**
   * Comment controller options
   */
  var options: CommentOptions?

  /**
   * Optional commenting range provider. Provide a list [Range]s which support commenting to any given resource uri.
   *
   * If not provided, users cannot leave any comments.
   */
  var commentingRangeProvider: CommentingRangeProvider?

  /**
   * Create a [CommentThread]. The comment thread will be displayed in visible text editors (if the resource matches)
   * and Comments Panel once created.
   *
   * @param uri The uri of the document the thread has been created on.
   * @param range The range the comment thread is located within the document.
   * @param comments The ordered comments of the thread.
   */
  fun createCommentThread(
    uri: Uri,
    range: Range,
    comments: ReadonlyArray<Comment>,
  ): CommentThread

  /**
   * Optional reaction handler for creating and deleting reactions on a [Comment].
   */
  var reactionHandler: ((comment: Comment, reaction: CommentReaction) -> Thenable<Unit>)?

  /**
   * Dispose this comment controller.
   *
   * Once disposed, all [CommentThread]s created by this comment controller will also be removed from the editor
   * and Comments Panel.
   */
  fun dispose()
}
