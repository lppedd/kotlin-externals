package vscode

import js.iterable.AsyncIterable

/**
 * Represents a language model response.
 *
 * @see LanguageModelAccess.chatRequest
 */
external interface LanguageModelChatResponse {
  /**
   * An async iterable that is a stream of text chunks forming the overall response.
   *
   * *Note* that this stream will error when during data receiving an error occurs.
   * Consumers of the stream should handle the errors accordingly.
   *
   * To cancel the stream, the consumer can [CancellationTokenSource.cancel]
   * the token that was used to make the request or break from the for-loop.
   *
   * Example:
   * ```ts
   * try {
   *   // consume stream
   *   for await (const chunk of response.text) {
   *    console.log(chunk);
   *   }
   * } catch(e) {
   *   // stream ended with an error
   *   console.error(e);
   * }
   * ```
   */
  var text: AsyncIterable<String>
}
