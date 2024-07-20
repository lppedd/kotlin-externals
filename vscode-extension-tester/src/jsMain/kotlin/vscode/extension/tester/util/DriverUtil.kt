@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.util

import js.promise.Promise

/**
 * Handles version checks and download of ChromeDriver
 */
external class DriverUtil {
  /**
   * Create an instance of chrome driver handler
   *
   * @param folder path to a folder to store all artifacts
   */
  constructor(folder: String = definedExternally)

  /**
   * Find a matching ChromeDriver version for a given Chromium version and download it.
   *
   * @param chromiumVersion version of Chromium to match the ChromeDriver against
   */
  fun downloadChromeDriverForChromiumVersion(chromiumVersion: String): Promise<String>

  /**
   * Download a given version ChromeDriver
   *
   * @param version version to download
   */
  fun downloadChromeDriver(version: String): Promise<String>

  fun checkDriverVersionOffline(version: String): Promise<String>

  companion object {
    fun getChromeDriverPlatform(): String?
  }
}
