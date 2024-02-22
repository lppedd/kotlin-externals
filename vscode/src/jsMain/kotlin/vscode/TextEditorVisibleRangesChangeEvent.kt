package vscode

/**
 * Represents an event describing the change in a [TextEditor.visibleRanges text editor's visible ranges].
 */
external interface TextEditorVisibleRangesChangeEvent {
  /**
   * The [TextEditor text editor] for which the visible ranges have changed.
   */
  val textEditor: TextEditor

  /**
   * The new value for the [TextEditor.visibleRanges text editor's visible ranges].
   */
  val visibleRanges: Array<out Range>
}
