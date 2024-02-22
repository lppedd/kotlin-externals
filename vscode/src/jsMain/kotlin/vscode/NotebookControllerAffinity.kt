@file:JsModule("vscode")

package vscode

/**
 * Notebook controller affinity for notebook documents.
 *
 * @see [NotebookController.updateNotebookAffinity]
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NotebookControllerAffinity {
  companion object {
/**
     * Default affinity.
     */
    val Default: NotebookControllerAffinity

/**
     * A controller is preferred for a notebook.
     */
    val Preferred: NotebookControllerAffinity
  }
}
