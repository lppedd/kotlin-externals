package vscode

import seskar.js.JsIntValue

/**
 * Completion item kinds.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CompletionItemKind {
  companion object {
    /**
     * The `Text` completion item kind.
     */
    @JsIntValue(0)
    val Text: CompletionItemKind

    /**
     * The `Method` completion item kind.
     */
    @JsIntValue(1)
    val Method: CompletionItemKind

    /**
     * The `Function` completion item kind.
     */
    @JsIntValue(2)
    val Function: CompletionItemKind

    /**
     * The `Constructor` completion item kind.
     */
    @JsIntValue(3)
    val Constructor: CompletionItemKind

    /**
     * The `Field` completion item kind.
     */
    @JsIntValue(4)
    val Field: CompletionItemKind

    /**
     * The `Variable` completion item kind.
     */
    @JsIntValue(5)
    val Variable: CompletionItemKind

    /**
     * The `Class` completion item kind.
     */
    @JsIntValue(6)
    val Class: CompletionItemKind

    /**
     * The `Interface` completion item kind.
     */
    @JsIntValue(7)
    val Interface: CompletionItemKind

    /**
     * The `Module` completion item kind.
     */
    @JsIntValue(8)
    val Module: CompletionItemKind

    /**
     * The `Property` completion item kind.
     */
    @JsIntValue(9)
    val Property: CompletionItemKind

    /**
     * The `Unit` completion item kind.
     */
    @JsIntValue(10)
    val Unit: CompletionItemKind

    /**
     * The `Value` completion item kind.
     */
    @JsIntValue(11)
    val Value: CompletionItemKind

    /**
     * The `Enum` completion item kind.
     */
    @JsIntValue(12)
    val Enum: CompletionItemKind

    /**
     * The `Keyword` completion item kind.
     */
    @JsIntValue(13)
    val Keyword: CompletionItemKind

    /**
     * The `Snippet` completion item kind.
     */
    @JsIntValue(14)
    val Snippet: CompletionItemKind

    /**
     * The `Color` completion item kind.
     */
    @JsIntValue(15)
    val Color: CompletionItemKind

    /**
     * The `Reference` completion item kind.
     */
    @JsIntValue(17)
    val Reference: CompletionItemKind

    /**
     * The `File` completion item kind.
     */
    @JsIntValue(16)
    val File: CompletionItemKind

    /**
     * The `Folder` completion item kind.
     */
    @JsIntValue(18)
    val Folder: CompletionItemKind

    /**
     * The `EnumMember` completion item kind.
     */
    @JsIntValue(19)
    val EnumMember: CompletionItemKind

    /**
     * The `Constant` completion item kind.
     */
    @JsIntValue(20)
    val Constant: CompletionItemKind

    /**
     * The `Struct` completion item kind.
     */
    @JsIntValue(21)
    val Struct: CompletionItemKind

    /**
     * The `Event` completion item kind.
     */
    @JsIntValue(22)
    val Event: CompletionItemKind

    /**
     * The `Operator` completion item kind.
     */
    @JsIntValue(23)
    val Operator: CompletionItemKind

    /**
     * The `TypeParameter` completion item kind.
     */
    @JsIntValue(24)
    val TypeParameter: CompletionItemKind

    /**
     * The `User` completion item kind.
     */
    @JsIntValue(25)
    val User: CompletionItemKind

    /**
     * The `Issue` completion item kind.
     */
    @JsIntValue(26)
    val Issue: CompletionItemKind
  }
}
