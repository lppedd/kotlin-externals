@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import web.abort.AbortSignal

external class TimeoutController {
  constructor(timeout: Int)

  val signal: AbortSignal

  fun touch()

  fun dispose()
}
