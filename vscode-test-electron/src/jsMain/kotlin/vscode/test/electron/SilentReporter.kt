@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/** Silent progress reporter */
external class SilentReporter : ProgressReporter {
  fun report()

  fun error()

  @Deprecated("Use report()", ReplaceWith("report()"), DeprecationLevel.ERROR)
  override fun report(report: ProgressReport)

  @Deprecated("Use error()", ReplaceWith("error()"), DeprecationLevel.ERROR)
  override fun error(err: Any?)
}
