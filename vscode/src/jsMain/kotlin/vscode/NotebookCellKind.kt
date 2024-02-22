@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * A notebook cell kind.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NotebookCellKind {
  companion object {
    /**
     * A markup-cell is formatted source that is used for display.
     */
    @JsIntValue(1)
    val Markup: NotebookCellKind

    /**
     * A code-cell is source that can be executed ([NotebookController]) and that
     * produces output ([NotebookCellOutput]).
     */
    @JsIntValue(2)
    val Code: NotebookCellKind
  }
}
