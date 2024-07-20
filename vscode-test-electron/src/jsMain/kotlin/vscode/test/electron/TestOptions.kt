package vscode.test.electron

import js.objects.Record
import kotlin.ts.Union

external interface TestOptions {
  /**
   * The VS Code executable path used for testing.
   *
   * If not passed, will use `options.version` to download a copy of VS Code for testing.
   * If `version` is not specified either, will download and use latest stable release.
   */
  var vscodeExecutablePath: String?

  /**
   * Whether VS Code should be launched using default settings and extensions
   * installed on this machine. If `false`, then separate directories will be
   * used inside the `.vscode-test` folder within the project.
   *
   * Defaults to `false`.
   */
  var reuseMachineInstall: Boolean?

  /**
   * Absolute path to the extension root. Passed to `--extensionDevelopmentPath`.
   * Must include a `package.json` Extension Manifest.
   */
  var extensionDevelopmentPath: Union<String, Array<String>>

  /**
   * Absolute path to the extension tests runner. Passed to `--extensionTestsPath`.
   * Can be either a file path or a directory path that contains an `index.js`.
   * Must export a `run` function of the following signature:
   *
   * ```ts
   * function run(): Promise<void>;
   * ```
   *
   * When running the extension test, the Extension Development Host will call this function
   * that runs the test suite. This function should throws an error if any test fails.
   *
   * The first argument is the path to the file specified in `extensionTestsPath`.
   *
   */
  var extensionTestsPath: String

  /**
   * Environment variables being passed to the extension test script.
   */
  var extensionTestsEnv: Record<String, String>?

  /**
   * A list of launch arguments passed to VS Code executable, in addition to `--extensionDevelopmentPath`
   * and `--extensionTestsPath` which are provided by `extensionDevelopmentPath` and `extensionTestsPath`
   * options.
   *
   * If the first argument is a path to a file/folder/workspace, the launched VS Code instance
   * will open it.
   *
   * See `code --help` for possible arguments.
   */
  var launchArgs: Array<String>?

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
   * 	- `win32-arm64-archive		`
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
   * Progress reporter to use while VS Code is downloaded. Defaults to a
   * console reporter. A [SilentReporter] is also available, and you
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
