package vscode.test.electron

external interface ProgressReporter {
  fun report(report: ProgressReport)

  fun error(err: Any?)
}
