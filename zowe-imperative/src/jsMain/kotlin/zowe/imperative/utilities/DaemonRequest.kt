@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import zowe.imperative.utilities.doc.IDaemonRequest

/**
 * Class to handle building a daemon request
 */
external class DaemonRequest {
  /**
   * Creates an instance of DaemonRequest.
   */
  constructor(request: IDaemonRequest)

  companion object {
    /**
     * End of writing delimiter
     */
    val EOW_DELIMITER: String

    /**
     * Create daemon request from input options
     */
    fun create(request: IDaemonRequest): String
  }
}
