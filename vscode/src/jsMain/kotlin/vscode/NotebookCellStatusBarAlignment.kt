@file:JsModule("vscode")

package vscode

/**
 * Represents the alignment of status bar items.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NotebookCellStatusBarAlignment {
  companion object {
/**
     * Aligned to the left side.
     */
    val Left: NotebookCellStatusBarAlignment

/**
     * Aligned to the right side.
     */
    val Right: NotebookCellStatusBarAlignment
  }
}
