package vscode

import seskar.js.JsIntValue

/**
 * A symbol kind.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SymbolKind {
  companion object {
    /**
     * The `File` symbol kind.
     */
    @JsIntValue(0)
    val File: SymbolKind

    /**
     * The `Module` symbol kind.
     */
    @JsIntValue(1)
    val Module: SymbolKind

    /**
     * The `Namespace` symbol kind.
     */
    @JsIntValue(2)
    val Namespace: SymbolKind

    /**
     * The `Package` symbol kind.
     */
    @JsIntValue(3)
    val Package: SymbolKind

    /**
     * The `Class` symbol kind.
     */
    @JsIntValue(4)
    val Class: SymbolKind

    /**
     * The `Method` symbol kind.
     */
    @JsIntValue(5)
    val Method: SymbolKind

    /**
     * The `Property` symbol kind.
     */
    @JsIntValue(6)
    val Property: SymbolKind

    /**
     * The `Field` symbol kind.
     */
    @JsIntValue(7)
    val Field: SymbolKind

    /**
     * The `Constructor` symbol kind.
     */
    @JsIntValue(8)
    val Constructor: SymbolKind

    /**
     * The `Enum` symbol kind.
     */
    @JsIntValue(9)
    val Enum: SymbolKind

    /**
     * The `Interface` symbol kind.
     */
    @JsIntValue(10)
    val Interface: SymbolKind

    /**
     * The `Function` symbol kind.
     */
    @JsIntValue(11)
    val Function: SymbolKind

    /**
     * The `Variable` symbol kind.
     */
    @JsIntValue(12)
    val Variable: SymbolKind

    /**
     * The `Constant` symbol kind.
     */
    @JsIntValue(13)
    val Constant: SymbolKind

    /**
     * The `String` symbol kind.
     */
    @JsIntValue(14)
    val String: SymbolKind

    /**
     * The `Number` symbol kind.
     */
    @JsIntValue(15)
    val Number: SymbolKind

    /**
     * The `Boolean` symbol kind.
     */
    @JsIntValue(16)
    val Boolean: SymbolKind

    /**
     * The `Array` symbol kind.
     */
    @JsIntValue(17)
    val Array: SymbolKind

    /**
     * The `Object` symbol kind.
     */
    @JsIntValue(18)
    val Object: SymbolKind

    /**
     * The `Key` symbol kind.
     */
    @JsIntValue(19)
    val Key: SymbolKind

    /**
     * The `Null` symbol kind.
     */
    @JsIntValue(20)
    val Null: SymbolKind

    /**
     * The `EnumMember` symbol kind.
     */
    @JsIntValue(21)
    val EnumMember: SymbolKind

    /**
     * The `Struct` symbol kind.
     */
    @JsIntValue(22)
    val Struct: SymbolKind

    /**
     * The `Event` symbol kind.
     */
    @JsIntValue(23)
    val Event: SymbolKind

    /**
     * The `Operator` symbol kind.
     */
    @JsIntValue(24)
    val Operator: SymbolKind

    /**
     * The `TypeParameter` symbol kind.
     */
    @JsIntValue(25)
    val TypeParameter: SymbolKind
  }
}
