package vscode

external interface PositionTranslateChange {
  /**
   * Delta value for the line value, default is `0`.
   */
  var lineDelta: Int?

  /**
   * Delta value for the character value, default is `0`.
   */
  var characterDelta: Int?
}
