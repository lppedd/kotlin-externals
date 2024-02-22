package vscode

/**
 * Represents an event describing the change in a [TextEditor.selections text editor's selections].
 */
external interface TextEditorSelectionChangeEvent {
  /**
   * The [TextEditor text editor] for which the selections have changed.
   */
  val textEditor: TextEditor

  /**
   * The new value for the [TextEditor.selections text editor's selections].
   */
  val selections: Array<out Selection>

  /**
   * The [TextEditorSelectionChangeKind change kind] which has triggered this
   * event. Can be `undefined`.
   */
  val kind: TextEditorSelectionChangeKind?
}
