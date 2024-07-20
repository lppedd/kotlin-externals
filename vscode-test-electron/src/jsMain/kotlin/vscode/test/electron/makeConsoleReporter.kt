@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

/** Default progress reporter that logs VS Code download progress to console */
external val makeConsoleReporter: () -> Promise<ProgressReporter>
