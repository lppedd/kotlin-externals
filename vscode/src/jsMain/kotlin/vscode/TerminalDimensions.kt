package vscode

/**
 * Represents the dimensions of a terminal.
 */

external interface TerminalDimensions {
  /**
   * The number of columns in the terminal.
   */
  val columns: Double

  /**
   * The number of rows in the terminal.
   */
  val rows: Double
}
