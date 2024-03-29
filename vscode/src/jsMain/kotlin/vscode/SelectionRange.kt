@file:JsModule("vscode")

package vscode

/**
 * A selection range represents a part of a selection hierarchy. A selection range
 * may have a parent selection range that contains it.
 */
external class SelectionRange {
  /**
   * Creates a new selection range.
   *
   * @param range The range of the selection range.
   * @param parent The parent of the selection range.
   */
  constructor(range: Range, parent: SelectionRange = definedExternally)

  /**
   * The [Range] of this selection range.
   */
  var range: Range

  /**
   * The parent selection range containing this range.
   */
  var parent: SelectionRange?
}
