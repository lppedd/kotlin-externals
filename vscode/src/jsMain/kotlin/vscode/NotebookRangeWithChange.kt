package vscode

external interface NotebookRangeWithChange {
  /**
   * New start index, defaults to [NotebookRange.start].
   */
  var start: Int?

  /**
   * New end index, defaults to [NotebookRange.end].
   */
  var end: Int?
}
