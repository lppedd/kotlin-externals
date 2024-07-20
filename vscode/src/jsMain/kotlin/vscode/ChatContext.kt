package vscode

import js.array.ReadonlyArray
import kotlin.ts.Union

/**
 * Extra context passed to a participant.
 */
external interface ChatContext {
  /**
   * All of the chat messages so far in the current chat session.
   * Currently, only chat messages for the current participant are included.
   */
  val history: ReadonlyArray<Union<ChatRequestTurn, ChatResponseTurn>>
}
