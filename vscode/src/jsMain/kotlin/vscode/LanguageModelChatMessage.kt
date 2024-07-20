@file:JsModule("vscode")

package vscode

/**
 * Represents a message in a chat. Can assume different roles, like user or assistant.
 */
external class LanguageModelChatMessage {
  /**
   * Create a new user message.
   *
   * @param role The role of the message.
   * @param content The content of the message.
   * @param name The optional name of a user for the message.
   */
  constructor(role: LanguageModelChatMessageRole, content: String, name: String? = definedExternally)

  /**
   * The role of this message.
   */
  var role: LanguageModelChatMessageRole

  /**
   * The content of this message.
   */
  var content: String

  /**
   * The optional name of a user for this message.
   */
  var name: String?

  companion object {
    /**
     * Utility to create a new user message.
     *
     * @param content The content of the message.
     * @param name The optional name of a user for the message.
     */
    fun User(
      content: String,
      name: String? = definedExternally,
    ): LanguageModelChatMessage

    /**
     * Utility to create a new assistant message.
     *
     * @param content The content of the message.
     * @param name The optional name of a user for the message.
     */
    fun Assistant(
      content: String,
      name: String? = definedExternally,
    ): LanguageModelChatMessage
  }
}
