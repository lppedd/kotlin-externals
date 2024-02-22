package vscode

/**
 * An event describing an individual change in the text of a [TextDocument document].
 */

external interface TextDocumentContentChangeEvent {
/**
   * The range that got replaced.
   */
  val range: Range

/**
   * The offset of the range that got replaced.
   */
  val rangeOffset: Double

/**
   * The length of the range that got replaced.
   */
  val rangeLength: Double

/**
   * The new text for the range.
   */
  val text: String
}
