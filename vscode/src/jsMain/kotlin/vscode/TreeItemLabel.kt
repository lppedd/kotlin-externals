package vscode

import js.array.JsTuple2

/**
 * Label describing the [TreeItem]
 */
external interface TreeItemLabel {
  /**
   * A human-readable string describing the [TreeItem].
   */
  var label: String

  /**
   * Ranges in the label to highlight. A range is defined as a tuple of two number where the
   * first is the inclusive start index and the second the exclusive end index
   */
  var highlights: Array<JsTuple2<Int, Int>>?
}
