package vscode

/**
 * Describes the currently selected completion item.
 */
external interface SelectedCompletionInfo {
  /**
   * The range that will be replaced if this completion item is accepted.
   */
  val range: Range

  /**
   * The text the range will be replaced with if this completion is accepted.
   */
  val text: String
}
