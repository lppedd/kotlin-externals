@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.auth

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession

/**
 * Class to handle logging out of APIML.
 */
external class Logout {
  companion object {
    /**
     * Perform APIML logout to invalidate LTPA2 or other token types.
     */
    fun apimlLogout(session: AbstractSession): Promise<Unit>
  }
}
