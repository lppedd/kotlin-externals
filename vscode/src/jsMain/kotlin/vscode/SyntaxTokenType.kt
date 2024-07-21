package vscode

import seskar.js.JsIntValue

/**
 * Enumeration of commonly encountered syntax token types.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SyntaxTokenType {
  companion object {
    /**
     * Everything except tokens that are part of comments, string literals and regular expressions.
     */
    @JsIntValue(0)
    val Other: SyntaxTokenType

    /**
     * A comment.
     */
    @JsIntValue(1)
    val Comment: SyntaxTokenType

    /**
     * A string literal.
     */
    @JsIntValue(2)
    val String: SyntaxTokenType

    /**
     * A regular expression.
     */
    @JsIntValue(3)
    val RegEx: SyntaxTokenType
  }
}
