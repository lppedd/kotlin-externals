package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents the role of a chat message. This is either the user or the assistant.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface LanguageModelChatMessageRole {
  companion object {
    /**
     * The user role, e.g., the human interacting with a language model.
     */
    @JsIntValue(1)
    val User: LanguageModelChatMessageRole

    /**
     * The assistant role, e.g. the language model generating responses.
     */
    @JsIntValue(2)
    val Assistant: LanguageModelChatMessageRole
  }
}
