@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

external class RestStandAloneUtils {
  companion object {
    /**
     * Obtain user name from a base 64 credential
     *
     * @param auth base 64 encoded credentials
     * @return user name
     */
    fun getUsernameFromAuth(auth: String): String

    /**
     * Obtain password from a base 64 credential
     *
     * @param auth base 64 encoded credentials
     * @return password
     */
    fun getPasswordFromAuth(auth: String): String
  }
}
