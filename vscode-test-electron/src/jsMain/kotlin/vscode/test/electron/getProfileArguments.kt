@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/** Adds the extensions and user data dir to the arguments for the VS Code CLI */
external fun getProfileArguments(args: js.array.ReadonlyArray<String>): Array<String>
