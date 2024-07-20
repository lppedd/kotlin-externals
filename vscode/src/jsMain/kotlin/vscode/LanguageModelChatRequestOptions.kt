package vscode

import js.objects.Record

/**
 * Options for making a chat request using a language model.
 *
 * @see LanguageModelChat.sendRequest
 */
external interface LanguageModelChatRequestOptions {
  /**
   * A human-readable message that explains why access to a language model is needed and what feature is enabled by it.
   */
  var justification: String?

  /**
   * A set of options that control the behavior of the language model.
   * These options are specific to the language model and need to be lookup in the respective documentation.
   */
  var modelOptions: Record<String, Any>?
}
