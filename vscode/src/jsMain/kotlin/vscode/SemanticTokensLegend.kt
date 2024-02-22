@file:JsModule("vscode")

package vscode

/**
 * A semantic tokens legend contains the needed information to decipher
 * the integer encoded representation of semantic tokens.
 */
external class SemanticTokensLegend {
  /**
   * Creates a semantic tokens legend.
   *
   * @param tokenTypes An array of token types.
   * @param tokenModifiers An array of token modifiers.
   */
  constructor(tokenTypes: Array<String>, tokenModifiers: Array<String> = definedExternally)

  /**
   * The possible token types.
   */
  val tokenTypes: Array<String>

  /**
   * The possible token modifiers.
   */
  val tokenModifiers: Array<String>
}
