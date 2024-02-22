@file:JsModule("@vscode/test-electron")

package vscode.test.electron

external fun getVSCodeDownloadUrl(
  version: String,
  platform: DownloadPlatform = definedExternally,
): String
