@file:JsModule("vscode")

package vscode.window

import vscode.InputBox

/**
 * Creates a [InputBox] to let the user enter some text input.
 *
 * Note that in many cases the more convenient [vscode.window.showInputBox]
 * is easier to use. [vscode.window.createInputBox] should be used
 * when [vscode.window.showInputBox] does not offer the required flexibility.
 *
 * @return A new [InputBox].
 */
external fun createInputBox(): InputBox
