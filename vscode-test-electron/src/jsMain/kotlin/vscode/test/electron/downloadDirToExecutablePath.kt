@file:JsModule("@vscode/test-electron")

package vscode.test.electron

external fun downloadDirToExecutablePath(
  dir: String,
  platform: DownloadPlatform,
): String
