@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.auth

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession

/**
 * Class to handle logging onto APIML.
 */
external class Login {
  companion object {
    /**
     * Perform APIML login to obtain LTPA2 or other token types.
     */
    fun apimlLogin(session: AbstractSession): Promise<String>
  }
}
