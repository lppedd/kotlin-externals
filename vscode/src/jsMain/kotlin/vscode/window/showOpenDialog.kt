@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.OpenDialogOptions
import vscode.Thenable
import vscode.Uri

/**
 * Shows a file open dialog to the user which allows to select a file
 * for opening-purposes.
 *
 * @param options Options that control the dialog.
 * @return A promise that resolves to the selected resources or `undefined`.
 */
external fun showOpenDialog(options: OpenDialogOptions = definedExternally): Thenable<Array<Uri>?>
