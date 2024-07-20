@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import node.childProcess.SpawnOptions
import kotlin.ts.Union

external class RunVSCodeCommandOptions {
  /**
   * Additional options to pass to `child_process.spawn`
   */
  var spawn: SpawnOptions?

  /**
   * Whether VS Code should be launched using default settings and extensions
   * installed on this machine. If `false`, then separate directories will be
   * used inside the `.vscode-test` folder within the project.
   *
   * Defaults to `false`.
   */
  var reuseMachineInstall: Boolean?

  /**
   * The VS Code version to download. Valid versions are:
   * - `'stable'`
   * - `'insiders'`
   * - `'1.32.0'`, `'1.31.1'`, etc
   *
   * Defaults to `stable`, which is latest stable version.
   *
   * *If a local copy exists at `.vscode-test/vscode-<VERSION>`, skip download.*
   */
  var version: DownloadVersion?

  /**
   * The VS Code platform to download. If not specified, it defaults to the
   * current platform.
   *
   * Possible values are:
   * 	- `win32-x64-archive`
   * 	- `win32-arm64-archive`
   * 	- `darwin`
   * 	- `darwin-arm64`
   * 	- `linux-x64`
   * 	- `linux-arm64`
   * 	- `linux-armhf`
   */
  var platform: DownloadPlatform?

  /**
   * Path where the downloaded VS Code instance is stored.
   * Defaults to `.vscode-test` within your working directory folder.
   */
  var cachePath: String?

  /**
   * Absolute path to the extension root. Passed to `--extensionDevelopmentPath`.
   * Must include a `package.json` Extension Manifest.
   */
  var extensionDevelopmentPath: Union<String, Array<String>>?

  /**
   * Progress reporter to use while VS Code is downloaded. Defaults to a
   * console reporter. A {@link SilentReporter} is also available, and you
   * may implement your own.
   */
  var reporter: ProgressReporter?

  /**
   * Whether the downloaded zip should be synchronously extracted. Should be
   * omitted unless you're experiencing issues installing VS Code versions.
   */
  var extractSync: Boolean?

  /**
   * Number of milliseconds after which to time out if no data is received from
   * the remote when downloading VS Code. Note that this is an 'idle' timeout
   * and does not enforce the total time VS Code may take to download.
   */
  var timeout: Int?
}
