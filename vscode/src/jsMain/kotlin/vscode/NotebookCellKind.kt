package vscode

import seskar.js.JsIntValue

/**
 * A notebook cell kind.
 */
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
