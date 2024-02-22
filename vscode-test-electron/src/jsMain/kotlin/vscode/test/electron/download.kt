@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise
import kotlin.ts.Partial

external val fetchStableVersions: (timeout: Int) -> Promise<Array<String>>

external val fetchInsiderVersions: (timeout: Int) -> Promise<Array<String>>

external val defaultCachePath: String

/**
 * Download and unzip a copy of VS Code.
 * @return Promise of `vscodeExecutablePath`.
 */
external fun download(options: @Partial DownloadOptions = definedExternally): Promise<String>
