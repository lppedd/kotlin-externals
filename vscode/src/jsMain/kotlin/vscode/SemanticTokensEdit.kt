@file:JsModule("vscode")

package vscode

import js.typedarrays.Uint32Array

/**
 * Represents an edit to semantic tokens.
 * @see [DocumentSemanticTokensProvider.provideDocumentSemanticTokensEdits] for an explanation of the format.
 */
external class SemanticTokensEdit {
  /**
   * Create a semantic token edit.
   *
   * @param start Start offset
   * @param deleteCount Number of elements to remove.
   * @param data Elements to insert
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(start: Int, deleteCount: Int, data: Uint32Array = definedExternally)

  /**
   * The start offset of the edit.
   */
  val start: Int

  /**
   * The count of elements to remove.
   */
  val deleteCount: Int

  /**
   * The elements to insert.
   */
  val data: Uint32Array?
}
