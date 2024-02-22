@file:JsModule("vscode")

package vscode

/**
 * A snippet edit represents an interactive edit that is performed by
 * the editor.
 *
 * *Note* that a snippet edit can always be performed as a normal [TextEdit].
 * This will happen when no matching editor is open or when a [WorkspaceEdit]
 * contains snippet edits for multiple files. In that case only those that match the active editor
 * will be performed as snippet edits and the others as normal text edits.
 */
external class SnippetTextEdit {
  /**
   * Create a new snippet edit.
   *
   * @param range A range.
   * @param snippet A snippet string.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(range: Range, snippet: SnippetString)

  /**
   * The range this edit applies to.
   */
  var range: Range

  /**
   * The [SnippetString] this edit will perform.
   */
  var snippet: SnippetString

  companion object {
    /**
     * Utility to create a replace snippet edit.
     *
     * @param range A range.
     * @param snippet A snippet string.
     * @return A new snippet edit object.
     */
    fun replace(
      range: Range,
      snippet: SnippetString,
    ): SnippetTextEdit

    /**
     * Utility to create an insert snippet edit.
     *
     * @param position A position, will become an empty range.
     * @param snippet A snippet string.
     * @return A new snippet edit object.
     */
    fun insert(
      position: Position,
      snippet: SnippetString,
    ): SnippetTextEdit
  }
}
