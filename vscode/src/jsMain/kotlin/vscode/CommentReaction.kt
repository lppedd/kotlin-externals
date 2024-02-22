package vscode

/**
 * Reactions of a [Comment]
 */
external interface CommentReaction {
  /**
   * The human-readable label for the reaction
   */
  val label: String

  /**
   * Icon for the reaction shown in UI.
   */
  val iconPath: Union<String, Uri>

  /**
   * The number of users who have reacted to this reaction
   */
  val count: Int

  /**
   * Whether the [CommentAuthorInformation] of the comment has reacted to this reaction
   */
  val authorHasReacted: Boolean
}
