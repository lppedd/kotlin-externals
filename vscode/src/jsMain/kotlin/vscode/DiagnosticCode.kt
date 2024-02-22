package vscode

import kotlin.ts.Union

external interface DiagnosticCode {
  /**
   * A code or identifier for this diagnostic.
   * Should be used for later processing, e.g. when providing code actions ([CodeActionContext]).
   */
  var value: Union<String, Int>

  /**
   * A target URI to open with more information about the diagnostic error.
   */
  var target: Uri
}
