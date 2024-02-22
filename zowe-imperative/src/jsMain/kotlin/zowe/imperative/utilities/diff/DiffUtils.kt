@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities.diff

import js.promise.Promise
import zowe.imperative.utilities.diff.doc.IDiffNameOptions
import zowe.imperative.utilities.diff.doc.IDiffOptions

/**
 * Utilities to get the diff strings and open the diff strings in terminal and in browser
 */
external class DiffUtils {
  companion object {
    /**
     * Get the difference between two string in the form of html, unifiedString and terminal output
     * depending upon the options passed into the functions
     */
    fun getDiffString(
      string1: String,
      string2: String,
      options: IDiffOptions,
    ): Promise<String>

    /**
     * Get the difference between two string in browser
     */
    fun openDiffInbrowser(
      string1: String,
      string2: String,
      options: IDiffNameOptions = definedExternally,
    ): Promise<Unit>
  }
}
