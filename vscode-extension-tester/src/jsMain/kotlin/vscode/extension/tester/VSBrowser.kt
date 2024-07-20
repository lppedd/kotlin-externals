@file:JsModule("vscode-extension-tester")

package vscode.extension.tester

import js.promise.Promise
import vscode.extension.tester.util.ReleaseQuality

external class VSBrowser {
  constructor(
    codeVersion: String,
    releaseType: ReleaseQuality,
    customSettings: Any = definedExternally,
    logLevel: Any /* logging.Level */ = definedExternally, // TODO(Edoardo): need selenium externals
  )

  /**
   * Starts the vscode browser from a given path
   *
   * @param codePath path to code binary
   */
  fun start(codePath: String): Promise<VSBrowser>

  /**
   * Returns a reference to the underlying instance of Webdriver
   */
  val driver: Any /* WebDriver */ // TODO(Edoardo): need selenium externals

  /**
   * Returns the vscode version as string
   */
  val version: String

  /**
   * Waits until parts of the workbench are loaded
   */
  fun waitForWorkbench(timeout: Int = definedExternally): Promise<Unit>

  /**
   * Terminates the webdriver/browser
   */
  fun quit(): Promise<Unit>

  /**
   * Take a screenshot of the browser
   *
   * @param name file name of the screenshot without extension
   */
  fun takeScreenshot(name: String): Promise<Unit>

  /**
   * Get a screenshots folder path
   *
   * @return string path to the screenshots folder
   */
  fun getScreenshotsDir(): String

  /**
   * Open folder(s) or file(s) in the current instance of vscode.
   *
   * @param paths path(s) of folder(s)/files(s) to open as varargs
   * @return Promise resolving when all selected resources are opened and the workbench reloads
   */
  fun openResources(vararg paths: String): Promise<Unit>

  companion object {
    @JsString("1.37.0")
    val baseVersion: String

    @JsString("vscode")
    val browserName: String

    /**
     * Returns an instance of VSBrowser
     */
    val instance: VSBrowser
  }
}
