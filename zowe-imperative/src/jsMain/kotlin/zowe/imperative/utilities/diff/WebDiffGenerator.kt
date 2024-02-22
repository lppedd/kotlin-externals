@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities.diff

import js.promise.Promise
import zowe.imperative.utilities.ImperativeConfig
import zowe.imperative.utilities.diff.doc.IWebDiffGenerator

/**
 * Imperative web diff generator. Accepts the diffContent and constructs the whole webb diff browser
 * view
 *
 * @export
 * @class WebDiffGenerator
 */
external class WebDiffGenerator : IWebDiffGenerator<Promise<Unit>> {
  /**
   * Create an instance of WebDiffGenerator.
   *
   * @param config Imperative config containing data about the CLI
   * @param webDiffDir Output directory for web diff files
   */
  constructor(config: ImperativeConfig, webDiffDir: String)

  /**
   * Diff directory builder at the cli home to open the diff strings comparison in the browser.
   */
  override fun buildDiffDir(): Promise<Unit>
}
