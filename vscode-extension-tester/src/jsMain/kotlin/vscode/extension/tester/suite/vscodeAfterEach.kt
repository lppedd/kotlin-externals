@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.suite

external fun vscodeAfterEach(fn: () -> Unit)

external fun vscodeAfterEach(
  name: String,
  fn: () -> Unit,
)
