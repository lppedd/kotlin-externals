@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import js.array.ReadonlyArray
import js.errors.JsError
import vscode.ExtensionTerminalOptions
import vscode.Terminal
import vscode.TerminalOptions

/**
 * Creates a [Terminal] with a backing shell process. The cwd of the terminal will be the workspace
 * directory if it exists.
 *
 * @param name Optional human-readable string which will be used to represent the terminal in the UI.
 * @param shellPath Optional path to a custom shell executable to be used in the terminal.
 * @param shellArgs Optional args for the custom shell executable. A string can be used on Windows only which
 *   allows specifying shell args in
 *   [command-line format](https://msdn.microsoft.com/en-au/08dfcab2-eb6e-49a4-80eb-87d4076c98c6).
 * @return A new Terminal.
 * @throws [JsError] When running in an environment where a new process cannot be started.
 */
external fun createTerminal(
  name: String = definedExternally,
  shellPath: String = definedExternally,
  shellArgs: ReadonlyArray<String> = definedExternally,
): Terminal

external fun createTerminal(
  name: String = definedExternally,
  shellPath: String = definedExternally,
  shellArgs: String = definedExternally,
): Terminal

/**
 * Creates a [Terminal] with a backing shell process.
 *
 * @param options A TerminalOptions object describing the characteristics of the new terminal.
 * @return A new Terminal.
 * @throws [JsError] When running in an environment where a new process cannot be started.
 */
external fun createTerminal(options: TerminalOptions): Terminal

/**
 * Creates a [Terminal] where an extension controls its input and output.
 *
 * @param options An [ExtensionTerminalOptions] object describing
 * the characteristics of the new terminal.
 * @return A new Terminal.
 */
external fun createTerminal(options: ExtensionTerminalOptions): Terminal
