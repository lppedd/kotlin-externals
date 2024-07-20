@file:JsModule("vscode")
@file:JsQualifier("chat")

package vscode.chat

import vscode.ChatParticipant
import vscode.ChatRequestHandler

/**
 * Create a new [ChatParticipant] instance.
 *
 * @param id A unique identifier for the participant.
 * @param handler A request handler for the participant.
 * @return A new chat participant
 */
external fun createChatParticipant(
  id: String,
  handler: ChatRequestHandler,
): ChatParticipant
