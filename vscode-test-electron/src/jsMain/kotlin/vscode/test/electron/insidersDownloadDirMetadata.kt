@file:JsModule("@vscode/test-electron")

package vscode.test.electron

external fun insidersDownloadDirMetadata(
  dir: String,
  platform: DownloadPlatform,
): InsidersDownloadDirMetadataResult
