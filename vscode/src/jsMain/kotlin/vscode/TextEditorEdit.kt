package vscode

/**
 * A complex edit that will be applied in one transaction on a TextEditor.
 * This holds a description of the edits and if the edits are valid (i.e. no overlapping regions, document was not changed in the meantime, etc.)
 * they can be applied on a [TextDocument] associated with a [TextEditor].
 */
external interface TextEditorEdit {
  /**
   * Replace a certain text region with a new value.
   * You can use \r\n or \n in `value` and they will be normalized to the current [TextDocument].
   *
   * @param location The range this operation should remove.
   * @param value The new text this operation should insert after removing `location`.
   */
  fun replace(
    location: Position,
    value: String,
  )

  /**
   * Replace a certain text region with a new value.
   * You can use \r\n or \n in `value` and they will be normalized to the current [TextDocument].
   *
   * @param location The range this operation should remove.
   * @param value The new text this operation should insert after removing `location`.
   */
  fun replace(
    location: Range,
    value: String,
  )

  /**
   * Replace a certain text region with a new value.
   * You can use \r\n or \n in `value` and they will be normalized to the current [TextDocument].
   *
   * @param location The range this operation should remove.
   * @param value The new text this operation should insert after removing `location`.
   */
  fun replace(
    location: Selection,
    value: String,
  )

  /**
   * Insert text at a location.
   * You can use \r\n or \n in `value` and they will be normalized to the current [TextDocument].
   * Although the equivalent text edit can be made with [TextEditorEdit.replace], `insert` will produce a different resulting selection (it will get moved).
   *
   * @param location The position where the new text should be inserted.
   * @param value The new text this operation should insert.
   */
  fun insert(
    location: Position,
    value: String,
  )

  /**
   * Delete a certain text region.
   *
   * @param location The range this operation should remove.
   */
  fun delete(location: Range)

  /**
   * Delete a certain text region.
   *
   * @param location The range this operation should remove.
   */
  fun delete(location: Selection)

  /**
   * Set the end of line sequence.
   *
   * @param endOfLine The new end of line for the [TextDocument].
   */
  fun setEndOfLine(endOfLine: EndOfLine)
}
