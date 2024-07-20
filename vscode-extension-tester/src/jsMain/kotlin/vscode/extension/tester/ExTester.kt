@file:JsModule("vscode-extension-tester")

package vscode.extension.tester

import js.promise.Promise
import vscode.extension.tester.util.ReleaseQuality
import vscode.extension.tester.util.RunOptions
import vscode.extension.tester.util.RunOptionsTests

/**
 * ExTester
 */
external class ExTester {
  constructor(
    storageFolder: String = definedExternally,
    releaseType: ReleaseQuality = definedExternally,
    extensionsDir: String = definedExternally,
    coverage: Boolean = definedExternally,
  )

  /**
   * Download VS Code of given version and release quality stream
   *
   * @param version version to download, default latest
   */
  fun downloadCode(version: String = definedExternally): Promise<Unit>

  /**
   * Install the extension into the test instance of VS Code
   */
  fun installVsix(options: VsixOptions = definedExternally): Promise<Unit>

  /**
   * Install an extension from VS Code marketplace into the test instance
   *
   * @param id id of the extension to install
   */
  fun installFromMarketplace(id: String): Promise<Unit>

  /**
   * Download the matching chromedriver for a given VS Code version
   *
   * @param vscodeVersion selected version of VSCode, default latest
   */
  fun downloadChromeDriver(vscodeVersion: String = definedExternally): Promise<String>

  /**
   * Performs all necessary setup: getting VS Code + ChromeDriver
   * and packaging/installing extension into the test instance
   *
   * @param options Additional options for setting up the tests
   */
  fun setupRequirements(
    options: SetupOptions = definedExternally,
    offline: Boolean = definedExternally,
  ): Promise<Unit>

  /**
   * Performs requirements setup and runs extension tests
   *
   * @param testFilesPattern glob pattern(s) for test files to run
   * @param vscodeVersion version of VS Code to test against, defaults to latest
   * @param setupOptions Additional options for setting up the tests
   * @param runOptions Additional options for running the tests
   * @return Promise resolving to the mocha process exit code - 0 for no failures, 1 otherwise
   */
  fun setupAndRunTests(
    testFilesPattern: String,
    vscodeVersion: String = definedExternally,
    setupOptions: RunOptionsTests = definedExternally,
    runOptions: RunOptionsTests = definedExternally,
  ): Promise<Int>

  /**
   * Performs requirements setup and runs extension tests
   *
   * @param testFilesPattern glob pattern(s) for test files to run
   * @param vscodeVersion version of VS Code to test against, defaults to latest
   * @param setupOptions Additional options for setting up the tests
   * @param runOptions Additional options for running the tests
   * @return Promise resolving to the mocha process exit code - 0 for no failures, 1 otherwise
   */
  fun setupAndRunTests(
    testFilesPattern: Array<String>,
    vscodeVersion: String = definedExternally,
    setupOptions: SetupOptionsTests = definedExternally,
    runOptions: SetupOptionsTests = definedExternally,
  ): Promise<Int>

  /**
   * Runs the selected test files in VS Code using mocha and webdriver
   *
   * @param testFilesPattern glob pattern(s) for selected test files
   * @param runOptions Additional options for running the tests
   * @return Promise resolving to the mocha process exit code - 0 for no failures, 1 otherwise
   */
  fun runTests(
    testFilesPattern: String,
    runOptions: RunOptions = definedExternally,
  ): Promise<Int>

  /**
   * Runs the selected test files in VS Code using mocha and webdriver
   *
   * @param testFilesPattern glob pattern(s) for selected test files
   * @param runOptions Additional options for running the tests
   * @return Promise resolving to the mocha process exit code - 0 for no failures, 1 otherwise
   */
  fun runTests(
    testFilesPattern: Array<String>,
    runOptions: RunOptions = definedExternally,
  ): Promise<Int>
}
