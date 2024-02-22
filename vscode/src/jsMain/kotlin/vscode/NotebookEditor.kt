package vscode

/**
 * Represents a notebook editor that is attached to a [NotebookDocument notebook].
 * Additional properties of the NotebookEditor are available in the proposed
 * API, which will be finalized later.
 */

external interface NotebookEditor {
  /**
   * The [NotebookDocument notebook document] associated with this notebook editor.
   */
  val notebook: NotebookDocument

  /**
   * The primary selection in this notebook editor.
   */
  var selection: NotebookRange

  /**
   * All selections in this notebook editor.
   *
   * The primary selection (or focused range) is `selections[0]`. When the document has no cells, the primary selection is empty `{ start: 0, end: 0 }`;
   */
  var selections: Array<out NotebookRange>

  /**
   * The current visible ranges in the editor (vertically).
   */
  val visibleRanges: Array<out NotebookRange>

  /**
   * The column in which this editor shows.
   */
  val viewColumn: ViewColumn?

  /**
   * Scroll as indicated by `revealType` in order to reveal the given range.
   *
   * @param range A range.
   * @param revealType The scrolling strategy for revealing `range`.
   */
  fun revealRange(
    range: NotebookRange,
    revealType: NotebookEditorRevealType = definedExternally,
  ): Unit
}
