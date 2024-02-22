@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

/**
 * This class contains logic to enable users to opt-in to features that will become standard
 * functionality in the next version of Zowe.
 */
external class NextVerFeatures {
  companion object {
    /**
     * Identify if we should use the V3 error message format. That choice is determined by the value
     * of the ZOWE_V3_ERR_FORMAT environment variable.
     *
     * @return True -> Use the V3 format.
     *
     * TODO:V3_ERR_FORMAT - Remove in V3
     */
    fun useV3ErrFormat(): Boolean
  }
}
