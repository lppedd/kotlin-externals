@file:JsModule("vscode")

package vscode

import js.array.ReadonlyArray
import kotlin.ts.Union4

/**
 * Represents a chat participant's response in chat history.
 */
external class ChatResponseTurn {
  /**
   * The content that was received from the chat participant. Only the stream parts that represent actual content (not metadata) are represented.
   */
  val response:
    ReadonlyArray<Union4<ChatResponseMarkdownPart, ChatResponseFileTreePart, ChatResponseAnchorPart, ChatResponseCommandButtonPart>>

  /**
   * The result that was received from the chat participant.
   */
  val result: ChatResult

  /**
   * The id of the chat participant that this response came from.
   */
  val participant: String

  /**
   * The name of the command that this response came from.
   */
  val command: String?
}
