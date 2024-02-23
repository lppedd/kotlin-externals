@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.Thenable
import vscode.Uri

/**
 * Saves the editor identified by the given resource and returns the resulting resource or `undefined`
 * if save was not successful or no editor with the given resource was found.
 *
 * **Note** that an editor with the provided resource must be opened in order to be saved.
 *
 * @param uri the associated uri for the opened editor to save.
 * @return A thenable that resolves when the save operation has finished.
 */
external fun save(uri: Uri): Thenable<Uri?>
