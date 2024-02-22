@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.suite

external fun vscodeBefore(fn: () -> Unit)

external fun vscodeBefore(
  name: String,
  fn: () -> Unit,
)
