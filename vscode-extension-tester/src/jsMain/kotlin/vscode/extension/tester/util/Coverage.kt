@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.util

import js.promise.Promise

/**
 * Manages collecting coverage data from test runs. All runs, regardless of
 * platform, expect coverage data given in the V8 coverage format. We then
 * use c8 to convert it to the common Istanbul format and represent it with
 * a variety of reporters.
 */
external class Coverage {
  val targetDir: String
  fun loadConfig(): Promise<Unit>
  fun write(): Promise<Unit>
}
