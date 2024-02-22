@file:JsModule("vscode")

package vscode

import js.typedarrays.Uint32Array

/**
 * Represents semantic tokens, either in a range or in an entire document.
 * @see [DocumentSemanticTokensProvider.provideDocumentSemanticTokens] for an explanation of the format.
 * @see [SemanticTokensBuilder] for a helper to create an instance.
 */
external class SemanticTokens {
  /**
   * Create new semantic tokens.
   *
   * @param data Token data.
   * @param resultId Result identifier.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(data: Uint32Array, resultId: String = definedExternally)

  /**
   * The result id of the tokens.
   *
   * This is the id that will be passed to `DocumentSemanticTokensProvider.provideDocumentSemanticTokensEdits` (if implemented).
   */
  val resultId: String?

  /**
   * The actual tokens data.
   * @see [DocumentSemanticTokensProvider.provideDocumentSemanticTokens] for an explanation of the format.
   */
  val data: Uint32Array
}
