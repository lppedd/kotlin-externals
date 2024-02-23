@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.CancellationToken
import vscode.InputBoxOptions
import vscode.Thenable

/**
 * Opens an input box to ask the user for input.
 *
 * The returned value will be `undefined` if the input box was canceled (e.g. pressing ESC). Otherwise the
 * returned value will be the string typed by the user or an empty string if the user did not type
 * anything but dismissed the input box with OK.
 *
 * @param options Configures the behavior of the input box.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to a string the user provided or to `undefined` in case of dismissal.
 */
external fun showInputBox(
  options: InputBoxOptions = definedExternally,
  token: CancellationToken = definedExternally,
): Thenable<String?>
