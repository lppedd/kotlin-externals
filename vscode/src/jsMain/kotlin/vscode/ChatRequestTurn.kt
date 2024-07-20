@file:JsModule("vscode")

package vscode

/**
 * Represents a user request in chat history.
 */
external class ChatRequestTurn {
  /**
   * The prompt as entered by the user.
   *
   * Information about references used in this request is stored in [ChatRequestTurn.references].
   *
   * *Note* that the [ChatParticipant.name] of the participant and the [ChatCommand.name]
   * are not part of the prompt.
   */
  val prompt: String

  /**
   * The id of the chat participant to which this request was directed.
   */
  val participant: String

  /**
   * The name of the [ChatCommand] that was selected for this request.
   */
  val command: String?

  /**
   * The references that were used in this message.
   */
  val references: Array<ChatPromptReference>
}
