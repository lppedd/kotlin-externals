@file:JsModule("vscode")

package vscode

/**
 * Represents a part of a chat response that is a progress message.
 */
external class ChatResponseProgressPart {
  /**
   * Create a new [ChatResponseProgressPart].
   *
   * @param value A progress message
   */
  constructor(value: String)

  /**
   * The progress message
   */
  var `value`: String
}
