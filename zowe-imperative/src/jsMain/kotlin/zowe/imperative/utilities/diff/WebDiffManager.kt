@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities.diff

import js.promise.Promise
import zowe.imperative.utilities.diff.doc.IWebDiffManager

/**
 * Imperative Web Differences Manager handles the opening of diffs and constructs the dirs and files
 * if necessary
 */
external class WebDiffManager : IWebDiffManager<Promise<Unit>> {
  /**
   * Launch diffs page in browser.
   */
  override fun openDiffs(content: String): Promise<Unit>

  companion object {
    /**
     * Return a singleton instance of this class
     */
    val instance: WebDiffManager
  }
}
