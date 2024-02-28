@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.util

import js.promise.Promise

/**
 * Handles the VS Code instance used for testing.
 * Includes downloading, unpacking, launching, and version checks.
 */
external class CodeUtil {
  /**
   * Create an instance of code handler
   * @param folder Path to folder where all the artifacts will be stored.
   * @param extensionsFolder Path to use as extensions directory by VS Code
   */
  constructor(
    folder: String = definedExternally,
    type: ReleaseQuality = definedExternally,
    extensionsFolder: String = definedExternally,
  )

  /**
   * Get all versions for the given release stream
   */
  fun getVSCodeVersions(): Promise<Array<String>>

  /**
   * Download and unpack VS Code for testing purposes
   *
   * @param version VS Code version to get, default latest
   */
  fun downloadVSCode(version: String = definedExternally): Promise<Unit>

  /**
   * Install your extension into the test instance of VS Code
   */
  fun installExtension(
    vsix: String = definedExternally,
    id: String = definedExternally,
  )

  /**
   * Install extension dependencies from marketplace
   */
  fun installDependencies()

  /**
   * Open files/folders in running vscode
   * @param paths vararg paths to files or folders to open
   */
  fun open(vararg paths: String)

  /**
   * Download a vsix file
   * @param vsixURL URL of the vsix file
   */
  fun downloadExtension(vsixURL: String): Promise<String>

  /**
   * Package extension into a vsix file
   * @param useYarn false to use npm as packaging system, true to use yarn instead
   */
  fun packageExtension(useYarn: Boolean = definedExternally): Promise<Unit>

  /**
   * Uninstall the tested extension from the test instance of VS Code
   *
   * @param cleanup remove the extension's directory as well.
   */
  fun uninstallExtension(cleanup: Boolean = definedExternally)

  /**
   * Run tests in your test environment using mocha
   *
   * @param testFilesPattern glob pattern of test files to run
   * @param runOptions additional options for customizing the test run
   *
   * @return The exit code of the mocha process
   */
  fun runTests(
    testFilesPattern: Array<String>,
    runOptions: RunOptions = definedExternally,
  ): Promise<Int>

  /**
   * Finds the version of chromium used for given VS Code version.
   * Works only for versions 1.30+, older versions need to be checked manually
   *
   * @param codeVersion version of VS Code, default latest
   * @param quality release stream, default stable
   */
  fun getChromiumVersion(codeVersion: String = definedExternally): Promise<String>

  /**
   * Check if VS Code exists in local cache along with an appropriate version of chromedriver
   * without internet connection
   */
  fun checkOfflineRequirements(): String

  /**
   * Attempt to get chromium version from a downloaded copy of vs code
   */
  fun getChromiumVersionOffline(): String

  /**
   * Get the root folder of VS Code instance
   */
  fun getCodeFolder(): String
}
