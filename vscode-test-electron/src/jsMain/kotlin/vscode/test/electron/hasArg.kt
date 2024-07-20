@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.array.ReadonlyArray

external fun hasArg(
  argName: String,
  argList: ReadonlyArray<String>,
): Boolean
