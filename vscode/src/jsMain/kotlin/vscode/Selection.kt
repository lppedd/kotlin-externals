@file:JsModule("vscode")

package vscode

/**
 * Represents a text selection in an editor.
 */
external class Selection : Range {
  /**
   * Create a selection from two positions.
   *
   * @param anchor A position.
   * @param active A position.
   */
  constructor(anchor: Position, active: Position)

  /**
   * Create a selection from four coordinates.
   *
   * @param anchorLine A zero-based line value.
   * @param anchorCharacter A zero-based character value.
   * @param activeLine A zero-based line value.
   * @param activeCharacter A zero-based character value.
   */
  constructor(anchorLine: Int, anchorCharacter: Int, activeLine: Int, activeCharacter: Int)

  /**
   * The position at which the selection starts.
   * This position might be before or after [active].
   */
  var anchor: Position

  /**
   * The position of the cursor.
   * This position might be before or after [anchor].
   */
  var active: Position

  /**
   * A selection is reversed if its [anchor] is the [end] position.
   */
  var isReversed: Boolean
}
