@file:JsModule("vscode")
@file:JsQualifier("notebooks")

package vscode.notebooks

import vscode.NotebookCell
import vscode.NotebookController
import vscode.NotebookDocument
import vscode.Thenable

/**
 * Creates a new notebook controller.
 *
 * @param id Identifier of the controller. Must be unique per extension.
 * @param notebookType A notebook type for which this controller is for.
 * @param label The label of the controller.
 * @param handler The execute-handler of the controller.
 * @return A new notebook controller.
 */
external fun createNotebookController(
  id: String,
  notebookType: String,
  label: String,
  handler: (
    cells: Array<NotebookCell>,
    notebook: NotebookDocument,
    controller: NotebookController,
  ) -> Thenable<Unit> = definedExternally,
): NotebookController

/**
 * Creates a new notebook controller.
 *
 * @param id Identifier of the controller. Must be unique per extension.
 * @param notebookType A notebook type for which this controller is for.
 * @param label The label of the controller.
 * @param handler The execute-handler of the controller.
 * @return A new notebook controller.
 */
external fun createNotebookController(
  id: String,
  notebookType: String,
  label: String,
  handler: (
    cells: Array<NotebookCell>,
    notebook: NotebookDocument,
    controller: NotebookController,
  ) -> Unit = definedExternally,
): NotebookController
