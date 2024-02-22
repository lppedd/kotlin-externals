@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.suite

external fun vscodeAfter(fn: () -> Unit)

external fun vscodeAfter(
  name: String,
  fn: () -> Unit,
)
