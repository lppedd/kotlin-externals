@file:JsModule("vscode")

package vscode

/**
 * A text edit represents edits that should be applied
 * to a document.
 */
external class TextEdit {
  /**
   * Create a new TextEdit.
   *
   * @param range A range.
   * @param newText A string.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(range: Range, newText: String)

  /**
   * The range this edit applies to.
   */
  var range: Range

  /**
   * The string this edit will insert.
   */
  var newText: String

  /**
   * The eol-sequence used in the document.
   *
   * *Note* that the eol-sequence will be applied to the
   * whole document.
   */
  var newEol: EndOfLine?

  companion object {
    /**
     * Utility to create a replace edit.
     *
     * @param range A range.
     * @param newText A string.
     * @return A new text edit object.
     */
    fun replace(
      range: Range,
      newText: String,
    ): TextEdit

    /**
     * Utility to create an insert edit.
     *
     * @param position A position, will become an empty range.
     * @param newText A string.
     * @return A new text edit object.
     */
    fun insert(
      position: Position,
      newText: String,
    ): TextEdit

    /**
     * Utility to create a delete edit.
     *
     * @param range A range.
     * @return A new text edit object.
     */
    fun delete(range: Range): TextEdit

    /**
     * Utility to create an eol-edit.
     *
     * @param eol An eol-sequence
     * @return A new text edit object.
     */
    fun setEndOfLine(eol: EndOfLine): TextEdit
  }
}
