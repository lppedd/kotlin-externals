@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.MessageItem
import vscode.MessageOptions
import vscode.Thenable

/**
 * Show an information message to users. Optionally provide an array of items which will be presented as
 * clickable buttons.
 *
 * @param message The message to show.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun showInformationMessage(
  message: String,
  vararg items: String,
): Thenable<String?>

/**
 * Show an information message to users. Optionally provide an array of items which will be presented as
 * clickable buttons.
 *
 * @param message The message to show.
 * @param options Configures the behaviour of the message.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun showInformationMessage(
  message: String,
  options: MessageOptions,
  vararg items: String,
): Thenable<String?>

/**
 * Show an information message.
 *
 * @see [vscode.window.showInformationMessage]
 *
 * @param message The message to show.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun <T : MessageItem> showInformationMessage(
  message: String,
  vararg items: T,
): Thenable<T?>

/**
 * Show an information message.
 *
 * @see [vscode.window.showInformationMessage]
 *
 * @param message The message to show.
 * @param options Configures the behaviour of the message.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun <T : MessageItem> showInformationMessage(
  message: String,
  options: MessageOptions,
  vararg items: T,
): Thenable<T?>
