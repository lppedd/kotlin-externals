@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

external class JsUtils {
  companion object {
    /**
     * Is the supplied object empty.
     *
     * @param objToTest The object to test.
     * @return True if empty. False otherwise.
     */
    fun isObjEmpty(objToTest: Any): Boolean

    /**
     * Is the supplied string a URL.
     *
     * @param urlString The string to test.
     * @return True if it is a URL. False otherwise.
     */
    fun isUrl(urlString: String): Boolean
  }
}
