@file:JsModule("vscode")
@file:JsQualifier("commands")

package vscode.commands

import vscode.Thenable

/**
 * Retrieve the list of all available commands. Commands starting with an underscore are
 * treated as internal commands.
 *
 * @param filterInternal Set `true` to not see internal commands (starting with an underscore)
 * @return Thenable that resolves to a list of command ids.
 */
external fun getCommands(filterInternal: Boolean = definedExternally): Thenable<Array<String>>
