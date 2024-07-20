@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.errors.JsError

external class TestRunFailedError : JsError {
  constructor(code: Int = definedExternally, signal: String = definedExternally)

  val code: Int?
  val signal: String?
}
