@file:JsModule("vscode")

package vscode.workspace

import vscode.Thenable
import vscode.Uri

/**
 * Saves the editor identified by the given resource to a new file name as provided by the user and
 * returns the resulting resource or `undefined` if save was not successful or cancelled or no editor
 * with the given resource was found.
 *
 * **Note** that an editor with the provided resource must be opened in order to be saved as.
 *
 * @param uri the associated uri for the opened editor to save as.
 * @return A thenable that resolves when the save-as operation has finished.
 */
external fun saveAs(uri: Uri): Thenable<Uri?>
