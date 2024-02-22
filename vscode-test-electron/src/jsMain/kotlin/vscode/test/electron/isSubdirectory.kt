@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/** Gets whether child is a subdirectory of the parent */
external fun isSubdirectory(
  parent: String,
  child: String,
): Boolean
