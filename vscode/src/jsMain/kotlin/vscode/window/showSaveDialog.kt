@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.SaveDialogOptions
import vscode.Thenable
import vscode.Uri

/**
 * Shows a file save dialog to the user which allows to select a file
 * for saving-purposes.
 *
 * @param options Options that control the dialog.
 * @return A promise that resolves to the selected resource or `undefined`.
 */
external fun showSaveDialog(options: SaveDialogOptions = definedExternally): Thenable<Uri?>
