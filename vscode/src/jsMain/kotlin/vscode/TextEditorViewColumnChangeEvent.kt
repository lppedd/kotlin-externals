package vscode

/**
 * Represents an event describing the change of a [TextEditor.viewColumn text editor's view column].
 */
external interface TextEditorViewColumnChangeEvent {
  /**
   * The [TextEditor text editor] for which the view column has changed.
   */
  val textEditor: TextEditor

  /**
   * The new value for the [TextEditor.viewColumn text editor's view column].
   */
  val viewColumn: ViewColumn
}
