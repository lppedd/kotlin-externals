@file:JsModule("vscode")

package vscode

/**
 * Represents a part of a chat response that is a button that executes a command.
 */
external class ChatResponseCommandButtonPart {
  /**
   * Create a new [ChatResponseCommandButtonPart].
   *
   * @param value A Command that will be executed when the button is clicked.
   */
  constructor(value: Command)

  /**
   * The command that will be executed when the button is clicked.
   */
  var `value`: Command
}
