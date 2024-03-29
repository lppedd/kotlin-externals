package vscode

/**
 * Uses the parent [Terminal]'s location for the terminal
 */
external interface TerminalSplitLocationOptions {
  /**
   * The parent terminal to split this terminal beside. This works whether the parent terminal
   * is in the panel or the editor area.
   */
  var parentTerminal: Terminal
}
