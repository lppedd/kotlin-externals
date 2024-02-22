@file:JsModule("@vscode/test-electron")

package vscode.test.electron

external fun insidersDownloadDirToExecutablePath(
  dir: String,
  platform: DownloadPlatform,
): String
