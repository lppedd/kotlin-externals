@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.array.ReadonlyArray
import js.promise.Promise

/**
 * Runs a VS Code command, and returns its output.
 *
 * @throws [VSCodeCommandError] if the command fails
 */
external fun runVSCodeCommand(
  _args: ReadonlyArray<String>,
  options: RunVSCodeCommandOptions = definedExternally,
): Promise<StdStreams>
