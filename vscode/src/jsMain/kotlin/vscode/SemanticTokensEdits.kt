@file:JsModule("vscode")

package vscode

/**
 * Represents edits to semantic tokens.
 * @see [DocumentSemanticTokensProvider.provideDocumentSemanticTokensEdits] for an explanation of the format.
 */
external class SemanticTokensEdits {
  /**
   * Create new semantic tokens edits.
   *
   * @param edits An array of semantic token edits
   * @param resultId Result identifier.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(edits: Array<SemanticTokensEdit>, resultId: String = definedExternally)

  /**
   * The result id of the tokens.
   *
   * This is the id that will be passed to `DocumentSemanticTokensProvider.provideDocumentSemanticTokensEdits` (if implemented).
   */
  val resultId: String?

  /**
   * The edits to the tokens data.
   * All edits refer to the initial data state.
   */
  val edits: Array<SemanticTokensEdit>
}
