package vscode

/**
 * Represents a language model for making chat requests.
 *
 * @see vscode.lm.selectChatModels
 */
external interface LanguageModelChat {
  /**
   * Human-readable name of the language model.
   */
  val name: String

  /**
   * Opaque identifier of the language model.
   */
  val id: String

  /**
   * A well-known identifier of the vendor of the language model. An example is `copilot`, but
   * values are defined by extensions contributing chat models and need to be looked up with them.
   */
  val vendor: String

  /**
   * Opaque family-name of the language model. Values might be `gpt-3.5-turbo`, `gpt4`, `phi2`, or `llama`
   * but they are defined by extensions contributing languages and subject to change.
   */
  val family: String

  /**
   * Opaque version string of the model. This is defined by the extension contributing the language model
   * and subject to change.
   */
  val version: String

  /**
   * The maximum number of tokens that can be sent to the model in a single request.
   */
  val maxInputTokens: Int

  /**
   * Make a chat request using a language model.
   *
   * *Note* that language model use may be subject to access restrictions and user consent. Calling this function
   * for the first time (for a extension) will show a consent dialog to the user and because of that this function
   * must _only be called in response to a user action!_ Extension can use [LanguageModelAccessInformation.canSendRequest]
   * to check if they have the necessary permissions to make a request.
   *
   * This function will return a rejected promise if making a request to the language model is not
   * possible. Reasons for this can be:
   *
   * - user consent not given, see [LanguageModelError.NoPermissions]
   * - model does not exist anymore, see [LanguageModelError.NotFound]
   * - quota limits exceeded, see [LanguageModelError.Blocked]
   * - other issues in which case extension must check [LanguageModelError.cause]
   *
   * @param messages An array of message instances.
   * @param options Options that control the request.
   * @param token A cancellation token which controls the request. See [CancellationTokenSource] for how to create one.
   * @return A thenable that resolves to a [LanguageModelChatResponse]. The promise will reject when the request couldn't be made.
   */
  fun sendRequest(
    messages: Array<LanguageModelChatMessage>,
    options: LanguageModelChatRequestOptions = definedExternally,
    token: CancellationToken = definedExternally,
  ): Thenable<LanguageModelChatResponse>

  /**
   * Count the number of tokens in a message using the model specific tokenizer-logic.
   *
   * @param text A string or a message instance.
   * @param token Optional cancellation token.  See [CancellationTokenSource] for how to create one.
   * @return A thenable that resolves to the number of tokens.
   */
  fun countTokens(
    text: String,
    token: CancellationToken = definedExternally,
  ): Thenable<Int>

  /**
   * Count the number of tokens in a message using the model specific tokenizer-logic.
   *
   * @param text A string or a message instance.
   * @param token Optional cancellation token.  See [CancellationTokenSource] for how to create one.
   * @return A thenable that resolves to the number of tokens.
   */
  fun countTokens(
    text: LanguageModelChatMessage,
    token: CancellationToken = definedExternally,
  ): Thenable<Int>
}
