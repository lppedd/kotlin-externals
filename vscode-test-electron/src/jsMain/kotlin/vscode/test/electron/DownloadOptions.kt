package vscode.test.electron

import kotlin.ts.Union

external interface DownloadOptions {
  val cachePath: String
  val version: DownloadVersion
  val platform: DownloadPlatform
  val extensionDevelopmentPath: (Union<String, Array<String>> /* string | string[] */)?
  val reporter: ProgressReporter?
  val extractSync: Boolean?
  val timeout: Int?
}
