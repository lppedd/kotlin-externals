@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Denotes a location of an editor in the window. Editors can be arranged in a grid
 * and each column represents one editor location in that grid by counting the editors
 * in order of their appearance.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ViewColumn {
  companion object {
    /**
     * A *symbolic* editor column representing the currently active column. This value
     * can be used when opening editors, but the *resolved* [TextEditor.viewColumn]-value
     * of editors will always be `One`, `Two`, `Three`,... or `undefined` but never `Active`.
     */
    @JsIntValue(-1)
    val Active: ViewColumn

    /**
     * A *symbolic* editor column representing the column to the side of the active one. This value
     * can be used when opening editors, but the *resolved* [TextEditor.viewColumn]-value
     * of editors will always be `One`, `Two`, `Three`,... or `undefined` but never `Beside`.
     */
    @JsIntValue(-2)
    val Beside: ViewColumn

    /**
     * The first editor column.
     */
    @JsIntValue(1)
    val One: ViewColumn

    /**
     * The second editor column.
     */
    @JsIntValue(2)
    val Two: ViewColumn

    /**
     * The third editor column.
     */
    @JsIntValue(3)
    val Three: ViewColumn

    /**
     * The fourth editor column.
     */
    @JsIntValue(4)
    val Four: ViewColumn

    /**
     * The fifth editor column.
     */
    @JsIntValue(5)
    val Five: ViewColumn

    /**
     * The sixth editor column.
     */
    @JsIntValue(6)
    val Six: ViewColumn

    /**
     * The seventh editor column.
     */
    @JsIntValue(7)
    val Seven: ViewColumn

    /**
     * The eighth editor column.
     */
    @JsIntValue(8)
    val Eight: ViewColumn

    /**
     * The ninth editor column.
     */
    @JsIntValue(9)
    val Nine: ViewColumn
  }
}
