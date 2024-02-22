package vscode

/**
 * Command argument for actions registered in `comments/commentThread/context`.
 */
external interface CommentReply {
  /**
   * The active [CommentThread]
   */
  var thread: CommentThread

  /**
   * The value in the comment editor
   */
  var text: String
}
