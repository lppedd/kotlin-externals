package vscode

/**
 * Represents a handle to a set of decorations
 * sharing the same styling options ([DecorationRenderOptions]) in a [TextEditor].
 *
 * To get an instance of a `TextEditorDecorationType` use
 * [vscode.window.createTextEditorDecorationType].
 */
external interface TextEditorDecorationType {
  /**
   * Internal representation of the handle.
   */
  val key: String

  /**
   * Remove this decoration type and all decorations on all text editors using it.
   */
  fun dispose()
}
