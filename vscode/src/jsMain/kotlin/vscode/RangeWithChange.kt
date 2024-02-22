package vscode

external interface RangeWithChange {
  /**
   * New start position, defaults to [Range.start current start]
   */
  var start: Position?

  /**
   * New end position, defaults to [Range.end current end]
   */
  var end: Position?
}
