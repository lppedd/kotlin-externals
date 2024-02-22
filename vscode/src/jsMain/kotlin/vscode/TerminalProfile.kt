@file:JsModule("vscode")

package vscode

/**
 * A terminal profile defines how a terminal will be launched.
 */
external class TerminalProfile {
  /**
   * Creates a new terminal profile.
   * @param options The options that the terminal will launch with.
   */
  constructor(options: TerminalOptions)

  constructor(options: ExtensionTerminalOptions)

  /**
   * The options that the terminal will launch with.
   */
  var options: Any // TerminalOptions | ExtensionTerminalOptions
}
