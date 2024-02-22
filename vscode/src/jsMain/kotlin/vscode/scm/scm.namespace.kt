@file:JsModule("vscode")

package vscode.scm

import vscode.SourceControl
import vscode.SourceControlInputBox

/**
 * The [SourceControlInputBox] for the last source control
 * created by the extension.
 *
 * @deprecated Use [SourceControl.inputBox] instead
 */
external val inputBox: SourceControlInputBox
