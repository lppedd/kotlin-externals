package vscode

import js.array.ReadonlyArray

/**
 * A request to a chat participant.
 */
external interface ChatRequest {
  /**
   * The prompt as entered by the user.
   *
   * Information about references used in this request is stored in [ChatRequest.references].
   *
   * *Note* that the [ChatParticipant.name] of the participant and the [ChatCommand.name]
   * are not part of the prompt.
   */
  val prompt: String

  /**
   * The name of the [ChatCommand] that was selected for this request.
   */
  val command: String?

  /**
   * The list of references and their values that are referenced in the prompt.
   *
   * *Note* that the prompt contains references as authored and that it is up to the participant
   * to further modify the prompt, for instance by inlining reference values or creating links to
   * headings which contain the resolved values. References are sorted in reverse by their range
   * in the prompt. That means the last reference in the prompt is the first in this list.
   * This simplifies string-manipulation of the prompt.
   */
  val references: ReadonlyArray<ChatPromptReference>
}
