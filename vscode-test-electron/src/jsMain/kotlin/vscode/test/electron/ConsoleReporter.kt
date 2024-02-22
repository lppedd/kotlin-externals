@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/** Default progress reporter that logs VS Code download progress to console */
external class ConsoleReporter : ProgressReporter {
  constructor(showDownloadProgress: Boolean)

  override fun report(report: ProgressReport)

  override fun error(err: Any?)
}
