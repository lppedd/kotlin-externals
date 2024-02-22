@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

/**
 * Run VS Code extension test
 *
 * @return The exit code of the command to launch VS Code extension test
 */
external fun runTests(options: TestOptions): Promise<Int>
