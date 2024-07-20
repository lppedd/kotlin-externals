@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.array.ReadonlyArray

/** Adds the extensions and user data dir to the arguments for the VS Code CLI */
external fun getProfileArguments(args: ReadonlyArray<String>): Array<String>
