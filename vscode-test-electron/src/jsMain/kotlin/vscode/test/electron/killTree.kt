@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

external fun killTree(
  processId: Int,
  force: Boolean,
): Promise<Unit>
