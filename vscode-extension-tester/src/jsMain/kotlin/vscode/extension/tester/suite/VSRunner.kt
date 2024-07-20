@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.suite

import js.promise.Promise
import vscode.extension.tester.util.CodeUtil
import vscode.extension.tester.util.ReleaseQuality

/**
 * Mocha runner wrapper
 */
external class VSRunner {
  constructor(
    bin: String,
    codeVersion: String,
    customSettings: Any?,
    cleanup: Boolean?,
    releaseType: ReleaseQuality,
    config: String = definedExternally,
  )

  /**
   * Set up mocha suite, add vscode instance handling, run tests
   *
   * @param testFilesPattern glob pattern of test files to run
   * @param logLevel The logging level for the Webdriver
   * @return The exit code of the mocha process
   */
  fun runTests(
    testFilesPattern: Array<String>,
    code: CodeUtil,
    logLevel: Any?, /* logging.Level? */ // TODO(Edoardo): need selenium externals
    resources: Array<String>,
  ): Promise<Int>
}
