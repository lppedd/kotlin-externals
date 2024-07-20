@file:JsModule("vscode")

package vscode

/**
 * Represents a part of a chat response that is a file tree.
 */
external class ChatResponseFileTreePart {
  /**
   * Create a new [ChatResponseFileTreePart].
   *
   * @param value File tree data.
   * @param baseUri The base uri to which this file tree is relative.
   */
  constructor(value: Array<ChatResponseFileTree>, baseUri: Uri)

  /**
   * File tree data.
   */
  var `value`: Array<ChatResponseFileTree>

  /**
   * The base uri to which this file tree is relative
   */
  var baseUri: Uri
}
