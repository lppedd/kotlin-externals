@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.errors.JsError

external class TimeoutError : JsError {
  constructor(duration: Int)
}
