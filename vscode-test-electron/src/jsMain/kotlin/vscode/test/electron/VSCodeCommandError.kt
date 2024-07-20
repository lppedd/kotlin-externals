@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.errors.JsError

external class VSCodeCommandError : JsError {
  constructor(args: Array<String>, exitCode: Int?, stderr: String, stdout: String)

  val exitCode: Int?
  val stderr: String
  var stdout: String
}
