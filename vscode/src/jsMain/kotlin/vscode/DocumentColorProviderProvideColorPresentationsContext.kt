package vscode

external interface DocumentColorProviderProvideColorPresentationsContext {
/**
   * The text document that contains the color
   */
  val document: TextDocument

/**
   * The range in the document where the color is located.
   */
  val range: Range
}
