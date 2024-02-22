@file:JsModule("vscode")

package vscode

/**
 * A line based folding range. To be valid, start and end line must be bigger than zero and smaller than the number of lines in the document.
 * Invalid ranges will be ignored.
 */

external class FoldingRange {
  /**
   * Creates a new folding range.
   *
   * @param start The start line of the folded range.
   * @param end The end line of the folded range.
   * @param kind The kind of the folding range.
   */
  constructor(start: Double, end: Double, kind: FoldingRangeKind = definedExternally)

  /**
   * The zero-based start line of the range to fold. The folded area starts after the line's last character.
   * To be valid, the end must be zero or larger and smaller than the number of lines in the document.
   */
  var start: Double

  /**
   * The zero-based end line of the range to fold. The folded area ends with the line's last character.
   * To be valid, the end must be zero or larger and smaller than the number of lines in the document.
   */
  var end: Double

  /**
   * Describes the [FoldingRangeKind Kind} of the folding range such as {@link FoldingRangeKind.Comment Comment] or
   * [FoldingRangeKind.Region Region]. The kind is used to categorize folding ranges and used by commands
   * like 'Fold all comments'. See
   * [FoldingRangeKind] for an enumeration of all kinds.
   * If not set, the range is originated from a syntax element.
   */
  var kind: FoldingRangeKind?
}
