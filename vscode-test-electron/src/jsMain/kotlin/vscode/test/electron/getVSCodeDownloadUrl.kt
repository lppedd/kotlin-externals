@file:JsModule("@vscode/test-electron")

package vscode.test.electron

external fun getVSCodeDownloadUrl(
  version: Version,
  platform: String = definedExternally,
): String
