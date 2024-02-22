@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import zowe.imperative.error.ImperativeError

/**
 * JSON utility to wrap and throw ImperativeErrors
 */
external class JSONUtils {
  companion object {
    /**
     * Throw imperative error or return parsed data
     *
     * @param data string input data to parse as JSON
     * @param failMessage failure message. Default: "Parse of " + data + " failed"
     * @return parsed object. If data length is 0 then this method will return a null object
     * @throws ImperativeError When there was a failure trying to parse a non-zero length data string.
     */
    fun <T : Any> parse(
      data: String,
      failMessage: String = definedExternally,
    ): T
  }
}
