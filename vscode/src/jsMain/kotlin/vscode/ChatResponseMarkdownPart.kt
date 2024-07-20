@file:JsModule("vscode")

package vscode

/**
 * Represents a part of a chat response that is formatted as Markdown.
 */
external class ChatResponseMarkdownPart {
  /**
   * Create a new [ChatResponseMarkdownPart].
   *
   * @param value A markdown string or a string that should be interpreted as markdown.
   *   The boolean form of [MarkdownString.isTrusted] is NOT supported.
   */
  constructor(value: String)

  /**
   * Create a new [ChatResponseMarkdownPart].
   *
   * @param value A markdown string or a string that should be interpreted as markdown.
   *   The boolean form of [MarkdownString.isTrusted] is NOT supported.
   */
  constructor(value: MarkdownString)

  /**
   * A markdown string or a string that should be interpreted as markdown.
   */
  var `value`: MarkdownString
}
