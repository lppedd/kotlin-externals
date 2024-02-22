package vscode

/**
 * Represents an event describing the change in a [TextEditor.options text editor's options].
 */

external interface TextEditorOptionsChangeEvent {
/**
   * The [TextEditor text editor] for which the options have changed.
   */
  val textEditor: TextEditor

/**
   * The new value for the [TextEditor.options text editor's options].
   */
  val options: TextEditorOptions
}
