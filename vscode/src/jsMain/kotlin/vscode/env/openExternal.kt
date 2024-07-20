@file:JsModule("vscode")
@file:JsQualifier("env")

package vscode.env

import vscode.Thenable
import vscode.Uri

/**
 * Opens a link externally using the default application.
 * Depending on the used scheme this can be:
 * - a browser (`http:`, `https:`)
 * - a mail client (`mailto:`)
 * - VSCode itself (`vscode:` from `vscode.env.uriScheme`)
 *
 * *Note* that [vscode.window.showTextDocument] is the right
 * way to open a text document inside the editor, not this function.
 *
 * @param target The uri that should be opened.
 * @return A promise indicating if open was successful.
 */
external fun openExternal(target: Uri): Thenable<Boolean>
