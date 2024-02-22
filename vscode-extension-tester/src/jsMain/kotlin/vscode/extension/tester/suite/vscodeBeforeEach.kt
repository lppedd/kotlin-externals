@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.suite

external fun vscodeBeforeEach(fn: () -> Unit)

external fun vscodeBeforeEach(
  name: String,
  fn: () -> Unit,
)
