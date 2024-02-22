package vscode

external interface PositionWithChange {
  /**
   * New line value, defaults the line value of [Position].
   */
  var line: Int?

  /**
   * New character value, defaults the character value of [Position].
   */
  var character: Int?
}
