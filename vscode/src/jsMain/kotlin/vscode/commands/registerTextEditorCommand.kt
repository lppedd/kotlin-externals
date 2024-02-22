@file:JsModule("vscode")

package vscode.commands

import vscode.IDisposable
import vscode.TextEditor
import vscode.TextEditorEdit

/**
 * Registers a text editor command that can be invoked via a keyboard shortcut,
 * a menu item, an action, or directly.
 *
 * Text editor commands are different from ordinary [commands.registerCommand commands] as
 * they only execute when there is an active editor when the command is called. Also, the
 * command handler of an editor command has access to the active editor and to an
 * [TextEditorEdit edit]-builder. Note that the edit-builder is only valid while the
 * callback executes.
 *
 * @param command A unique identifier for the command.
 * @param callback A command handler function with access to an [TextEditor] and an [TextEditorEdit].
 * @param thisArg The `this` context used when invoking the handler function.
 * @return Disposable which unregisters this command on disposal.
 */
external fun registerTextEditorCommand(
  command: String,
  callback: (
    textEditor: TextEditor,
    edit: TextEditorEdit,
    args: Array<Any>?,
  ) -> Unit, // (textEditor: TextEditor, edit: TextEditorEdit, ...args: any[]) => void
  thisArg: Any? = definedExternally,
): IDisposable
