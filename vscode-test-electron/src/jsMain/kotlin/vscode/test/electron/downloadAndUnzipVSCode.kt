@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise
import kotlin.ts.Partial

/**
 * Download and unzip a copy of VS Code in `.vscode-test`. The paths are:
 * - `.vscode-test/vscode-<PLATFORM>-<VERSION>`. For example, `./vscode-test/vscode-win32-1.32.0`
 * - `.vscode-test/vscode-win32-insiders`.
 *
 * *If a local copy exists at `.vscode-test/vscode-<PLATFORM>-<VERSION>`, skip download.*
 *
 * @param version The version of VS Code to download such as `1.32.0`. You can also use
 *   - `'stable'` for downloading latest stable release.
 *   - `'insiders'` for downloading latest Insiders.
 *
 *   When unspecified, download latest stable version.
 *
 * @return Promise of `vscodeExecutablePath`.
 */
external fun downloadAndUnzipVSCode(options: @Partial DownloadOptions): Promise<String>

external fun downloadAndUnzipVSCode(
  version: DownloadVersion = definedExternally,
  platform: DownloadPlatform = definedExternally,
  reporter: ProgressReporter = definedExternally,
  extractSync: Boolean = definedExternally,
): Promise<String>
