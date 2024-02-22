@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

external fun <T> getJSON(
  api: String,
  timeout: Int,
): Promise<T>
